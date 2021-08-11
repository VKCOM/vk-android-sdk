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
package com.vk.sdk.api.stories.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.apps.dto.AppsAppMin
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param type - Type of Feed Item
 * @param id
 * @param stories - Author stories
 * @param grouped - Grouped stories of various authors (for types
 * community_grouped_stories/app_grouped_stories type)
 * @param app - App, which stories has been grouped (for type app_grouped_stories)
 * @param promoData - Additional data for promo stories (for type promo_stories)
 * @param birthdayUserId
 * @param trackCode
 * @param hasUnseen
 * @param name
 */
data class StoriesFeedItem(
    @SerializedName("type")
    val type: StoriesFeedItem.Type,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("stories")
    val stories: List<StoriesStory>? = null,
    @SerializedName("grouped")
    val grouped: List<StoriesFeedItem>? = null,
    @SerializedName("app")
    val app: AppsAppMin? = null,
    @SerializedName("promo_data")
    val promoData: StoriesPromoBlock? = null,
    @SerializedName("birthday_user_id")
    val birthdayUserId: Int? = null,
    @SerializedName("track_code")
    val trackCode: String? = null,
    @SerializedName("has_unseen")
    val hasUnseen: Boolean? = null,
    @SerializedName("name")
    val name: String? = null
) {
    enum class Type(
        val value: String
    ) {
        @SerializedName("promo_stories")
        PROMO_STORIES("promo_stories"),

        @SerializedName("stories")
        STORIES("stories"),

        @SerializedName("live_active")
        LIVE_ACTIVE("live_active"),

        @SerializedName("live_finished")
        LIVE_FINISHED("live_finished"),

        @SerializedName("community_grouped_stories")
        COMMUNITY_GROUPED_STORIES("community_grouped_stories"),

        @SerializedName("app_grouped_stories")
        APP_GROUPED_STORIES("app_grouped_stories"),

        @SerializedName("birthday")
        BIRTHDAY("birthday");
    }
}
