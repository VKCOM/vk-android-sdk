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
package com.vk.sdk.api.apps.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardExtendedResponseDto
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardType
import com.vk.sdk.api.apps.responses.AppsGetLeaderboardExtendedResponse
import kotlin.Boolean
import org.json.JSONObject

/**
 * Returns players rating in the game.
 * @param type Leaderboard type. Possible values: *'level' � by level,, *'points' � by mission
 * points,, *'score' � by score (). 
 * @param global Rating type. Possible values: *'1' � global rating among all players,, *'0' �
 * rating among user friends. default 1
 * @param extended 1 � to return additional info about users default 0
 */
class AppsGetLeaderboardExtended(
    private val type: AppsGetLeaderboardType,
    private val global: Boolean? = null,
    private val extended: Boolean? = null
) : VKRequest<AppsGetLeaderboardExtendedResponseDto>("apps.getLeaderboard") {
    init {
        addParam("type", type.value)
        global?.let { value ->
            addParam("global", if (value) 1 else 0)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): AppsGetLeaderboardExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            AppsGetLeaderboardExtendedResponse::class.java).response
}
