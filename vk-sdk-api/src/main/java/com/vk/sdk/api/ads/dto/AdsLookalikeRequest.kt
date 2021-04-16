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
package com.vk.sdk.api.ads.dto

import com.google.gson.annotations.SerializedName
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Lookalike request ID
 * @param createTime - Lookalike request create time, as Unixtime
 * @param updateTime - Lookalike request update time, as Unixtime
 * @param status - Lookalike request status
 * @param sourceType - Lookalike request source type
 * @param scheduledDeleteTime - Time by which lookalike request would be deleted, as Unixtime
 * @param sourceRetargetingGroupId - Retargeting group id, which was used as lookalike seed
 * @param sourceName - Lookalike request seed name (retargeting group name)
 * @param audienceCount - Lookalike request seed audience size
 * @param saveAudienceLevels
 */
data class AdsLookalikeRequest(
    @SerializedName("id")
    val id: Int,
    @SerializedName("create_time")
    val createTime: Int,
    @SerializedName("update_time")
    val updateTime: Int,
    @SerializedName("status")
    val status: AdsLookalikeRequest.Status,
    @SerializedName("source_type")
    val sourceType: AdsLookalikeRequest.SourceType,
    @SerializedName("scheduled_delete_time")
    val scheduledDeleteTime: Int? = null,
    @SerializedName("source_retargeting_group_id")
    val sourceRetargetingGroupId: Int? = null,
    @SerializedName("source_name")
    val sourceName: String? = null,
    @SerializedName("audience_count")
    val audienceCount: Int? = null,
    @SerializedName("save_audience_levels")
    val saveAudienceLevels: List<AdsLookalikeRequestSaveAudienceLevel>? = null
) {
    enum class Status(
        val value: String
    ) {
        @SerializedName("unknown")
        UNKNOWN("unknown"),

        @SerializedName("new")
        NEW("new"),

        @SerializedName("search_queued")
        SEARCH_QUEUED("search_queued"),

        @SerializedName("search_in_progress")
        SEARCH_IN_PROGRESS("search_in_progress"),

        @SerializedName("search_failed")
        SEARCH_FAILED("search_failed"),

        @SerializedName("search_done")
        SEARCH_DONE("search_done"),

        @SerializedName("save_in_progress")
        SAVE_IN_PROGRESS("save_in_progress"),

        @SerializedName("save_failed")
        SAVE_FAILED("save_failed"),

        @SerializedName("save_done")
        SAVE_DONE("save_done"),

        @SerializedName("canceled")
        CANCELED("canceled");
    }

    enum class SourceType(
        val value: String
    ) {
        @SerializedName("unknown")
        UNKNOWN("unknown"),

        @SerializedName("retargeting_group")
        RETARGETING_GROUP("retargeting_group"),

        @SerializedName("promoted_post")
        PROMOTED_POST("promoted_post");
    }
}
