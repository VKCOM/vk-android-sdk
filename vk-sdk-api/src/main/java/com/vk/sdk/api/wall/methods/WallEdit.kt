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
package com.vk.sdk.api.wall.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.wall.dto.WallEditResponseDto
import com.vk.sdk.api.wall.responses.WallEditResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Edits a post on a user wall or community wall.
 * @param postId  minimum 0
 * @param ownerId User ID or community ID. Use a negative value to designate a community ID. 
 * @param friendsOnly  
 * @param message (Required if 'attachments' is not set.) Text of the post. 
 * @param attachments (Required if 'message' is not set.) List of objects attached to the post, in
 * the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media attachment:
 * 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, '<owner_id>' � ID of the media
 * application owner. '<media_id>' � Media application ID. Example:
 * "photo100172_166443618,photo66748_265827614", May contain a link to an external page to include in
 * the post. Example: "photo66748_265827614,http://habrahabr.ru", "NOTE: If more than one link is being
 * attached, an error is thrown." 
 * @param services  
 * @param signed  
 * @param publishDate  minimum 0
 * @param lat  
 * @param long  
 * @param placeId  minimum 0
 * @param markAsAds  
 * @param closeComments  
 * @param posterBkgId  minimum 0
 * @param posterBkgOwnerId  
 * @param posterBkgAccessHash  
 * @param copyright  
 */
class WallEdit(
    private val postId: Int,
    private val ownerId: Int? = null,
    private val friendsOnly: Boolean? = null,
    private val message: String? = null,
    private val attachments: List<String>? = null,
    private val services: String? = null,
    private val signed: Boolean? = null,
    private val publishDate: Int? = null,
    private val lat: Float? = null,
    private val long: Float? = null,
    private val placeId: Int? = null,
    private val markAsAds: Boolean? = null,
    private val closeComments: Boolean? = null,
    private val posterBkgId: Int? = null,
    private val posterBkgOwnerId: Int? = null,
    private val posterBkgAccessHash: String? = null,
    private val copyright: String? = null
) : VKRequest<WallEditResponseDto>("wall.edit") {
    init {
        addParam("post_id", postId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        friendsOnly?.let { value ->
            addParam("friends_only", if (value) 1 else 0)
        }
        message?.let { value ->
            addParam("message", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
        services?.let { value ->
            addParam("services", value)
        }
        signed?.let { value ->
            addParam("signed", if (value) 1 else 0)
        }
        publishDate?.let { value ->
            addParam("publish_date", value)
        }
        lat?.let { value ->
            addParam("lat", value.toString())
        }
        long?.let { value ->
            addParam("long", value.toString())
        }
        placeId?.let { value ->
            addParam("place_id", value)
        }
        markAsAds?.let { value ->
            addParam("mark_as_ads", if (value) 1 else 0)
        }
        closeComments?.let { value ->
            addParam("close_comments", if (value) 1 else 0)
        }
        posterBkgId?.let { value ->
            addParam("poster_bkg_id", value)
        }
        posterBkgOwnerId?.let { value ->
            addParam("poster_bkg_owner_id", value)
        }
        posterBkgAccessHash?.let { value ->
            addParam("poster_bkg_access_hash", value)
        }
        copyright?.let { value ->
            addParam("copyright", value)
        }
    }

    override fun parse(r: JSONObject): WallEditResponseDto = GsonHolder.gson.fromJson(r.toString(),
            WallEditResponse::class.java).response
}
