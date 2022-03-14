package com.vk.api.sdk.extensions

import okio.buffer
import okio.source
import java.io.InputStream
import java.nio.charset.Charset

fun InputStream.readString(charset: Charset = Charsets.UTF_8): String =
    use { stream ->
        stream.source().buffer().use { source ->
            source.readString(charset)
        }
    }