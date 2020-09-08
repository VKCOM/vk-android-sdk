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
package com.vk.sdk.api.groups.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import com.vk.sdk.api.groups.dto.GroupsEditAgeLimits
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Edits a community.
 * @param groupId Community ID. minimum 0
 * @param title Community title. 
 * @param description Community description. 
 * @param screenName Community screen name. 
 * @param access Community type. Possible values: *'0' � open,, *'1' � closed,, *'2' � private.
 * minimum 0
 * @param website Website that will be displayed in the community information field. 
 * @param subject Community subject. Possible values: , *'1' � auto/moto,, *'2' � activity
 * holidays,, *'3' � business,, *'4' � pets,, *'5' � health,, *'6' � dating and communication, , *'7' �
 * games,, *'8' � IT (computers and software),, *'9' � cinema,, *'10' � beauty and fashion,, *'11' �
 * cooking,, *'12' � art and culture,, *'13' � literature,, *'14' � mobile services and internet,,
 * *'15' � music,, *'16' � science and technology,, *'17' � real estate,, *'18' � news and media,,
 * *'19' � security,, *'20' � education,, *'21' � home and renovations,, *'22' � politics,, *'23' �
 * food,, *'24' � industry,, *'25' � travel,, *'26' � work,, *'27' � entertainment,, *'28' � religion,,
 * *'29' � family,, *'30' � sports,, *'31' � insurance,, *'32' � television,, *'33' � goods and
 * services,, *'34' � hobbies,, *'35' � finance,, *'36' � photo,, *'37' � esoterics,, *'38' �
 * electronics and appliances,, *'39' � erotic,, *'40' � humor,, *'41' � society, humanities,, *'42' �
 * design and graphics. 
 * @param email Organizer email (for events). 
 * @param phone Organizer phone number (for events). 
 * @param rss RSS feed address for import (available only to communities with special permission.
 * Contact vk.com/support to get it. 
 * @param eventStartDate Event start date in Unixtime format. minimum 0
 * @param eventFinishDate Event finish date in Unixtime format. minimum 0
 * @param eventGroupId Organizer community ID (for events only). minimum 0
 * @param publicCategory Public page category ID. minimum 0
 * @param publicSubcategory Public page subcategory ID. minimum 0
 * @param publicDate Founding date of a company or organization owning the community in "dd.mm.YYYY"
 * format. 
 * @param wall Wall settings. Possible values: *'0' � disabled,, *'1' � open,, *'2' � limited
 * (groups and events only),, *'3' � closed (groups and events only). minimum 0
 * @param topics Board topics settings. Possbile values: , *'0' � disabled,, *'1' � open,, *'2' �
 * limited (for groups and events only). minimum 0
 * @param photos Photos settings. Possible values: *'0' � disabled,, *'1' � open,, *'2' � limited
 * (for groups and events only). minimum 0
 * @param video Video settings. Possible values: *'0' � disabled,, *'1' � open,, *'2' � limited (for
 * groups and events only). minimum 0
 * @param audio Audio settings. Possible values: *'0' � disabled,, *'1' � open,, *'2' � limited (for
 * groups and events only). minimum 0
 * @param links Links settings (for public pages only). Possible values: *'0' � disabled,, *'1' �
 * enabled. 
 * @param events Events settings (for public pages only). Possible values: *'0' � disabled,, *'1' �
 * enabled. 
 * @param places Places settings (for public pages only). Possible values: *'0' � disabled,, *'1' �
 * enabled. 
 * @param contacts Contacts settings (for public pages only). Possible values: *'0' � disabled,,
 * *'1' � enabled. 
 * @param docs Documents settings. Possible values: *'0' � disabled,, *'1' � open,, *'2' � limited
 * (for groups and events only). minimum 0
 * @param wiki Wiki pages settings. Possible values: *'0' � disabled,, *'1' � open,, *'2' � limited
 * (for groups and events only). minimum 0
 * @param messages Community messages. Possible values: *'0' � disabled,, *'1' � enabled. 
 * @param articles  
 * @param addresses  
 * @param ageLimits Community age limits. Possible values: *'1' � no limits,, *'2' � 16+,, *'3' �
 * 18+. default 1 minimum 0
 * @param market Market settings. Possible values: *'0' � disabled,, *'1' � enabled. 
 * @param marketComments market comments settings. Possible values: *'0' � disabled,, *'1' �
 * enabled. 
 * @param marketCountry Market delivery countries. 
 * @param marketCity Market delivery cities (if only one country is specified). 
 * @param marketCurrency Market currency settings. Possbile values: , *'643' � Russian rubles,,
 * *'980' � Ukrainian hryvnia,, *'398' � Kazakh tenge,, *'978' � Euro,, *'840' � US dollars minimum 0
 * @param marketContact Seller contact for market. Set '0' for community messages. minimum 0
 * @param marketWiki ID of a wiki page with market description. minimum 0
 * @param obsceneFilter Obscene expressions filter in comments. Possible values: , *'0' � disabled,,
 * *'1' � enabled. 
 * @param obsceneStopwords Stopwords filter in comments. Possible values: , *'0' � disabled,, *'1' �
 * enabled. 
 * @param obsceneWords Keywords for stopwords filter. 
 * @param mainSection  minimum 0
 * @param secondarySection  minimum 0
 * @param country Country of the community. minimum 0
 * @param city City of the community. minimum 0
 */
class GroupsEdit(
    private val groupId: Int,
    private val title: String? = null,
    private val description: String? = null,
    private val screenName: String? = null,
    private val access: Int? = null,
    private val website: String? = null,
    private val subject: String? = null,
    private val email: String? = null,
    private val phone: String? = null,
    private val rss: String? = null,
    private val eventStartDate: Int? = null,
    private val eventFinishDate: Int? = null,
    private val eventGroupId: Int? = null,
    private val publicCategory: Int? = null,
    private val publicSubcategory: Int? = null,
    private val publicDate: String? = null,
    private val wall: Int? = null,
    private val topics: Int? = null,
    private val photos: Int? = null,
    private val video: Int? = null,
    private val audio: Int? = null,
    private val links: Boolean? = null,
    private val events: Boolean? = null,
    private val places: Boolean? = null,
    private val contacts: Boolean? = null,
    private val docs: Int? = null,
    private val wiki: Int? = null,
    private val messages: Boolean? = null,
    private val articles: Boolean? = null,
    private val addresses: Boolean? = null,
    private val ageLimits: GroupsEditAgeLimits? = null,
    private val market: Boolean? = null,
    private val marketComments: Boolean? = null,
    private val marketCountry: List<Int>? = null,
    private val marketCity: List<Int>? = null,
    private val marketCurrency: Int? = null,
    private val marketContact: Int? = null,
    private val marketWiki: Int? = null,
    private val obsceneFilter: Boolean? = null,
    private val obsceneStopwords: Boolean? = null,
    private val obsceneWords: List<String>? = null,
    private val mainSection: Int? = null,
    private val secondarySection: Int? = null,
    private val country: Int? = null,
    private val city: Int? = null
) : VKRequest<BaseOkResponseDto>("groups.edit") {
    init {
        addParam("group_id", groupId)
        title?.let { value ->
            addParam("title", value)
        }
        description?.let { value ->
            addParam("description", value)
        }
        screenName?.let { value ->
            addParam("screen_name", value)
        }
        access?.let { value ->
            addParam("access", value)
        }
        website?.let { value ->
            addParam("website", value)
        }
        subject?.let { value ->
            addParam("subject", value)
        }
        email?.let { value ->
            addParam("email", value)
        }
        phone?.let { value ->
            addParam("phone", value)
        }
        rss?.let { value ->
            addParam("rss", value)
        }
        eventStartDate?.let { value ->
            addParam("event_start_date", value)
        }
        eventFinishDate?.let { value ->
            addParam("event_finish_date", value)
        }
        eventGroupId?.let { value ->
            addParam("event_group_id", value)
        }
        publicCategory?.let { value ->
            addParam("public_category", value)
        }
        publicSubcategory?.let { value ->
            addParam("public_subcategory", value)
        }
        publicDate?.let { value ->
            addParam("public_date", value)
        }
        wall?.let { value ->
            addParam("wall", value)
        }
        topics?.let { value ->
            addParam("topics", value)
        }
        photos?.let { value ->
            addParam("photos", value)
        }
        video?.let { value ->
            addParam("video", value)
        }
        audio?.let { value ->
            addParam("audio", value)
        }
        links?.let { value ->
            addParam("links", if (value) 1 else 0)
        }
        events?.let { value ->
            addParam("events", if (value) 1 else 0)
        }
        places?.let { value ->
            addParam("places", if (value) 1 else 0)
        }
        contacts?.let { value ->
            addParam("contacts", if (value) 1 else 0)
        }
        docs?.let { value ->
            addParam("docs", value)
        }
        wiki?.let { value ->
            addParam("wiki", value)
        }
        messages?.let { value ->
            addParam("messages", if (value) 1 else 0)
        }
        articles?.let { value ->
            addParam("articles", if (value) 1 else 0)
        }
        addresses?.let { value ->
            addParam("addresses", if (value) 1 else 0)
        }
        ageLimits?.let { value ->
            addParam("age_limits", value.value)
        }
        market?.let { value ->
            addParam("market", if (value) 1 else 0)
        }
        marketComments?.let { value ->
            addParam("market_comments", if (value) 1 else 0)
        }
        marketCountry?.let { value ->
            addParam("market_country", value)
        }
        marketCity?.let { value ->
            addParam("market_city", value)
        }
        marketCurrency?.let { value ->
            addParam("market_currency", value)
        }
        marketContact?.let { value ->
            addParam("market_contact", value)
        }
        marketWiki?.let { value ->
            addParam("market_wiki", value)
        }
        obsceneFilter?.let { value ->
            addParam("obscene_filter", if (value) 1 else 0)
        }
        obsceneStopwords?.let { value ->
            addParam("obscene_stopwords", if (value) 1 else 0)
        }
        obsceneWords?.let { value ->
            addParam("obscene_words", value)
        }
        mainSection?.let { value ->
            addParam("main_section", value)
        }
        secondarySection?.let { value ->
            addParam("secondary_section", value)
        }
        country?.let { value ->
            addParam("country", value)
        }
        city?.let { value ->
            addParam("city", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
