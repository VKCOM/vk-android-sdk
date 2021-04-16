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
package com.vk.sdk.api.friends.dto

import com.google.gson.annotations.SerializedName
import kotlin.Int

/**
 * @param success
 * @param friendDeleted - Returns 1 if friend has been deleted
 * @param outRequestDeleted - Returns 1 if out request has been canceled
 * @param inRequestDeleted - Returns 1 if incoming request has been declined
 * @param suggestionDeleted - Returns 1 if suggestion has been declined
 */
data class FriendsDeleteResponse(
    @SerializedName("success")
    val success: Int,
    @SerializedName("friend_deleted")
    val friendDeleted: FriendsDeleteResponse.FriendDeleted? = null,
    @SerializedName("out_request_deleted")
    val outRequestDeleted: FriendsDeleteResponse.OutRequestDeleted? = null,
    @SerializedName("in_request_deleted")
    val inRequestDeleted: FriendsDeleteResponse.InRequestDeleted? = null,
    @SerializedName("suggestion_deleted")
    val suggestionDeleted: FriendsDeleteResponse.SuggestionDeleted? = null
) {
    enum class FriendDeleted(
        val value: Int
    ) {
        @SerializedName("1")
        OK(1);
    }

    enum class OutRequestDeleted(
        val value: Int
    ) {
        @SerializedName("1")
        OK(1);
    }

    enum class InRequestDeleted(
        val value: Int
    ) {
        @SerializedName("1")
        OK(1);
    }

    enum class SuggestionDeleted(
        val value: Int
    ) {
        @SerializedName("1")
        OK(1);
    }
}
