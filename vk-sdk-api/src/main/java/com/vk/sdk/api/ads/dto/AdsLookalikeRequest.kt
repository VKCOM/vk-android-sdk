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

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id Lookalike request ID
 * @param createTime Lookalike request create time, as Unixtime
 * @param updateTime Lookalike request update time, as Unixtime
 * @param status Lookalike request status
 * @param sourceType Lookalike request source type
 * @param scheduledDeleteTime Time by which lookalike request would be deleted, as Unixtime
 * @param sourceRetargetingGroupId Retargeting group id, which was used as lookalike seed
 * @param sourceName Lookalike request seed name (retargeting group name)
 * @param audienceCount Lookalike request seed audience size
 * @param saveAudienceLevels no description
 */
data class AdsLookalikeRequest(
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="create_time")
    val createTime: Int,
    @SerializedName(value="update_time")
    val updateTime: Int,
    @SerializedName(value="status")
    val status: Status,
    @SerializedName(value="source_type")
    val sourceType: SourceType,
    @SerializedName(value="scheduled_delete_time")
    val scheduledDeleteTime: Int? = null,
    @SerializedName(value="source_retargeting_group_id")
    val sourceRetargetingGroupId: Int? = null,
    @SerializedName(value="source_name")
    val sourceName: String? = null,
    @SerializedName(value="audience_count")
    val audienceCount: Int? = null,
    @SerializedName(value="save_audience_levels")
    val saveAudienceLevels: List<AdsLookalikeRequestSaveAudienceLevel>? = null
) {
    enum class SourceType(
        val value: String
    ) {
        UNKNOWN("unknown"),

        RETARGETING_GROUP("retargeting_group"),

        PROMOTED_POST("promoted_post");

        class Serializer : JsonDeserializer<SourceType> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): SourceType = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }

    enum class Status(
        val value: String
    ) {
        UNKNOWN("unknown"),

        NEW("new"),

        SEARCH_QUEUED("search_queued"),

        SEARCH_IN_PROGRESS("search_in_progress"),

        SEARCH_FAILED("search_failed"),

        SEARCH_DONE("search_done"),

        SAVE_IN_PROGRESS("save_in_progress"),

        SAVE_FAILED("save_failed"),

        SAVE_DONE("save_done"),

        CANCELED("canceled");

        class Serializer : JsonDeserializer<Status> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): Status = values().first { it.value.toString() == json!!.asJsonPrimitive.toString() }
        }
    }
}
