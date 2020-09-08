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
package com.vk.sdk.api.pages.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.pages.dto.PagesWikipageFull
import com.vk.sdk.api.pages.responses.PagesGetVersionResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns the text of one of the previous versions of a wiki page.
 * @param versionId  
 * @param groupId ID of the community that owns the wiki page. 
 * @param userId  
 * @param needHtml '1' � to return the page as HTML 
 */
class PagesGetVersion(
    private val versionId: Int,
    private val groupId: Int? = null,
    private val userId: Int? = null,
    private val needHtml: Boolean? = null
) : VKRequest<PagesWikipageFull>("pages.getVersion") {
    init {
        addParam("version_id", versionId)
        groupId?.let { value ->
            addParam("group_id", value)
        }
        userId?.let { value ->
            addParam("user_id", value)
        }
        needHtml?.let { value ->
            addParam("need_html", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): PagesWikipageFull = GsonHolder.gson.fromJson(r.toString(),
            PagesGetVersionResponse::class.java).response
}
