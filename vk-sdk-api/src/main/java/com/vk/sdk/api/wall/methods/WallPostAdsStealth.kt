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
import com.vk.sdk.api.wall.dto.WallPostAdsStealthResponseDto
import com.vk.sdk.api.wall.responses.WallPostAdsStealthResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Allows to create hidden post which will not be shown on the community's wall and can be used for
 * creating an ad with type "Community post".
 * @param ownerId User ID or community ID. Use a negative value to designate a community ID. 
 * @param message (Required if 'attachments' is not set.) Text of the post. 
 * @param attachments (Required if 'message' is not set.) List of objects attached to the post, in
 * the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media attachment:
 * 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, 'page' � wiki-page, 'note' �
 * note, 'poll' � poll, 'album' � photo album, '<owner_id>' � ID of the media application owner.
 * '<media_id>' � Media application ID. Example: "photo100172_166443618,photo66748_265827614", May
 * contain a link to an external page to include in the post. Example:
 * "photo66748_265827614,http://habrahabr.ru", "NOTE: If more than one link is being attached, an error
 * will be thrown." 
 * @param signed Only for posts in communities with 'from_group' set to '1': '1' � post will be
 * signed with the name of the posting user, '0' � post will not be signed (default) 
 * @param lat Geographical latitude of a check-in, in degrees (from -90 to 90). 
 * @param long Geographical longitude of a check-in, in degrees (from -180 to 180). 
 * @param placeId ID of the location where the user was tagged. minimum 0
 * @param guid Unique identifier to avoid duplication the same post. 
 * @param linkButton Link button ID 
 * @param linkTitle Link title 
 * @param linkImage Link image url 
 * @param linkVideo Link video ID in format "<owner_id>_<media_id>" 
 */
class WallPostAdsStealth(
    private val ownerId: Int,
    private val message: String? = null,
    private val attachments: List<String>? = null,
    private val signed: Boolean? = null,
    private val lat: Float? = null,
    private val long: Float? = null,
    private val placeId: Int? = null,
    private val guid: String? = null,
    private val linkButton: String? = null,
    private val linkTitle: String? = null,
    private val linkImage: String? = null,
    private val linkVideo: String? = null
) : VKRequest<WallPostAdsStealthResponseDto>("wall.postAdsStealth") {
    init {
        addParam("owner_id", ownerId)
        message?.let { value ->
            addParam("message", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
        signed?.let { value ->
            addParam("signed", if (value) 1 else 0)
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
        guid?.let { value ->
            addParam("guid", value)
        }
        linkButton?.let { value ->
            addParam("link_button", value)
        }
        linkTitle?.let { value ->
            addParam("link_title", value)
        }
        linkImage?.let { value ->
            addParam("link_image", value)
        }
        linkVideo?.let { value ->
            addParam("link_video", value)
        }
    }

    override fun parse(r: JSONObject): WallPostAdsStealthResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WallPostAdsStealthResponse::class.java).response
}
