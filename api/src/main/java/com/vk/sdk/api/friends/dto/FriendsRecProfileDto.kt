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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseCropPhotoDto
import com.vk.sdk.api.base.dto.BaseSexDto
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * Recommended user information.
 * @param id
 * @param friendsGenerationId
 * @param friendsRecommendationSource
 * @param firstName
 * @param lastName
 * @param mutual
 * @param sex
 * @param photo100
 * @param photo200
 * @param photo400Orig
 * @param photo400
 * @param photoBase
 * @param commonCount
 * @param description
 * @param descriptions
 * @param friendStatus
 * @param verified
 * @param trending
 * @param canWritePrivateMessage
 * @param trackCode
 * @param cropPhoto
 * @param button
 */
data class FriendsRecProfileDto(
    @SerializedName("id")
    val id: UserId,
    @SerializedName("friends_generation_id")
    val friendsGenerationId: Long? = null,
    @SerializedName("friends_recommendation_source")
    val friendsRecommendationSource: Int? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("mutual")
    val mutual: FriendsRequestsMutualDto? = null,
    @SerializedName("sex")
    val sex: BaseSexDto? = null,
    @SerializedName("photo_100")
    val photo100: String? = null,
    @SerializedName("photo_200")
    val photo200: String? = null,
    @SerializedName("photo_400_orig")
    val photo400Orig: String? = null,
    @SerializedName("photo_400")
    val photo400: String? = null,
    @SerializedName("photo_base")
    val photoBase: String? = null,
    @SerializedName("common_count")
    val commonCount: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("descriptions")
    val descriptions: List<FriendsRecDescriptionGenericDto>? = null,
    @SerializedName("friend_status")
    val friendStatus: FriendsFriendStatusStatusDto? = null,
    @SerializedName("verified")
    val verified: BaseBoolIntDto? = null,
    @SerializedName("trending")
    val trending: BaseBoolIntDto? = null,
    @SerializedName("can_write_private_message")
    val canWritePrivateMessage: BaseBoolIntDto? = null,
    @SerializedName("track_code")
    val trackCode: String? = null,
    @SerializedName("crop_photo")
    val cropPhoto: BaseCropPhotoDto? = null,
    @SerializedName("button")
    val button: FriendsRecBlockButtonDto? = null
)
