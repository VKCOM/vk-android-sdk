package com.vk.api.sdk.okhttp

import java.util.concurrent.atomic.AtomicInteger

/**
 * Create emoji prefix for api logging
 * Maps into [com.vk.api.sdk.okhttp.LoggingPrefixer]
 **/
class EmojiLoggingPrefixer : LoggingPrefixer {
    private val id = AtomicInteger(0)

    /**
     * @return emoji in a range from [startEmoji] to [endEmoji]
     **/
    override fun getPrefix(): String {
        val offset = id.getAndIncrement() % EMOJI_COUNT
        return String(Character.toChars(START_EMOJI + offset))
    }

    companion object {
        private const val START_EMOJI: Int = 129292 // 🤌
        private const val END_EMOJI: Int = 129535 // 🧿
        private const val EMOJI_COUNT = END_EMOJI - START_EMOJI + 1
    }
}