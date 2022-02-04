/**
 * Copyright (c) 2020 - present, LLC “V Kontakte”
 *
 * 1. Permission is hereby granted to any person obtaining a copy of this Software to
 * use the Software without charge.
 *
 * 2. Restrictions
 * You may not modify, merge, publish, distribute, sublicense, and/or sell copies,
 * create derivative works based upon the Software or any part thereof.
 *
 * 3. Termination
 * This License is effective until terminated. LLC “V Kontakte” may terminate this
 * License at any time without any negative consequences to our rights.
 * You may terminate this License at any time by deleting the Software and all copies
 * thereof. Upon termination of this license for any reason, you shall continue to be
 * bound by the provisions of Section 2 above.
 * Termination will be without prejudice to any rights LLC “V Kontakte” may have as
 * a result of this agreement.
 *
 * 4. Disclaimer of warranty and liability
 * THE SOFTWARE IS MADE AVAILABLE ON THE “AS IS” BASIS. LLC “V KONTAKTE” DISCLAIMS
 * ALL WARRANTIES THAT THE SOFTWARE MAY BE SUITABLE OR UNSUITABLE FOR ANY SPECIFIC
 * PURPOSES OF USE. LLC “V KONTAKTE” CAN NOT GUARANTEE AND DOES NOT PROMISE ANY
 * SPECIFIC RESULTS OF USE OF THE SOFTWARE.
 * UNDER NO CIRCUMSTANCES LLC “V KONTAKTE” BEAR LIABILITY TO THE LICENSEE OR ANY
 * THIRD PARTIES FOR ANY DAMAGE IN CONNECTION WITH USE OF THE SOFTWARE.
*/
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
 * @param logger - [Logger] instance
 */
class StartUpMethodPriorityBackoffBaseImpl(
    startUpPriorityMethods: Collection<String>,
    private val exceptionMethods: Collection<String>,
    private val logger: Logger
) : ApiMethodPriorityBackoff {

    private val locks: MutableMap<Int, Condition> = mutableMapOf()
    private val operationsLock = ReentrantLock()

    private val startUpMethodsQueue = CopyOnWriteArrayList<String>().apply {
        addAll(startUpPriorityMethods)
    }

    override fun isActive(): Boolean = startUpMethodsQueue.isNotEmpty()

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
            val wait = startUpMethodsQueue.isNotEmpty() && !startUpMethodsQueue.contains(methodName)
            if (!wait) {
                notifyAwaiters(methodName)
            }
            return wait
        }
    }

    override fun processMethod(clientId: Int, methodName: String) {
        operationsLock.withLock {
            val condition = locks[clientId] ?: return
            if (shouldWait(methodName)) {
                logger.debug("should wait for $methodName queue.size:${startUpMethodsQueue.size}")
                condition.await(METHOD_WAIT_TIMEOUT, TimeUnit.MILLISECONDS)
            }
        }
    }

    override fun clear() {
        operationsLock.withLock {
            logger.debug("clear startup method queue")
            startUpMethodsQueue.clear()
            notifyLocks()
            locks.clear()
        }
    }

    private fun notifyLocks() {
        locks.values.forEach { lock ->
            lock.signalAll()
        }
    }

    private fun notifyAwaiters(methodName: String) {
        logger.debug("notifyMethodCall:$methodName")
        if (startUpMethodsQueue.isEmpty()) {
            notifyLocks()
            return
        }
        if (startUpMethodsQueue.contains(methodName)) {
            startUpMethodsQueue.remove(methodName)
            logger.debug("remove method from name $methodName")
            notifyLocks()
        }
    }

    private fun Logger.debug(msg: String) {
        logger.log(Logger.LogLevel.DEBUG, "StartUpMethodPriorityBackoffBaseImpl:$msg")
    }

    internal companion object {
        internal const val METHOD_WAIT_TIMEOUT = 500L
        private val idGenerator = AtomicInteger()
    }
}