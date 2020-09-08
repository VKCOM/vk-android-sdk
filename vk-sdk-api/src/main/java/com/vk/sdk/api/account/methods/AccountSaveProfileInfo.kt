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
package com.vk.sdk.api.account.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoBdateVisibility
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoRelation
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoResponseDto
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoSex
import com.vk.sdk.api.account.responses.AccountSaveProfileInfoResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Edits current profile info.
 * @param firstName User first name. 
 * @param lastName User last name. 
 * @param maidenName User maiden name (female only) 
 * @param screenName User screen name. 
 * @param cancelRequestId ID of the name change request to be canceled. If this parameter is sent,
 * all the others are ignored. minimum 0
 * @param sex User sex. Possible values: , * '1' � female,, * '2' � male. minimum 0
 * @param relation User relationship status. Possible values: , * '1' � single,, * '2' � in a
 * relationship,, * '3' � engaged,, * '4' � married,, * '5' � it's complicated,, * '6' � actively
 * searching,, * '7' � in love,, * '0' � not specified. minimum 0
 * @param relationPartnerId ID of the relationship partner. minimum 0
 * @param bdate User birth date, format: DD.MM.YYYY. 
 * @param bdateVisibility Birth date visibility. Returned values: , * '1' � show birth date,, * '2'
 * � show only month and day,, * '0' � hide birth date. minimum 0
 * @param homeTown User home town. 
 * @param countryId User country. minimum 0
 * @param cityId User city. minimum 0
 * @param status Status text. 
 */
class AccountSaveProfileInfo(
    private val firstName: String? = null,
    private val lastName: String? = null,
    private val maidenName: String? = null,
    private val screenName: String? = null,
    private val cancelRequestId: Int? = null,
    private val sex: AccountSaveProfileInfoSex? = null,
    private val relation: AccountSaveProfileInfoRelation? = null,
    private val relationPartnerId: Int? = null,
    private val bdate: String? = null,
    private val bdateVisibility: AccountSaveProfileInfoBdateVisibility? = null,
    private val homeTown: String? = null,
    private val countryId: Int? = null,
    private val cityId: Int? = null,
    private val status: String? = null
) : VKRequest<AccountSaveProfileInfoResponseDto>("account.saveProfileInfo") {
    init {
        firstName?.let { value ->
            addParam("first_name", value)
        }
        lastName?.let { value ->
            addParam("last_name", value)
        }
        maidenName?.let { value ->
            addParam("maiden_name", value)
        }
        screenName?.let { value ->
            addParam("screen_name", value)
        }
        cancelRequestId?.let { value ->
            addParam("cancel_request_id", value)
        }
        sex?.let { value ->
            addParam("sex", value.value)
        }
        relation?.let { value ->
            addParam("relation", value.value)
        }
        relationPartnerId?.let { value ->
            addParam("relation_partner_id", value)
        }
        bdate?.let { value ->
            addParam("bdate", value)
        }
        bdateVisibility?.let { value ->
            addParam("bdate_visibility", value.value)
        }
        homeTown?.let { value ->
            addParam("home_town", value)
        }
        countryId?.let { value ->
            addParam("country_id", value)
        }
        cityId?.let { value ->
            addParam("city_id", value)
        }
        status?.let { value ->
            addParam("status", value)
        }
    }

    override fun parse(r: JSONObject): AccountSaveProfileInfoResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            AccountSaveProfileInfoResponse::class.java).response
}
