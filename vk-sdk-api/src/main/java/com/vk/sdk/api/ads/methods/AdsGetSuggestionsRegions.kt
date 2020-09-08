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
package com.vk.sdk.api.ads.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.ads.dto.AdsGetSuggestionsLang
import com.vk.sdk.api.ads.dto.AdsGetSuggestionsSection
import com.vk.sdk.api.ads.dto.AdsTargSuggestionsRegions
import com.vk.sdk.api.ads.responses.AdsGetSuggestionsRegionsResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a set of auto-suggestions for various targeting parameters.
 * @param section Section, suggestions are retrieved in. Available values: *countries � request of a
 * list of countries. If q is not set or blank, a short list of countries is shown. Otherwise, a full
 * list of countries is shown. *regions � requested list of regions. 'country' parameter is required.
 * *cities � requested list of cities. 'country' parameter is required. *districts � requested list of
 * districts. 'cities' parameter is required. *stations � requested list of subway stations. 'cities'
 * parameter is required. *streets � requested list of streets. 'cities' parameter is required.
 * *schools � requested list of educational organizations. 'cities' parameter is required. *interests �
 * requested list of interests. *positions � requested list of positions (professions). *group_types �
 * requested list of group types. *religions � requested list of religious commitments. *browsers �
 * requested list of browsers and mobile devices. 
 * @param ids Objects IDs separated by commas. If the parameter is passed, 'q, country, cities'
 * should not be passed. 
 * @param q Filter-line of the request (for countries, regions, cities, streets, schools, interests,
 * positions). 
 * @param country ID of the country objects are searched in. 
 * @param cities IDs of cities where objects are searched in, separated with a comma. 
 * @param lang Language of the returned string values. Supported languages: *ru � Russian,, *ua �
 * Ukrainian,, *en � English. 
 */
class AdsGetSuggestionsRegions(
    private val section: AdsGetSuggestionsSection,
    private val ids: String? = null,
    private val q: String? = null,
    private val country: Int? = null,
    private val cities: String? = null,
    private val lang: AdsGetSuggestionsLang? = null
) : VKRequest<List<AdsTargSuggestionsRegions>>("ads.getSuggestions") {
    init {
        addParam("section", section.value)
        ids?.let { value ->
            addParam("ids", value)
        }
        q?.let { value ->
            addParam("q", value)
        }
        country?.let { value ->
            addParam("country", value)
        }
        cities?.let { value ->
            addParam("cities", value)
        }
        lang?.let { value ->
            addParam("lang", value.value)
        }
    }

    override fun parse(r: JSONObject): List<AdsTargSuggestionsRegions> =
            GsonHolder.gson.fromJson(r.toString(),
            AdsGetSuggestionsRegionsResponse::class.java).response
}
