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
package com.vk.sdk.api.photos.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Edits the caption of a photo.
 * @param photoId Photo ID. minimum 0
 * @param ownerId ID of the user or community that owns the photo. 
 * @param caption New caption for the photo. If this parameter is not set, it is considered to be
 * equal to an empty string. 
 * @param latitude  
 * @param longitude  
 * @param placeStr  
 * @param foursquareId  
 * @param deletePlace  
 */
class PhotosEdit(
    private val photoId: Int,
    private val ownerId: Int? = null,
    private val caption: String? = null,
    private val latitude: Float? = null,
    private val longitude: Float? = null,
    private val placeStr: String? = null,
    private val foursquareId: String? = null,
    private val deletePlace: Boolean? = null
) : VKRequest<BaseOkResponseDto>("photos.edit") {
    init {
        addParam("photo_id", photoId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        caption?.let { value ->
            addParam("caption", value)
        }
        latitude?.let { value ->
            addParam("latitude", value.toString())
        }
        longitude?.let { value ->
            addParam("longitude", value.toString())
        }
        placeStr?.let { value ->
            addParam("place_str", value)
        }
        foursquareId?.let { value ->
            addParam("foursquare_id", value)
        }
        deletePlace?.let { value ->
            addParam("delete_place", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
