/**
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
*/
// *********************************************************************
// THIS FILE IS AUTO GENERATED!
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING.
// *********************************************************************
package com.vk.sdk.api.account.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.account.dto.AccountChangePasswordResponseDto
import com.vk.sdk.api.account.responses.AccountChangePasswordResponse
import kotlin.String
import org.json.JSONObject

/**
 * Changes a user password after access is successfully restored with the
 * [vk.com/dev/auth.restore|auth.restore] method.
 * @param newPassword New password that will be set as a current minLength 6
 * @param restoreSid Session id received after the [vk.com/dev/auth.restore|auth.restore] method is
 * executed. (If the password is changed right after the access was restored) 
 * @param changePasswordHash Hash received after a successful OAuth authorization with a code got by
 * SMS. (If the password is changed right after the access was restored) 
 * @param oldPassword Current user password. 
 */
class AccountChangePassword(
    private val newPassword: String,
    private val restoreSid: String? = null,
    private val changePasswordHash: String? = null,
    private val oldPassword: String? = null
) : VKRequest<AccountChangePasswordResponseDto>("account.changePassword") {
    init {
        addParam("new_password", newPassword)
        restoreSid?.let { value ->
            addParam("restore_sid", value)
        }
        changePasswordHash?.let { value ->
            addParam("change_password_hash", value)
        }
        oldPassword?.let { value ->
            addParam("old_password", value)
        }
    }

    override fun parse(r: JSONObject): AccountChangePasswordResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            AccountChangePasswordResponse::class.java).response
}
