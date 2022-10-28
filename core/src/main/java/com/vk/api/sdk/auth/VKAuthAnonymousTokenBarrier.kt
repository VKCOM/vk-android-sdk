package com.vk.api.sdk.auth

import java.util.concurrent.locks.ReentrantLock

class VKAuthAnonymousTokenBarrier {
    private val lock = ReentrantLock(true)
    fun tryLockOrAwait(function: () -> Unit) {
        try {
            if (lock.tryLock()) {
                function.invoke()
            } else {
                lock.lock()
            }
        } finally {
            lock.unlock()
        }
    }
}