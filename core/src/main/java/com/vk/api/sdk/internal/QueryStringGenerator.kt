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

package com.vk.api.sdk.internal

import android.net.Uri
import com.vk.api.sdk.utils.VKUtils
import com.vk.api.sdk.utils.threadLocal

/**
 * Helper object for requests signing.
 */
object QueryStringGenerator {

    private val strBuilder by threadLocal { StringBuilder() }

    /**
     * Build signed query for api method (adds sig param if secret is not null).
     *
     * This method also adds necessary arguments (v & https & (access_token | app_id))
     */
    fun buildSignedQueryStringForMethod(
        methodName: String,
        methodArgs: Map<String, String>,
        methodVersion: String,
        accessToken: String?,
        secret: String?,
        appId: Int
    ): String {
        return buildSignedQueryString(
            path = "/method/$methodName",
            args = methodArgs,
            version = methodVersion,
            accessToken = accessToken,
            secret = secret,
            appId = appId
        )
    }

    /**
     * Build not signed query string (without adding of sig param).
     *
     * This method also adds necessary arguments (v & https & (access_token | app_id))
     *
     * The arrayArgs field is necessary because there is a specificity of sending arrays in the request
     * (e.g. array_name = ["item1", "item2"] should look like ...&array_name[]=item1&array_name[]=item2&...)
     */
    fun buildNotSignedQueryString(
        args: Map<String, String>,
        version: String,
        accessToken: String? = null,
        appId: Int = 0,
        arrayArgs: Map<String, List<String>> = emptyMap()
    ): String {
        return buildSignedQueryString(
            path = "",
            args = args,
            version = version,
            accessToken = accessToken,
            secret = null,
            appId = appId,
            arrayArgs = arrayArgs
        )
    }

    /**
     * Build signed query string for any path.
     *
     * This method also adds necessary arguments (v & https & (access_token | app_id))
     *
     * The arrayArgs field is necessary because there is a specificity of sending arrays in the request
     * (e.g. array_name = ["item1", "item2"] should look like ...&array_name[]=item1&array_name[]=item2&...)
     */
    fun buildSignedQueryString(
        path: String,
        args: Map<String, String>,
        version: String,
        accessToken: String? = null,
        secret: String? = null,
        appId: Int = 0,
        arrayArgs: Map<String, List<String>> = emptyMap()
    ): String {
        // Добавляем параметры, которые нужны всем запросам:
        // Версию api, https=1 (что-то legacy, которое лучше не трогать), AT или api_id
        val actualArgs = args.toMutableMap()
        actualArgs["v"] = version
        actualArgs["https"] = "1"
        if (!accessToken.isNullOrEmpty()) {
            actualArgs["access_token"] = accessToken
        } else if (appId != 0) {
            actualArgs["api_id"] = appId.toString()
        }

        return buildSignedQueryStringForce(path, actualArgs, secret, arrayArgs)
    }

    /**
     * Build signed query without adding any params.
     *
     * The arrayArgs field is necessary because there is a specificity of sending arrays in the request
     * (e.g. array_name = ["item1", "item2"] should look like ...&array_name[]=item1&array_name[]=item2&...)
     */
    fun buildSignedQueryStringForce(
        path: String,
        args: Map<String, String>,
        secret: String?,
        arrayArgs: Map<String, List<String>> = emptyMap()
    ): String {
        // Закидываем всё в Uri, чтоб получить энкодинг из коробки
        val uriBuilder = Uri.Builder()
        args.entries.forEach {
            // Пропускаем sig, т.к. мы должны сами построить правильную подпись
            if (it.key != "sig") {
                uriBuilder.appendQueryParameter(it.key, it.value)
            }
        }

        arrayArgs.entries.forEach { (key, list) ->
            list.forEach { listItem ->
                uriBuilder.appendQueryParameter("$key[]", listItem)
            }
        }

        val uri = uriBuilder.build()

        // В случае, если подпись не нужна, просто возвращаем правильно заэнкоженные параметры
        if (secret.isNullOrEmpty()) {
            return uri.encodedQuery ?: ""
        }

        // Подпись строится по следующему принципу:
        // Берется path ("/method/friends.get"), через ? добавляются все GET-параметры (задекоженные!), в конце добавляется secret
        // Из полученной строчки считается MD5
        // Пример:
        // path: /method/friends.get
        // GET-параметры: a -> b, c -> d&f
        // secret: secret
        // Строчка для высчитывания MD5: /method/friends.get?a=b&c=d&fsecret
        // MD5: babca39b9d77e25f757baf504baa55d7

        val decodedQuery = uri.query

        strBuilder.setLength(0)
        strBuilder.append(path).append('?')
        if (!decodedQuery.isNullOrBlank()) {
            strBuilder.append(decodedQuery)
        }
        strBuilder.append(secret)

        val queryToSign = strBuilder.toString()
        val signature = VKUtils.MD5.convert(queryToSign)

        val signedUri = uri.buildUpon()
            .appendQueryParameter("sig", signature)
            .build()

        return signedUri.encodedQuery ?: ""
    }
}