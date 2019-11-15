package com.vk.api.sdk

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

/**
 * Internal scheduler with executor for making async api requests
 * Is's used in VK.execute
 */
internal object VKScheduler {
    private const val NETWORK_THREADS_COUNT = 32
    private val counter = AtomicInteger()
    private val handler by lazy { Handler(Looper.getMainLooper()) }

    /**
     * Network executor with cached thread pool.
     * Intended to perform network requests: makes new thread every time if cached threads are busy
     * or reuse idle thread.
     */
    val networkExecutor: ExecutorService by lazy {
        Executors.newFixedThreadPool(NETWORK_THREADS_COUNT) { runnable ->
            Thread(runnable, "vk-api-network-thread-${counter.getAndIncrement()}")
        }
    }

    @JvmOverloads
    @JvmStatic
    fun runOnMainThread(runnable: Runnable, delay: Long = 0) {
        if (Looper.myLooper() == Looper.getMainLooper() && delay == 0L) {
            runnable.run()
        } else {
            handler.postDelayed(runnable, delay)
        }
    }
}