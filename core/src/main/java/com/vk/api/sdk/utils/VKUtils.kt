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

@file:Suppress("DEPRECATION", "unused")

package com.vk.api.sdk.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Point
import android.net.Uri
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import androidx.annotation.RequiresApi
import okio.Buffer
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

object VKUtils {
    @JvmStatic
    fun isAppInstalled(context: Context, packageName: String): Boolean {
        return try {
            context.packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: Throwable) {
            false
        }
    }

    @JvmStatic
    fun isAppEnabled(context: Context, packageName: String): Boolean {
        return try {
            context.packageManager.getApplicationInfo(packageName, 0).enabled
        } catch (e: Throwable) {
            false
        }
    }

    /**
     * @param allowedPackage the only package that allowed for that action
     */
    @JvmStatic
    fun isIntentAvailable(context: Context, action: String, data: Uri?, allowedPackage: String): Boolean {
        val resolveInfos = context.packageManager
            ?.queryIntentActivities(Intent(action, data), PackageManager.MATCH_DEFAULT_ONLY)
            ?: return false
        return resolveInfos.any { it.activityInfo.packageName == allowedPackage }
    }

    @JvmStatic
    fun explodeQueryString(queryString: String?): MutableMap<String, String>? {
        if (queryString == null) {
            return null
        }
        val keyValuePairs = queryString.split("&")
        val parameters = HashMap<String, String>(keyValuePairs.size)

        for (keyValueString in keyValuePairs) {
            val keyValueArray = keyValueString.split("=")
            if (keyValueArray.size > 1) {
                parameters[keyValueArray[0]] = keyValueArray[1]
            }
        }
        return parameters
    }

    @SuppressLint("Assert")
    @JvmStatic
    fun getCertificateFingerprint(context: Context?, packageName: String): Array<String?>? {
        try {
            if (context == null || context.packageManager == null) {
                return null
            }

            @SuppressLint("PackageManagerGetSignatures")
            val info = context.packageManager.getPackageInfo(
                    packageName,
                    PackageManager.GET_SIGNATURES)

            if (info.signatures == null) {
                return null
            }

            val result = arrayOfNulls<String>(info.signatures.size)
            var i = 0
            info.signatures.forEach {
                val md = MessageDigest.getInstance("SHA")
                md.update(it.toByteArray())
                result[i++] = toHex(md.digest())
            }
            return result
        } catch (e: Exception) {
            return null
        }
    }

    @Suppress("DEPRECATION")
    fun clearAllCookies(context: Context) {
        val cookieManager = CookieManager.getInstance()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookies(null)
        } else {
            val cookieSyncManager = CookieSyncManager.createInstance(context)
            cookieSyncManager.startSync()
            cookieManager.removeAllCookie()
            cookieSyncManager.stopSync()
        }
    }

    private fun toHex(bytes: ByteArray): String {
        val bi = BigInteger(1, bytes)
        return String.format("%0" + (bytes.size shl 1) + "X", bi)
    }

    fun dp(dp: Int) = Math.ceil((dp * density()).toDouble()).toInt()

    fun density() = getDisplayMetrics().density

    fun getDisplayMetrics(): DisplayMetrics = Resources.getSystem().displayMetrics

    fun height(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }

    fun width(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

    fun getPhysicalDisplaySize(context: Context): Point {
        val size = Point()
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        if (Build.VERSION.SDK_INT >= 23) {
            getDisplaySizeV23(display, size)
        } else {
            getDisplaySizePreV23(display, size)
        }
        return size
    }

    private fun getDisplaySizePreV23(display: Display?, size: Point) {
        display?.getRealSize(size)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getDisplaySizeV23(display: Display?, size: Point) {
        val mode = display?.mode
        size.x = mode?.physicalWidth ?: 0
        size.y = mode?.physicalHeight ?: 0
    }

    @JvmStatic
    fun toHumanReadableAscii(string: String?): String {
        if (string == null) return ""
        var i = 0
        while (i < string.length) {
            var c = string.codePointAt(i)
            if (c in 0x20 .. 0x7e) {
                i += Character.charCount(c)
                continue
            }

            val buffer = Buffer()
            buffer.writeUtf8(string, 0, i)
            while (i < string.length) {
                c = string.codePointAt(i)
                buffer.writeUtf8CodePoint(if (c in 0x20 .. 0x7e) c else '?'.toInt())
                i += Character.charCount(c)
            }
            return buffer.readUtf8()
        }
        return string
    }

    object MD5 {
        private val hex = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
        private val tmpBuilder by threadLocal { StringBuilder() }

        @JvmStatic
        fun convert(h: String): String {
            try {
                val md = MessageDigest.getInstance("MD5")
                val md5 = md.digest(h.toByteArray(charset("UTF-8")))

                tmpBuilder.setLength(0)
                hex(md5)
                return tmpBuilder.toString()
            } catch (ignored: Exception) {
            }
            return ""
        }

        @JvmStatic
        private fun hex(b: ByteArray) {
            for (aB in b) {
                tmpBuilder.append(hex[aB.toInt() and (0xF0).toInt() shr 4])
                tmpBuilder.append(hex[aB.toInt() and (0x0F).toInt()])
            }
        }
    }
}