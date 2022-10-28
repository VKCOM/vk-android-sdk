package com.vk.api.sdk.utils

import com.vk.api.sdk.utils.log.Logger
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * base implementation of [ApiMethodPriorityBackoff]
 * it keeps clientId to [Condition] pairs into locks and if we need to wait until priority methods will be called
 * or startUpMethodsQueue will be cleared.
 *
 * Here we use [ReentrantLock] with [Condition] to avoid the situation with unneeded awaiting
 *
 * thr default wait timeout for the method is 500ms
 *
 * @param startUpPriorityMethods - list of priority methods all other methods execution will be blocked
 * until startUpMethodsQueue will become empty or clear method will be called
 * @param exceptionMethods - method names which will be skipped for the checking
 * @param startUpHeavyMethods method names which will wait for startup process to complete
 * @shouldRestrictHeavyRequestsOnStartUp whether to respect startUpHeavyMethods field
 * @shouldWaitForStartUpPriorityRequestsCompletion if true, priority methods will be removed from startUpMethodsQueue
 * only after its' completion, otherwise once called
 * @param logger - [Logger] instance
 */
class StartUpMethodPriorityBackoffBaseImpl(
    startUpPriorityMethods: Collection<String>,
    private val exceptionMethods: Collection<String>,
    private val startUpHeavyMethods: Collection<String>,
    private val shouldRestrictHeavyRequestsOnStartUp: Boolean,
    private val shouldWaitForStartUpPriorityRequestsCompletion: Boolean,
    private val logger: Logger
) : ApiMethodPriorityBackoff {

    private val locks: MutableMap<Int, Condition> = mutableMapOf()
    private val heavyLocksIds = mutableSetOf<Int>()
    private val notifiedLocksIds = mutableSetOf<Int>()
    private val operationsLock = ReentrantLock()
    private val methodNames: MutableMap<Int, String> = mutableMapOf()
    // startup is considered to be complete once message queue was emptied OR clear() was called
    @Volatile private var startupCompleted = false

    private val startUpPriorityMethodsQueue = CopyOnWriteArrayList<String>().apply {
        addAll(startUpPriorityMethods)
    }

    override fun isActive(): Boolean = startUpPriorityMethodsQueue.isNotEmpty() ||
            (!startupCompleted && shouldRestrictHeavyRequestsOnStartUp)

    override fun newId(): Int {
        val newId = idGenerator.incrementAndGet()
        operationsLock.withLock {
            locks[newId] = operationsLock.newCondition()
        }
        return newId
    }

    override fun shouldWait(methodName: String): Boolean {
        operationsLock.withLock {
            if (exceptionMethods.contains(methodName)) {
                notifyAwaiters(methodName)
                return false
            }

            if (!startupCompleted && shouldRestrictHeavyRequestsOnStartUp && startUpHeavyMethods.contains(methodName)) {
                return true
            }

            val shouldWait = startUpPriorityMethodsQueue.isNotEmpty() && !startUpPriorityMethodsQueue.contains(methodName)
            if (!shouldWait) {
                if (!shouldWaitForStartUpPriorityRequestsCompletion) {
                    notifyAwaiters(methodName)
                }
            }
            return shouldWait
        }
    }

    override fun processMethod(clientId: Int, methodName: String) {
        operationsLock.withLock {
            val condition = locks[clientId] ?: return
            methodNames[clientId] = methodName
            if (shouldWait(methodName)) {
                logger.debug("method $methodName will wait, " +
                        "queue.size = ${startUpPriorityMethodsQueue.size}, " +
                        "startupCompleted = $startupCompleted")

                if (shouldRestrictHeavyRequestsOnStartUp && startUpHeavyMethods.contains(methodName)) {
                    logger.debug("method $methodName will wait for start up completion")
                    heavyLocksIds += clientId
                    condition.await()
                    logger.debug("method $methodName awoke after waiting for start up completion")
                } else if (shouldWaitForStartUpPriorityRequestsCompletion) {
                    logger.debug("method $methodName will wait for priority requests completion")
                    condition.await()
                    logger.debug("method $methodName awoke after waiting for priority requests completion")
                } else {
                    logger.debug("method $methodName will wait for $METHOD_WAIT_TIMEOUT ms")
                    condition.await(METHOD_WAIT_TIMEOUT, TimeUnit.MILLISECONDS)
                    logger.debug("method $methodName awoke after waiting for $METHOD_WAIT_TIMEOUT ms")
                }
            }
        }
    }

    override fun onStartUpCompleted() {
        operationsLock.withLock {
            if (startupCompleted) {
                return
            }

            logger.debug("startup completed")
            startupCompleted = true
            startUpPriorityMethodsQueue.clear()
            notifyLocks(lightOnly = false)
        }
    }

    override fun onMethodCompleted(methodName: String) {
        operationsLock.withLock {
            notifyAwaiters(methodName)
        }
    }

    override fun clear() {
        operationsLock.withLock {
            logger.debug("clear was called")

            onStartUpCompleted()
        }
    }

    private fun notifyLocks(lightOnly: Boolean) {
        logger.debug("notifying ${ if (lightOnly) "light only" else "all" } locks")

        for (lockId in locks.keys) {
            if (notifiedLocksIds.contains(lockId)) {
                continue
            }

            if (!lightOnly || !heavyLocksIds.contains(lockId)) {
                logger.debug("notifying lock for ${methodNames[lockId]}")
                locks[lockId]?.signalAll()
                notifiedLocksIds.add(lockId)
            }
        }
    }

    private fun notifyAwaiters(methodName: String) {
        logger.debug("notifyMethodCall: $methodName")

        if (startUpPriorityMethodsQueue.remove(methodName)) {
            logger.debug("removed method $methodName from priority queue")
        }

        if (startUpPriorityMethodsQueue.isEmpty()) {
            logger.debug("priority queue is empty, notifying")
            notifyLocks(lightOnly = true)
            return
        }
    }

    private fun Logger.debug(msg: String) {
        logger.log(Logger.LogLevel.DEBUG, "StartUpMethodPriorityBackoffBaseImpl: $msg")
    }

    internal companion object {
        internal const val METHOD_WAIT_TIMEOUT = 500L
        private val idGenerator = AtomicInteger()
    }
}