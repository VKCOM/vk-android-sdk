package com.vk.api.sdk.utils

import android.content.Context
import android.os.SystemClock
import java.util.concurrent.ConcurrentHashMap
import kotlin.math.min

/**
 * Exponential backoff который привязан к токенам,токеном как правило является url запроса
 *
 * Для токенов необходим стор, есть 2 основные реализации
 * - TokenPrefStore: НЕ УМЕЕТ привязывать try count к токену и всегда возвращает 0, хранит токены в SharedPreference
 * - TokenMemStore: УМЕЕТ работать с try count, т.к. не забирает никаких накладных расходов, хранит токены в HashMap
 */
class RateLimitTokenBackoff(
    private val store: TokenStore,
    private val minBackoffTime: Long,
    private val maxBackoffTime: Long = minBackoffTime,
    private val factor: Float = 1.5f,
    private val timeProvider: () -> Long = { SystemClock.elapsedRealtime() }
) {

    fun shouldWait(operationKey: String): Boolean {
        return waitTime(operationKey) > 0
    }

    fun waitTime(operationKey: String): Long {
        if (!store.has(operationKey)) {
            return 0L
        }

        val (value, count) = store.restore(operationKey, Long.MAX_VALUE)
        val currTime = time()

        val elapsedTime = currTime - value
        val backoffTimeMs = calculate(count)

        //we don't want to handle device reboot
        if (elapsedTime < 0) {
            return 0L
        }

        if (elapsedTime >= backoffTimeMs) {
            return 0L
        }

        return backoffTimeMs - elapsedTime
    }

    fun reset(operationKey: String) {
        if (!store.has(operationKey)) {
            return
        }

        store.reset(operationKey)
    }

    fun backoff(operationKey: String) {
        store.store(operationKey, time())
    }

    private fun time(): Long {
        return timeProvider.invoke()
    }

    private fun calculate(retry: Int): Long {
        var acum = minBackoffTime

        repeat(retry) { // if 0 - minBackoffTime
            acum = (acum * factor).toLong()
        }

        return min(acum, maxBackoffTime)
    }

    interface TokenStore {
        fun has(token: String): Boolean
        fun reset(token: String)
        fun restore(token: String, default: Long): Pair<Long, Int>
        fun store(token: String, value: Long)
    }

    /**
     * Unsupported counter yet
     */
    class TokenPrefStore(context: Context) : TokenStore {

        private val prefStorage by lazy {
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }

        override fun has(token: String): Boolean {
            return prefStorage
                .contains(token)
        }

        override fun reset(token: String) {
            prefStorage.edit()
                .remove(token)
                .apply()
        }

        override fun restore(token: String, default: Long): Pair<Long, Int> {
            return prefStorage
                .getLong(token, default) to 0
        }

        override fun store(token: String, value: Long) {
            prefStorage.edit()
                .putLong(token, value)
                .apply()
        }

        companion object {
            private const val PREF_NAME = "rate_limit_backoff_storage"
        }
    }

    class TokenMemStore : TokenStore {

        private val storage = ConcurrentHashMap<String, Pair<Long, Int>>()
        private val obj = Any()

        override fun has(token: String): Boolean {
            return storage.containsKey(token)
        }

        override fun reset(token: String) {
            synchronized(obj) {
                storage.remove(token)
            }
        }

        override fun restore(token: String, default: Long): Pair<Long, Int> {
            return storage[token] ?: default to 0
        }

        override fun store(token: String, value: Long) {
            synchronized(obj) {
                val count = storage[token]?.second?.inc() ?: 0
                storage[token] = value to count
            }
        }
    }
}