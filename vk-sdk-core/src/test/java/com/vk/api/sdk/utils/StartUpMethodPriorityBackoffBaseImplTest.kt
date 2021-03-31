package com.vk.api.sdk.utils

import com.vk.api.sdk.utils.log.Logger
import org.junit.Assert
import org.junit.Test
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class StartUpMethodPriorityBackoffBaseImplTest {

    private lateinit var backOff: StartUpMethodPriorityBackoffBaseImpl

    private val executor = Executors.newFixedThreadPool(4)

    @Test
    fun `empty priority`() {
        val methodName = "test.method"
        backOff = createBackOff()
        Assert.assertFalse(backOff.isActive())
        Assert.assertFalse(backOff.shouldWait(methodName))

        val id = backOff.newId()

        //check that we don't block
        executor.submit {
            backOff.processMethod(id, methodName)
        }.get(StartUpMethodPriorityBackoffBaseImpl.METHOD_WAIT_TIMEOUT / 2, TimeUnit.MILLISECONDS)
    }

    @Test
    fun `priority methods`() {
        val priorityMethod = "priority.method"
        val nonPriorityMethod = "non_priority.method"
        backOff = createBackOff(startUpPriorityMethods = listOf(priorityMethod))

        Assert.assertTrue(backOff.isActive())
        Assert.assertTrue(backOff.shouldWait(nonPriorityMethod))

        val id = backOff.newId()
        val nonPriorityFuture = executor.submit {
            backOff.processMethod(id, nonPriorityMethod)
        }

        Assert.assertFalse(backOff.shouldWait(priorityMethod))

        nonPriorityFuture.get(StartUpMethodPriorityBackoffBaseImpl.METHOD_WAIT_TIMEOUT / 2, TimeUnit.MILLISECONDS)

        Assert.assertFalse(backOff.shouldWait(nonPriorityMethod))

        Assert.assertFalse(backOff.isActive())
    }

    @Test
    fun `exception methods`() {
        val priorityMethod = "priority.method"
        val exceptionMethod = "exception.method"
        val nonPriorityMethod = "non_priority.method"
        backOff = createBackOff(startUpPriorityMethods = listOf(priorityMethod), exceptionMethods = listOf(exceptionMethod))

        Assert.assertTrue(backOff.isActive())
        Assert.assertTrue(backOff.shouldWait(nonPriorityMethod))
        Assert.assertFalse(backOff.shouldWait(exceptionMethod))

        var nonPriorityWasCalled = false

        val nonPriorityFuture = executor.submit {
            backOff.processMethod(backOff.newId(), nonPriorityMethod)
            nonPriorityWasCalled = true
        }

        Thread.sleep(100)

        Assert.assertFalse(nonPriorityWasCalled)

        Assert.assertFalse(backOff.shouldWait(priorityMethod))

        nonPriorityFuture.get(StartUpMethodPriorityBackoffBaseImpl.METHOD_WAIT_TIMEOUT / 2, TimeUnit.MILLISECONDS)

        Assert.assertTrue(nonPriorityWasCalled)
        Assert.assertFalse(backOff.shouldWait(nonPriorityMethod))

        Assert.assertFalse(backOff.isActive())
    }

    @Test
    fun `clear before priority`() {
        val priorityMethod = "priority.method"
        val nonPriorityMethod = "non_priority.method"
        backOff = createBackOff(startUpPriorityMethods = listOf(priorityMethod))

        Assert.assertTrue(backOff.isActive())

        backOff.clear()

        Assert.assertFalse(backOff.shouldWait(nonPriorityMethod))
        Assert.assertFalse(backOff.shouldWait(priorityMethod))
        Assert.assertFalse(backOff.isActive())
    }

    private fun createBackOff(
        startUpPriorityMethods: Collection<String> = listOf(),
        exceptionMethods: Collection<String> = listOf()
    ) =
        StartUpMethodPriorityBackoffBaseImpl(
            startUpPriorityMethods = startUpPriorityMethods,
            exceptionMethods = exceptionMethods,
            logger = object : Logger  {

                override val logLevel = lazy {
                    Logger.LogLevel.NONE
                }
                override val tag: String = "test"

                override fun log(level: Logger.LogLevel, msg: String?, err: Throwable?) {
                    //do nothing
                }
            }
        )
}