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
/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 vk.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package com.vk.api.sdk.auth

import android.os.Bundle
import com.vk.api.sdk.VKKeyValueStorage
import com.vk.dto.common.id.UserId
import com.vk.dto.common.id.toUserId
import java.util.*

class VKAccessToken(params: Map<String, String?>) {
    internal constructor(userId: UserId, accessToken: String, secret: String?) : this(
            mapOf(USER_ID to userId.toString(),
                  ACCESS_TOKEN to accessToken,
                  SECRET to secret,
                  HTTPS_REQUIRED to "1"
            )
    )

    val userId: UserId
    val accessToken: String
    val secret: String?
    val created: Long
    val email: String?
    val phone: String?
    val phoneAccessKey: String?
    private val httpsRequired: Boolean
    private val expirationDate: Long

    val isValid: Boolean
        get() = expirationDate <= 0 || created + expirationDate * 1000 > System.currentTimeMillis()

    init {
        this.userId = params[USER_ID]?.toLong()?.toUserId()!!
        this.accessToken = params[ACCESS_TOKEN]!!
        this.secret = params[SECRET]
        this.httpsRequired = "1" == params[HTTPS_REQUIRED]
        this.created = if (params.containsKey(CREATED)) params[CREATED]!!.toLong() else System.currentTimeMillis()
        this.expirationDate = if (params.containsKey(EXPIRES_IN)) params[EXPIRES_IN]!!.toLong() else -1
        this.email = if (params.containsKey(EMAIL)) params[EMAIL] else null
        this.phone = if (params.containsKey(PHONE)) params[PHONE] else null
        this.phoneAccessKey = if (params.containsKey(PHONE_ACCESS_KEY)) params[PHONE_ACCESS_KEY] else null
    }

    fun save(bundle: Bundle) {
        val vkTokenBundle = Bundle()
        val tokenParams = toMap()
        for ((key, value) in tokenParams) {
            vkTokenBundle.putString(key, value)
        }
        bundle.putBundle(VK_ACCESS_TOKEN_KEY, vkTokenBundle)
    }

    fun save(storage: VKKeyValueStorage) {
        val tokenParams = toMap()
        for ((key, value) in tokenParams) {
            storage.putOrRemove(key, value)
        }
    }

    private fun toMap(): Map<String, String?> {
        val result = HashMap<String, String?>()
        result[ACCESS_TOKEN] = accessToken
        result[SECRET] = secret
        result[HTTPS_REQUIRED] = if (httpsRequired) "1" else "0"
        result[CREATED] = created.toString()
        result[EXPIRES_IN] = expirationDate.toString()
        result[USER_ID] = userId.toString()
        result[EMAIL] = email
        result[PHONE] = phone
        result[PHONE_ACCESS_KEY] = phoneAccessKey
        return result
    }

    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val EXPIRES_IN = "expires_in"
        private const val USER_ID = "user_id"
        private const val SECRET = "secret"
        private const val HTTPS_REQUIRED = "https_required"
        private const val CREATED = "created"
        private const val VK_ACCESS_TOKEN_KEY = "vk_access_token"
        private const val EMAIL = "email"
        private const val PHONE = "phone"
        private const val PHONE_ACCESS_KEY = "phone_access_key"

        val KEYS = listOf(
                ACCESS_TOKEN,
                EXPIRES_IN,
                USER_ID,
                SECRET,
                HTTPS_REQUIRED,
                CREATED,
                VK_ACCESS_TOKEN_KEY,
                EMAIL,
                PHONE,
                PHONE_ACCESS_KEY
        )

        fun restore(bundle: Bundle?): VKAccessToken? {
            if (bundle == null) {
                return null
            }
            val vkTokenBundle = bundle.getBundle(VK_ACCESS_TOKEN_KEY) ?: return null
            val tokenParams = HashMap<String, String?>()
            for (key in vkTokenBundle.keySet()) {
                tokenParams[key] = vkTokenBundle.getString(key)
            }
            return VKAccessToken(tokenParams)
        }

        fun remove(keyValueStorage: VKKeyValueStorage) {
            KEYS.forEach { keyValueStorage.remove(it) }
        }

        fun restore(keyValueStorage: VKKeyValueStorage): VKAccessToken? {
            val tokenParams = HashMap<String, String?>(KEYS.size)
            for (key in KEYS) {
                keyValueStorage.get(key)?.let {
                    tokenParams[key] = it
                }
            }

            return if (tokenParams.containsKey(ACCESS_TOKEN) && tokenParams.containsKey(USER_ID)) {
                VKAccessToken(tokenParams)
            }
            else null
        }
    }
}
