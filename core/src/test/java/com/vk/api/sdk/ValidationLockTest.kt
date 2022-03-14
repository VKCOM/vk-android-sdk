package com.vk.api.sdk

import org.junit.Assert
import org.junit.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


class ValidationLockTest {

    private val executor = Executors.newFixedThreadPool(3)

    @Test
    fun awaitNotAcquired() {
        val validationLock = VKApiValidationHandler.ValidationLock()
        val future: Future<Int> =  executor.submit(Callable {
            validationLock.await()
            1
        })
        Assert.assertEquals(1, future.get(1000, TimeUnit.MILLISECONDS))

    }

    @Test
    fun awaitAcquired() {
        val validationLock = VKApiValidationHandler.ValidationLock()
        validationLock.acquire()
        val future: Future<Int> =  executor.submit(Callable {
            validationLock.await()
            1
        })
        val future2 =  executor.submit(Callable {
            future.get(1000, TimeUnit.MILLISECONDS)
        })
        validationLock.release()
        Assert.assertEquals(1, future2.get(1000, TimeUnit.MILLISECONDS))
    }

    @Test
    fun awaitAcquiredNotReleased() {
        val validationLock = VKApiValidationHandler.ValidationLock()
        validationLock.acquire()
        val future: Future<Int> =  executor.submit(Callable {
            validationLock.await()
            1
        })
        try {
            future.get(100, TimeUnit.MILLISECONDS)
        } catch (ex: Throwable) {
            Assert.assertEquals(TimeoutException::class.java, ex::class.java)
        }
    }

    @Test
    fun doubleAcquire() {
        val validationLock = VKApiValidationHandler.ValidationLock()
        Assert.assertTrue(validationLock.acquire())
        Assert.assertFalse(validationLock.acquire())
    }
}