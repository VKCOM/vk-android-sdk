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
package com.vk.sdk.api.groups

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.addresses.dto.AddressesFields
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.groups.dto.GroupsAddAddressWorkInfoStatus
import com.vk.sdk.api.groups.dto.GroupsAddCallbackServerResponse
import com.vk.sdk.api.groups.dto.GroupsAddress
import com.vk.sdk.api.groups.dto.GroupsCallbackSettings
import com.vk.sdk.api.groups.dto.GroupsCreateSubtype
import com.vk.sdk.api.groups.dto.GroupsCreateType
import com.vk.sdk.api.groups.dto.GroupsEditAddressWorkInfoStatus
import com.vk.sdk.api.groups.dto.GroupsEditAgeLimits
import com.vk.sdk.api.groups.dto.GroupsFields
import com.vk.sdk.api.groups.dto.GroupsFilter
import com.vk.sdk.api.groups.dto.GroupsGetAddressesResponse
import com.vk.sdk.api.groups.dto.GroupsGetBannedResponse
import com.vk.sdk.api.groups.dto.GroupsGetCallbackConfirmationCodeResponse
import com.vk.sdk.api.groups.dto.GroupsGetCallbackServersResponse
import com.vk.sdk.api.groups.dto.GroupsGetCatalogInfoExtendedResponse
import com.vk.sdk.api.groups.dto.GroupsGetCatalogInfoResponse
import com.vk.sdk.api.groups.dto.GroupsGetCatalogResponse
import com.vk.sdk.api.groups.dto.GroupsGetInvitedUsersNameCase
import com.vk.sdk.api.groups.dto.GroupsGetInvitedUsersResponse
import com.vk.sdk.api.groups.dto.GroupsGetInvitesExtendedResponse
import com.vk.sdk.api.groups.dto.GroupsGetInvitesResponse
import com.vk.sdk.api.groups.dto.GroupsGetMembersFieldsResponse
import com.vk.sdk.api.groups.dto.GroupsGetMembersFilter
import com.vk.sdk.api.groups.dto.GroupsGetMembersSort
import com.vk.sdk.api.groups.dto.GroupsGetObjectExtendedResponse
import com.vk.sdk.api.groups.dto.GroupsGetRequestsFieldsResponse
import com.vk.sdk.api.groups.dto.GroupsGetResponse
import com.vk.sdk.api.groups.dto.GroupsGetSettingsResponse
import com.vk.sdk.api.groups.dto.GroupsGetTokenPermissionsResponse
import com.vk.sdk.api.groups.dto.GroupsGroup
import com.vk.sdk.api.groups.dto.GroupsGroupFull
import com.vk.sdk.api.groups.dto.GroupsGroupTag
import com.vk.sdk.api.groups.dto.GroupsLinksItem
import com.vk.sdk.api.groups.dto.GroupsLongPollServer
import com.vk.sdk.api.groups.dto.GroupsLongPollSettings
import com.vk.sdk.api.groups.dto.GroupsSearchResponse
import com.vk.sdk.api.groups.dto.GroupsSearchSort
import com.vk.sdk.api.groups.dto.GroupsSearchType
import com.vk.sdk.api.groups.dto.GroupsTagAddTagColor
import com.vk.sdk.api.groups.dto.GroupsTagBindAct
import com.vk.sdk.api.groups.dto.GroupsToggleMarketState
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

class GroupsService {
    /**
     * @param groupId
     * @param title
     * @param address
     * @param countryId
     * @param cityId
     * @param latitude
     * @param longitude
     * @param additionalAddress
     * @param metroId
     * @param phone
     * @param workInfoStatus
     * @param timetable
     * @param isMainAddress
     * @return [VKRequest] with [GroupsAddress]
     */
    fun groupsAddAddress(
        groupId: UserId,
        title: String,
        address: String,
        countryId: Int,
        cityId: Int,
        latitude: Float,
        longitude: Float,
        additionalAddress: String? = null,
        metroId: Int? = null,
        phone: String? = null,
        workInfoStatus: GroupsAddAddressWorkInfoStatus? = null,
        timetable: String? = null,
        isMainAddress: Boolean? = null
    ): VKRequest<GroupsAddress> = NewApiRequest("groups.addAddress") {
        GsonHolder.gson.fromJson(it, GroupsAddress::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("title", title, maxLength = 255)
        addParam("address", address, maxLength = 255)
        addParam("country_id", countryId, min = 1)
        addParam("city_id", cityId, min = 1)
        addParam("latitude", latitude, min = -90.0, max = 90.0)
        addParam("longitude", longitude, min = -180.0, max = 180.0)
        additionalAddress?.let { addParam("additional_address", it, maxLength = 400) }
        metroId?.let { addParam("metro_id", it, min = 0) }
        phone?.let { addParam("phone", it) }
        workInfoStatus?.let { addParam("work_info_status", it.value) }
        timetable?.let { addParam("timetable", it) }
        isMainAddress?.let { addParam("is_main_address", it) }
    }

    /**
     * @param groupId
     * @param url
     * @param title
     * @param secretKey
     * @return [VKRequest] with [GroupsAddCallbackServerResponse]
     */
    fun groupsAddCallbackServer(
        groupId: UserId,
        url: String,
        title: String,
        secretKey: String? = null
    ): VKRequest<GroupsAddCallbackServerResponse> = NewApiRequest("groups.addCallbackServer") {
        GsonHolder.gson.fromJson(it, GroupsAddCallbackServerResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("url", url)
        addParam("title", title, maxLength = 14)
        secretKey?.let { addParam("secret_key", it, maxLength = 50) }
    }

    /**
     * Allows to add a link to the community.
     *
     * @param groupId - Community ID.
     * @param link - Link URL.
     * @param text - Description text for the link.
     * @return [VKRequest] with [GroupsLinksItem]
     */
    fun groupsAddLink(
        groupId: UserId,
        link: String,
        text: String? = null
    ): VKRequest<GroupsLinksItem> = NewApiRequest("groups.addLink") {
        GsonHolder.gson.fromJson(it, GroupsLinksItem::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("link", link)
        text?.let { addParam("text", it) }
    }

    /**
     * Allows to approve join request to the community.
     *
     * @param groupId - Community ID.
     * @param userId - User ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsApproveRequest(groupId: UserId, userId: UserId): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.approveRequest") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("user_id", userId, min = 1)
    }

    /**
     * @param groupId
     * @param ownerId
     * @param endDate
     * @param reason
     * @param comment
     * @param commentVisible
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsBan(
        groupId: UserId,
        ownerId: UserId? = null,
        endDate: Int? = null,
        reason: Int? = null,
        comment: String? = null,
        commentVisible: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.ban") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        ownerId?.let { addParam("owner_id", it) }
        endDate?.let { addParam("end_date", it, min = 0) }
        reason?.let { addParam("reason", it, min = 0) }
        comment?.let { addParam("comment", it) }
        commentVisible?.let { addParam("comment_visible", it) }
    }

    /**
     * Creates a new community.
     *
     * @param title - Community title.
     * @param description - Community description (ignored for 'type' = 'public').
     * @param type - Community type. Possible values_ *'group' - group,, *'event' - event,,
     * *'public' - public page
     * @param publicCategory - Category ID (for 'type' = 'public' only).
     * @param publicSubcategory - Public page subcategory ID.
     * @param subtype - Public page subtype. Possible values_ *'1' - place or small business,,
     * *'2' - company, organization or website,, *'3' - famous person or group of people,, *'4' -
     * product or work of art.
     * @return [VKRequest] with [GroupsGroup]
     */
    fun groupsCreate(
        title: String,
        description: String? = null,
        type: GroupsCreateType? = null,
        publicCategory: Int? = null,
        publicSubcategory: Int? = null,
        subtype: GroupsCreateSubtype? = null
    ): VKRequest<GroupsGroup> = NewApiRequest("groups.create") {
        GsonHolder.gson.fromJson(it, GroupsGroup::class.java)
    }
    .apply {
        addParam("title", title)
        description?.let { addParam("description", it) }
        type?.let { addParam("type", it.value) }
        publicCategory?.let { addParam("public_category", it, min = 0) }
        publicSubcategory?.let { addParam("public_subcategory", it, min = 0) }
        subtype?.let { addParam("subtype", it.value) }
    }

    /**
     * @param groupId
     * @param addressId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsDeleteAddress(groupId: UserId, addressId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.deleteAddress") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("address_id", addressId, min = 0)
    }

    /**
     * @param groupId
     * @param serverId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsDeleteCallbackServer(groupId: UserId, serverId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.deleteCallbackServer") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("server_id", serverId, min = 0)
    }

    /**
     * Allows to delete a link from the community.
     *
     * @param groupId - Community ID.
     * @param linkId - Link ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsDeleteLink(groupId: UserId, linkId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.deleteLink") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("link_id", linkId, min = 0)
    }

    /**
     * @param groupId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsDisableOnline(groupId: UserId): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.disableOnline") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Edits a community.
     *
     * @param groupId - Community ID.
     * @param title - Community title.
     * @param description - Community description.
     * @param screenName - Community screen name.
     * @param access - Community type. Possible values_ *'0' - open,, *'1' - closed,, *'2' -
     * private.
     * @param website - Website that will be displayed in the community information field.
     * @param subject - Community subject. Possible values_ , *'1' - auto/moto,, *'2' - activity
     * holidays,, *'3' - business,, *'4' - pets,, *'5' - health,, *'6' - dating and communication, ,
     * *'7' - games,, *'8' - IT (computers and software),, *'9' - cinema,, *'10' - beauty and fashion,,
     * *'11' - cooking,, *'12' - art and culture,, *'13' - literature,, *'14' - mobile services and
     * internet,, *'15' - music,, *'16' - science and technology,, *'17' - real estate,, *'18' - news
     * and media,, *'19' - security,, *'20' - education,, *'21' - home and renovations,, *'22' -
     * politics,, *'23' - food,, *'24' - industry,, *'25' - travel,, *'26' - work,, *'27' -
     * entertainment,, *'28' - religion,, *'29' - family,, *'30' - sports,, *'31' - insurance,, *'32' -
     * television,, *'33' - goods and services,, *'34' - hobbies,, *'35' - finance,, *'36' - photo,,
     * *'37' - esoterics,, *'38' - electronics and appliances,, *'39' - erotic,, *'40' - humor,,
     * *'41' - society, humanities,, *'42' - design and graphics.
     * @param email - Organizer email (for events).
     * @param phone - Organizer phone number (for events).
     * @param rss - RSS feed address for import (available only to communities with special
     * permission. Contact vk.com/support to get it.
     * @param eventStartDate - Event start date in Unixtime format.
     * @param eventFinishDate - Event finish date in Unixtime format.
     * @param eventGroupId - Organizer community ID (for events only).
     * @param publicCategory - Public page category ID.
     * @param publicSubcategory - Public page subcategory ID.
     * @param publicDate - Founding date of a company or organization owning the community in
     * "dd.mm.YYYY" format.
     * @param wall - Wall settings. Possible values_ *'0' - disabled,, *'1' - open,, *'2' - limited
     * (groups and events only),, *'3' - closed (groups and events only).
     * @param topics - Board topics settings. Possbile values_ , *'0' - disabled,, *'1' - open,,
     * *'2' - limited (for groups and events only).
     * @param photos - Photos settings. Possible values_ *'0' - disabled,, *'1' - open,, *'2' -
     * limited (for groups and events only).
     * @param video - Video settings. Possible values_ *'0' - disabled,, *'1' - open,, *'2' -
     * limited (for groups and events only).
     * @param audio - Audio settings. Possible values_ *'0' - disabled,, *'1' - open,, *'2' -
     * limited (for groups and events only).
     * @param links - Links settings (for public pages only). Possible values_ *'0' - disabled,,
     * *'1' - enabled.
     * @param events - Events settings (for public pages only). Possible values_ *'0' - disabled,,
     * *'1' - enabled.
     * @param places - Places settings (for public pages only). Possible values_ *'0' - disabled,,
     * *'1' - enabled.
     * @param contacts - Contacts settings (for public pages only). Possible values_ *'0' -
     * disabled,, *'1' - enabled.
     * @param docs - Documents settings. Possible values_ *'0' - disabled,, *'1' - open,, *'2' -
     * limited (for groups and events only).
     * @param wiki - Wiki pages settings. Possible values_ *'0' - disabled,, *'1' - open,, *'2' -
     * limited (for groups and events only).
     * @param messages - Community messages. Possible values_ *'0' - disabled,, *'1' - enabled.
     * @param articles
     * @param addresses
     * @param ageLimits - Community age limits. Possible values_ *'1' - no limits,, *'2' - 16+,,
     * *'3' - 18+.
     * @param market - Market settings. Possible values_ *'0' - disabled,, *'1' - enabled.
     * @param marketComments - market comments settings. Possible values_ *'0' - disabled,, *'1' -
     * enabled.
     * @param marketCountry - Market delivery countries.
     * @param marketCity - Market delivery cities (if only one country is specified).
     * @param marketCurrency - Market currency settings. Possbile values_ , *'643' - Russian
     * rubles,, *'980' - Ukrainian hryvnia,, *'398' - Kazakh tenge,, *'978' - Euro,, *'840' - US
     * dollars
     * @param marketContact - Seller contact for market. Set '0' for community messages.
     * @param marketWiki - ID of a wiki page with market description.
     * @param obsceneFilter - Obscene expressions filter in comments. Possible values_ , *'0' -
     * disabled,, *'1' - enabled.
     * @param obsceneStopwords - Stopwords filter in comments. Possible values_ , *'0' - disabled,,
     * *'1' - enabled.
     * @param obsceneWords - Keywords for stopwords filter.
     * @param mainSection
     * @param secondarySection
     * @param country - Country of the community.
     * @param city - City of the community.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsEdit(
        groupId: UserId,
        title: String? = null,
        description: String? = null,
        screenName: String? = null,
        access: Int? = null,
        website: String? = null,
        subject: String? = null,
        email: String? = null,
        phone: String? = null,
        rss: String? = null,
        eventStartDate: Int? = null,
        eventFinishDate: Int? = null,
        eventGroupId: UserId? = null,
        publicCategory: Int? = null,
        publicSubcategory: Int? = null,
        publicDate: String? = null,
        wall: Int? = null,
        topics: Int? = null,
        photos: Int? = null,
        video: Int? = null,
        audio: Int? = null,
        links: Boolean? = null,
        events: Boolean? = null,
        places: Boolean? = null,
        contacts: Boolean? = null,
        docs: Int? = null,
        wiki: Int? = null,
        messages: Boolean? = null,
        articles: Boolean? = null,
        addresses: Boolean? = null,
        ageLimits: GroupsEditAgeLimits? = null,
        market: Boolean? = null,
        marketComments: Boolean? = null,
        marketCountry: List<Int>? = null,
        marketCity: List<Int>? = null,
        marketCurrency: Int? = null,
        marketContact: Int? = null,
        marketWiki: Int? = null,
        obsceneFilter: Boolean? = null,
        obsceneStopwords: Boolean? = null,
        obsceneWords: List<String>? = null,
        mainSection: Int? = null,
        secondarySection: Int? = null,
        country: Int? = null,
        city: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.edit") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        title?.let { addParam("title", it) }
        description?.let { addParam("description", it) }
        screenName?.let { addParam("screen_name", it) }
        access?.let { addParam("access", it, min = 0) }
        website?.let { addParam("website", it) }
        subject?.let { addParam("subject", it) }
        email?.let { addParam("email", it) }
        phone?.let { addParam("phone", it) }
        rss?.let { addParam("rss", it) }
        eventStartDate?.let { addParam("event_start_date", it, min = 0) }
        eventFinishDate?.let { addParam("event_finish_date", it, min = 0) }
        eventGroupId?.let { addParam("event_group_id", it, min = 0) }
        publicCategory?.let { addParam("public_category", it, min = 0) }
        publicSubcategory?.let { addParam("public_subcategory", it, min = 0) }
        publicDate?.let { addParam("public_date", it) }
        wall?.let { addParam("wall", it, min = 0) }
        topics?.let { addParam("topics", it, min = 0) }
        photos?.let { addParam("photos", it, min = 0) }
        video?.let { addParam("video", it, min = 0) }
        audio?.let { addParam("audio", it, min = 0) }
        links?.let { addParam("links", it) }
        events?.let { addParam("events", it) }
        places?.let { addParam("places", it) }
        contacts?.let { addParam("contacts", it) }
        docs?.let { addParam("docs", it, min = 0) }
        wiki?.let { addParam("wiki", it, min = 0) }
        messages?.let { addParam("messages", it) }
        articles?.let { addParam("articles", it) }
        addresses?.let { addParam("addresses", it) }
        ageLimits?.let { addParam("age_limits", it.value) }
        market?.let { addParam("market", it) }
        marketComments?.let { addParam("market_comments", it) }
        marketCountry?.let { addParam("market_country", it) }
        marketCity?.let { addParam("market_city", it) }
        marketCurrency?.let { addParam("market_currency", it, min = 0) }
        marketContact?.let { addParam("market_contact", it, min = 0) }
        marketWiki?.let { addParam("market_wiki", it, min = 0) }
        obsceneFilter?.let { addParam("obscene_filter", it) }
        obsceneStopwords?.let { addParam("obscene_stopwords", it) }
        obsceneWords?.let { addParam("obscene_words", it) }
        mainSection?.let { addParam("main_section", it, min = 0) }
        secondarySection?.let { addParam("secondary_section", it, min = 0) }
        country?.let { addParam("country", it, min = 0) }
        city?.let { addParam("city", it, min = 0) }
    }

    /**
     * @param groupId
     * @param addressId
     * @param title
     * @param address
     * @param additionalAddress
     * @param countryId
     * @param cityId
     * @param metroId
     * @param latitude
     * @param longitude
     * @param phone
     * @param workInfoStatus
     * @param timetable
     * @param isMainAddress
     * @return [VKRequest] with [GroupsAddress]
     */
    fun groupsEditAddress(
        groupId: UserId,
        addressId: Int,
        title: String? = null,
        address: String? = null,
        additionalAddress: String? = null,
        countryId: Int? = null,
        cityId: Int? = null,
        metroId: Int? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        phone: String? = null,
        workInfoStatus: GroupsEditAddressWorkInfoStatus? = null,
        timetable: String? = null,
        isMainAddress: Boolean? = null
    ): VKRequest<GroupsAddress> = NewApiRequest("groups.editAddress") {
        GsonHolder.gson.fromJson(it, GroupsAddress::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("address_id", addressId, min = 0)
        title?.let { addParam("title", it, maxLength = 255) }
        address?.let { addParam("address", it, maxLength = 255) }
        additionalAddress?.let { addParam("additional_address", it, maxLength = 400) }
        countryId?.let { addParam("country_id", it, min = 0) }
        cityId?.let { addParam("city_id", it, min = 0) }
        metroId?.let { addParam("metro_id", it, min = 0) }
        latitude?.let { addParam("latitude", it, min = -90.0, max = 90.0) }
        longitude?.let { addParam("longitude", it, min = -180.0, max = 180.0) }
        phone?.let { addParam("phone", it) }
        workInfoStatus?.let { addParam("work_info_status", it.value) }
        timetable?.let { addParam("timetable", it) }
        isMainAddress?.let { addParam("is_main_address", it) }
    }

    /**
     * @param groupId
     * @param serverId
     * @param url
     * @param title
     * @param secretKey
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsEditCallbackServer(
        groupId: UserId,
        serverId: Int,
        url: String,
        title: String,
        secretKey: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.editCallbackServer") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("server_id", serverId, min = 0)
        addParam("url", url)
        addParam("title", title, maxLength = 14)
        secretKey?.let { addParam("secret_key", it, maxLength = 50) }
    }

    /**
     * Allows to edit a link in the community.
     *
     * @param groupId - Community ID.
     * @param linkId - Link ID.
     * @param text - New description text for the link.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsEditLink(
        groupId: UserId,
        linkId: Int,
        text: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.editLink") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("link_id", linkId, min = 0)
        text?.let { addParam("text", it) }
    }

    /**
     * Allows to add, remove or edit the community manager.
     *
     * @param groupId - Community ID.
     * @param userId - User ID.
     * @param role - Manager role. Possible values_ *'moderator',, *'editor',, *'administrator',,
     * *'advertiser'.
     * @param isContact - '1' - to show the manager in Contacts block of the community.
     * @param contactPosition - Position to show in Contacts block.
     * @param contactPhone - Contact phone.
     * @param contactEmail - Contact e-mail.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsEditManager(
        groupId: UserId,
        userId: UserId,
        role: String? = null,
        isContact: Boolean? = null,
        contactPosition: String? = null,
        contactPhone: String? = null,
        contactEmail: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.editManager") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("user_id", userId, min = 1)
        role?.let { addParam("role", it) }
        isContact?.let { addParam("is_contact", it) }
        contactPosition?.let { addParam("contact_position", it) }
        contactPhone?.let { addParam("contact_phone", it) }
        contactEmail?.let { addParam("contact_email", it) }
    }

    /**
     * @param groupId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsEnableOnline(groupId: UserId): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.enableOnline") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Returns a list of the communities to which a user belongs.
     *
     * @param userId - User ID.
     * @param filter - Types of communities to return_ 'admin' - to return communities administered
     * by the user , 'editor' - to return communities where the user is an administrator or editor,
     * 'moder' - to return communities where the user is an administrator, editor, or moderator,
     * 'groups' - to return only groups, 'publics' - to return only public pages, 'events' - to return
     * only events
     * @param fields - Profile fields to return.
     * @param offset - Offset needed to return a specific subset of communities.
     * @param count - Number of communities to return.
     * @return [VKRequest] with [GroupsGetResponse]
     */
    fun groupsGet(
        userId: UserId? = null,
        filter: List<GroupsFilter>? = null,
        fields: List<GroupsFields>? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<GroupsGetResponse> = NewApiRequest("groups.get") {
        GsonHolder.gson.fromJson(it, GroupsGetResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
        val filterJsonConverted = filter?.map {
            it.value
        }
        filterJsonConverted?.let { addParam("filter", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns a list of the communities to which a user belongs.
     *
     * @param userId - User ID.
     * @param filter - Types of communities to return_ 'admin' - to return communities administered
     * by the user , 'editor' - to return communities where the user is an administrator or editor,
     * 'moder' - to return communities where the user is an administrator, editor, or moderator,
     * 'groups' - to return only groups, 'publics' - to return only public pages, 'events' - to return
     * only events
     * @param fields - Profile fields to return.
     * @param offset - Offset needed to return a specific subset of communities.
     * @param count - Number of communities to return.
     * @return [VKRequest] with [GroupsGetObjectExtendedResponse]
     */
    fun groupsGetExtended(
        userId: UserId? = null,
        filter: List<GroupsFilter>? = null,
        fields: List<GroupsFields>? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<GroupsGetObjectExtendedResponse> = NewApiRequest("groups.get") {
        GsonHolder.gson.fromJson(it, GroupsGetObjectExtendedResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
        addParam("extended", true)
        val filterJsonConverted = filter?.map {
            it.value
        }
        filterJsonConverted?.let { addParam("filter", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns a list of community addresses.
     *
     * @param groupId - ID or screen name of the community.
     * @param addressIds
     * @param latitude - Latitude of  the user geo position.
     * @param longitude - Longitude of the user geo position.
     * @param offset - Offset needed to return a specific subset of community addresses.
     * @param count - Number of community addresses to return.
     * @param fields - Address fields
     * @return [VKRequest] with [GroupsGetAddressesResponse]
     */
    fun groupsGetAddresses(
        groupId: UserId,
        addressIds: List<Int>? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<AddressesFields>? = null
    ): VKRequest<GroupsGetAddressesResponse> = NewApiRequest("groups.getAddresses") {
        GsonHolder.gson.fromJson(it, GroupsGetAddressesResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addressIds?.let { addParam("address_ids", it) }
        latitude?.let { addParam("latitude", it, min = -90.0, max = 90.0) }
        longitude?.let { addParam("longitude", it, min = -180.0, max = 180.0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of users on a community blacklist.
     *
     * @param groupId - Community ID.
     * @param offset - Offset needed to return a specific subset of users.
     * @param count - Number of users to return.
     * @param fields
     * @param ownerId
     * @return [VKRequest] with [GroupsGetBannedResponse]
     */
    fun groupsGetBanned(
        groupId: UserId,
        offset: Int? = null,
        count: Int? = null,
        fields: List<BaseUserGroupFields>? = null,
        ownerId: UserId? = null
    ): VKRequest<GroupsGetBannedResponse> = NewApiRequest("groups.getBanned") {
        GsonHolder.gson.fromJson(it, GroupsGetBannedResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Returns information about communities by their IDs.
     *
     * @param groupIds - IDs or screen names of communities.
     * @param groupId - ID or screen name of the community.
     * @param fields - Group fields to return.
     * @return [VKRequest] with [Unit]
     */
    fun groupsGetById(
        groupIds: List<UserId>? = null,
        groupId: UserId? = null,
        fields: List<GroupsFields>? = null
    ): VKRequest<List<GroupsGroupFull>> = NewApiRequest("groups.getById") {
        val typeToken = object: TypeToken<List<GroupsGroupFull>>() {}.type
        GsonHolder.gson.fromJson<List<GroupsGroupFull>>(it, typeToken)
    }
    .apply {
        groupIds?.let { addParam("group_ids", it) }
        groupId?.let { addParam("group_id", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns Callback API confirmation code for the community.
     *
     * @param groupId - Community ID.
     * @return [VKRequest] with [GroupsGetCallbackConfirmationCodeResponse]
     */
    fun groupsGetCallbackConfirmationCode(groupId: UserId):
            VKRequest<GroupsGetCallbackConfirmationCodeResponse> =
            NewApiRequest("groups.getCallbackConfirmationCode") {
        GsonHolder.gson.fromJson(it, GroupsGetCallbackConfirmationCodeResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * @param groupId
     * @param serverIds
     * @return [VKRequest] with [GroupsGetCallbackServersResponse]
     */
    fun groupsGetCallbackServers(groupId: UserId, serverIds: List<Int>? = null):
            VKRequest<GroupsGetCallbackServersResponse> =
            NewApiRequest("groups.getCallbackServers") {
        GsonHolder.gson.fromJson(it, GroupsGetCallbackServersResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        serverIds?.let { addParam("server_ids", it) }
    }

    /**
     * Returns [vk.com/dev/callback_api|Callback API] notifications settings.
     *
     * @param groupId - Community ID.
     * @param serverId - Server ID.
     * @return [VKRequest] with [GroupsCallbackSettings]
     */
    fun groupsGetCallbackSettings(groupId: UserId, serverId: Int? = null):
            VKRequest<GroupsCallbackSettings> = NewApiRequest("groups.getCallbackSettings") {
        GsonHolder.gson.fromJson(it, GroupsCallbackSettings::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        serverId?.let { addParam("server_id", it, min = 0) }
    }

    /**
     * Returns communities list for a catalog category.
     *
     * @param categoryId - Category id received from
     * [vk.com/dev/groups.getCatalogInfo|groups.getCatalogInfo].
     * @param subcategoryId - Subcategory id received from
     * [vk.com/dev/groups.getCatalogInfo|groups.getCatalogInfo].
     * @return [VKRequest] with [GroupsGetCatalogResponse]
     */
    fun groupsGetCatalog(categoryId: Int? = null, subcategoryId: Int? = null):
            VKRequest<GroupsGetCatalogResponse> = NewApiRequest("groups.getCatalog") {
        GsonHolder.gson.fromJson(it, GroupsGetCatalogResponse::class.java)
    }
    .apply {
        categoryId?.let { addParam("category_id", it, min = 0) }
        subcategoryId?.let { addParam("subcategory_id", it, min = 0, max = 99) }
    }

    /**
     * Returns categories list for communities catalog
     *
     * @param subcategories - 1 - to return subcategories info. By default_ 0.
     * @return [VKRequest] with [GroupsGetCatalogInfoResponse]
     */
    fun groupsGetCatalogInfo(subcategories: Boolean? = null):
            VKRequest<GroupsGetCatalogInfoResponse> = NewApiRequest("groups.getCatalogInfo") {
        GsonHolder.gson.fromJson(it, GroupsGetCatalogInfoResponse::class.java)
    }
    .apply {
        subcategories?.let { addParam("subcategories", it) }
    }

    /**
     * Returns categories list for communities catalog
     *
     * @param subcategories - 1 - to return subcategories info. By default_ 0.
     * @return [VKRequest] with [GroupsGetCatalogInfoExtendedResponse]
     */
    fun groupsGetCatalogInfoExtended(subcategories: Boolean? = null):
            VKRequest<GroupsGetCatalogInfoExtendedResponse> =
            NewApiRequest("groups.getCatalogInfo") {
        GsonHolder.gson.fromJson(it, GroupsGetCatalogInfoExtendedResponse::class.java)
    }
    .apply {
        addParam("extended", true)
        subcategories?.let { addParam("subcategories", it) }
    }

    /**
     * Returns invited users list of a community
     *
     * @param groupId - Group ID to return invited users for.
     * @param offset - Offset needed to return a specific subset of results.
     * @param count - Number of results to return.
     * @param fields - List of additional fields to be returned. Available values_ 'sex, bdate,
     * city, country, photo_50, photo_100, photo_200_orig, photo_200, photo_400_orig, photo_max,
     * photo_max_orig, online, online_mobile, lists, domain, has_mobile, contacts, connections, site,
     * education, universities, schools, can_post, can_see_all_posts, can_see_audio,
     * can_write_private_message, status, last_seen, common_count, relation, relatives, counters'.
     * @param nameCase - Case for declension of user name and surname. Possible values_ *'nom' -
     * nominative (default),, *'gen' - genitive,, *'dat' - dative,, *'acc' - accusative, , *'ins' -
     * instrumental,, *'abl' - prepositional.
     * @return [VKRequest] with [GroupsGetInvitedUsersResponse]
     */
    fun groupsGetInvitedUsers(
        groupId: UserId,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null,
        nameCase: GroupsGetInvitedUsersNameCase? = null
    ): VKRequest<GroupsGetInvitedUsersResponse> = NewApiRequest("groups.getInvitedUsers") {
        GsonHolder.gson.fromJson(it, GroupsGetInvitedUsersResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
    }

    /**
     * Returns a list of invitations to join communities and events.
     *
     * @param offset - Offset needed to return a specific subset of invitations.
     * @param count - Number of invitations to return.
     * @return [VKRequest] with [GroupsGetInvitesResponse]
     */
    fun groupsGetInvites(offset: Int? = null, count: Int? = null):
            VKRequest<GroupsGetInvitesResponse> = NewApiRequest("groups.getInvites") {
        GsonHolder.gson.fromJson(it, GroupsGetInvitesResponse::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
    }

    /**
     * Returns a list of invitations to join communities and events.
     *
     * @param offset - Offset needed to return a specific subset of invitations.
     * @param count - Number of invitations to return.
     * @return [VKRequest] with [GroupsGetInvitesExtendedResponse]
     */
    fun groupsGetInvitesExtended(offset: Int? = null, count: Int? = null):
            VKRequest<GroupsGetInvitesExtendedResponse> = NewApiRequest("groups.getInvites") {
        GsonHolder.gson.fromJson(it, GroupsGetInvitesExtendedResponse::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        addParam("extended", true)
    }

    /**
     * Returns the data needed to query a Long Poll server for events
     *
     * @param groupId - Community ID.
     * @return [VKRequest] with [GroupsLongPollServer]
     */
    fun groupsGetLongPollServer(groupId: UserId): VKRequest<GroupsLongPollServer> =
            NewApiRequest("groups.getLongPollServer") {
        GsonHolder.gson.fromJson(it, GroupsLongPollServer::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Returns Long Poll notification settings
     *
     * @param groupId - Community ID.
     * @return [VKRequest] with [GroupsLongPollSettings]
     */
    fun groupsGetLongPollSettings(groupId: UserId): VKRequest<GroupsLongPollSettings> =
            NewApiRequest("groups.getLongPollSettings") {
        GsonHolder.gson.fromJson(it, GroupsLongPollSettings::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Returns a list of community members.
     *
     * @param groupId - ID or screen name of the community.
     * @param sort - Sort order. Available values_ 'id_asc', 'id_desc', 'time_asc', 'time_desc'.
     * 'time_asc' and 'time_desc' are availavle only if the method is called by the group's
     * 'moderator'.
     * @param offset - Offset needed to return a specific subset of community members.
     * @param count - Number of community members to return.
     * @param fields - List of additional fields to be returned. Available values_ 'sex, bdate,
     * city, country, photo_50, photo_100, photo_200_orig, photo_200, photo_400_orig, photo_max,
     * photo_max_orig, online, online_mobile, lists, domain, has_mobile, contacts, connections, site,
     * education, universities, schools, can_post, can_see_all_posts, can_see_audio,
     * can_write_private_message, status, last_seen, common_count, relation, relatives, counters'.
     * @param filter - *'friends' - only friends in this community will be returned,, *'unsure' -
     * only those who pressed 'I may attend' will be returned (if it's an event).
     * @return [VKRequest] with [GroupsGetMembersFieldsResponse]
     */
    fun groupsGetMembers(
        groupId: String? = null,
        sort: GroupsGetMembersSort? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null,
        filter: GroupsGetMembersFilter? = null
    ): VKRequest<GroupsGetMembersFieldsResponse> = NewApiRequest("groups.getMembers") {
        GsonHolder.gson.fromJson(it, GroupsGetMembersFieldsResponse::class.java)
    }
    .apply {
        groupId?.let { addParam("group_id", it) }
        sort?.let { addParam("sort", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        filter?.let { addParam("filter", it.value) }
    }

    /**
     * @param groupId
     * @return [VKRequest] with [Unit]
     */
    fun groupsGetOnlineStatus(groupId: UserId): VKRequest<Unit> =
            NewApiRequest("groups.getOnlineStatus") {
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Returns a list of requests to the community.
     *
     * @param groupId - Community ID.
     * @param offset - Offset needed to return a specific subset of results.
     * @param count - Number of results to return.
     * @param fields - Profile fields to return.
     * @return [VKRequest] with [GroupsGetRequestsFieldsResponse]
     */
    fun groupsGetRequests(
        groupId: UserId,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<GroupsGetRequestsFieldsResponse> = NewApiRequest("groups.getRequests") {
        GsonHolder.gson.fromJson(it, GroupsGetRequestsFieldsResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns community settings.
     *
     * @param groupId - Community ID.
     * @return [VKRequest] with [GroupsGetSettingsResponse]
     */
    fun groupsGetSettings(groupId: UserId): VKRequest<GroupsGetSettingsResponse> =
            NewApiRequest("groups.getSettings") {
        GsonHolder.gson.fromJson(it, GroupsGetSettingsResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * List of group's tags
     *
     * @param groupId
     * @return [VKRequest] with [Unit]
     */
    fun groupsGetTagList(groupId: UserId): VKRequest<List<GroupsGroupTag>> =
            NewApiRequest("groups.getTagList") {
        val typeToken = object: TypeToken<List<GroupsGroupTag>>() {}.type
        GsonHolder.gson.fromJson<List<GroupsGroupTag>>(it, typeToken)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * @return [VKRequest] with [GroupsGetTokenPermissionsResponse]
     */
    fun groupsGetTokenPermissions(): VKRequest<GroupsGetTokenPermissionsResponse> =
            NewApiRequest("groups.getTokenPermissions") {
        GsonHolder.gson.fromJson(it, GroupsGetTokenPermissionsResponse::class.java)
    }

    /**
     * Allows to invite friends to the community.
     *
     * @param groupId - Community ID.
     * @param userId - User ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsInvite(groupId: UserId, userId: UserId): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.invite") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("user_id", userId, min = 1)
    }

    /**
     * Returns information specifying whether a user is a member of a community.
     *
     * @param groupId - ID or screen name of the community.
     * @param userId - User ID.
     * @param userIds - User IDs.
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun groupsIsMember(
        groupId: String,
        userId: UserId? = null,
        userIds: List<UserId>? = null
    ): VKRequest<BaseBoolInt> = NewApiRequest("groups.isMember") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("group_id", groupId)
        userId?.let { addParam("user_id", it, min = 0) }
        userIds?.let { addParam("user_ids", it) }
    }

    /**
     * With this method you can join the group or public page, and also confirm your participation
     * in an event.
     *
     * @param groupId - ID or screen name of the community.
     * @param notSure - Optional parameter which is taken into account when 'gid' belongs to the
     * event_ '1' - Perhaps I will attend, '0' - I will be there for sure (default), ,
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsJoin(groupId: UserId? = null, notSure: String? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.join") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 1) }
        notSure?.let { addParam("not_sure", it) }
    }

    /**
     * With this method you can leave a group, public page, or event.
     *
     * @param groupId - ID or screen name of the community.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsLeave(groupId: UserId): VKRequest<BaseOkResponse> = NewApiRequest("groups.leave") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Removes a user from the community.
     *
     * @param groupId - Community ID.
     * @param userId - User ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsRemoveUser(groupId: UserId, userId: UserId): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.removeUser") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("user_id", userId, min = 1)
    }

    /**
     * Allows to reorder links in the community.
     *
     * @param groupId - Community ID.
     * @param linkId - Link ID.
     * @param after - ID of the link after which to place the link with 'link_id'.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsReorderLink(
        groupId: UserId,
        linkId: Int,
        after: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.reorderLink") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("link_id", linkId, min = 0)
        after?.let { addParam("after", it, min = 0) }
    }

    /**
     * Returns a list of communities matching the search criteria.
     *
     * @param q - Search query string.
     * @param type - Community type. Possible values_ 'group, page, event.'
     * @param countryId - Country ID.
     * @param cityId - City ID. If this parameter is transmitted, country_id is ignored.
     * @param future - '1' - to return only upcoming events. Works with the 'type' = 'event' only.
     * @param market - '1' - to return communities with enabled market only.
     * @param sort - Sort order. Possible values_ *'0' - default sorting (similar the full version
     * of the site),, *'1' - by growth speed,, *'2'- by the "day attendance/members number" ratio,,
     * *'3' - by the "Likes number/members number" ratio,, *'4' - by the "comments number/members
     * number" ratio,, *'5' - by the "boards entries number/members number" ratio.
     * @param offset - Offset needed to return a specific subset of results.
     * @param count - Number of communities to return. "Note that you can not receive more than
     * first thousand of results, regardless of 'count' and 'offset' values."
     * @return [VKRequest] with [GroupsSearchResponse]
     */
    fun groupsSearch(
        q: String,
        type: GroupsSearchType? = null,
        countryId: Int? = null,
        cityId: Int? = null,
        future: Boolean? = null,
        market: Boolean? = null,
        sort: GroupsSearchSort? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<GroupsSearchResponse> = NewApiRequest("groups.search") {
        GsonHolder.gson.fromJson(it, GroupsSearchResponse::class.java)
    }
    .apply {
        addParam("q", q)
        type?.let { addParam("type", it.value) }
        countryId?.let { addParam("country_id", it, min = 0) }
        cityId?.let { addParam("city_id", it, min = 0) }
        future?.let { addParam("future", it) }
        market?.let { addParam("market", it) }
        sort?.let { addParam("sort", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Allow to set notifications settings for group.
     *
     * @param groupId - Community ID.
     * @param serverId - Server ID.
     * @param apiVersion
     * @param messageNew - A new incoming message has been received ('0' - disabled, '1' - enabled).
     * @param messageReply - A new outcoming message has been received ('0' - disabled, '1' -
     * enabled).
     * @param messageAllow - Allowed messages notifications ('0' - disabled, '1' - enabled).
     * @param messageEdit
     * @param messageDeny - Denied messages notifications ('0' - disabled, '1' - enabled).
     * @param messageTypingState
     * @param photoNew - New photos notifications ('0' - disabled, '1' - enabled).
     * @param audioNew - New audios notifications ('0' - disabled, '1' - enabled).
     * @param videoNew - New videos notifications ('0' - disabled, '1' - enabled).
     * @param wallReplyNew - New wall replies notifications ('0' - disabled, '1' - enabled).
     * @param wallReplyEdit - Wall replies edited notifications ('0' - disabled, '1' - enabled).
     * @param wallReplyDelete - A wall comment has been deleted ('0' - disabled, '1' - enabled).
     * @param wallReplyRestore - A wall comment has been restored ('0' - disabled, '1' - enabled).
     * @param wallPostNew - New wall posts notifications ('0' - disabled, '1' - enabled).
     * @param wallRepost - New wall posts notifications ('0' - disabled, '1' - enabled).
     * @param boardPostNew - New board posts notifications ('0' - disabled, '1' - enabled).
     * @param boardPostEdit - Board posts edited notifications ('0' - disabled, '1' - enabled).
     * @param boardPostRestore - Board posts restored notifications ('0' - disabled, '1' - enabled).
     * @param boardPostDelete - Board posts deleted notifications ('0' - disabled, '1' - enabled).
     * @param photoCommentNew - New comment to photo notifications ('0' - disabled, '1' - enabled).
     * @param photoCommentEdit - A photo comment has been edited ('0' - disabled, '1' - enabled).
     * @param photoCommentDelete - A photo comment has been deleted ('0' - disabled, '1' - enabled).
     * @param photoCommentRestore - A photo comment has been restored ('0' - disabled, '1' -
     * enabled).
     * @param videoCommentNew - New comment to video notifications ('0' - disabled, '1' - enabled).
     * @param videoCommentEdit - A video comment has been edited ('0' - disabled, '1' - enabled).
     * @param videoCommentDelete - A video comment has been deleted ('0' - disabled, '1' - enabled).
     * @param videoCommentRestore - A video comment has been restored ('0' - disabled, '1' -
     * enabled).
     * @param marketCommentNew - New comment to market item notifications ('0' - disabled, '1' -
     * enabled).
     * @param marketCommentEdit - A market comment has been edited ('0' - disabled, '1' - enabled).
     * @param marketCommentDelete - A market comment has been deleted ('0' - disabled, '1' -
     * enabled).
     * @param marketCommentRestore - A market comment has been restored ('0' - disabled, '1' -
     * enabled).
     * @param marketOrderNew
     * @param marketOrderEdit
     * @param pollVoteNew - A vote in a public poll has been added ('0' - disabled, '1' - enabled).
     * @param groupJoin - Joined community notifications ('0' - disabled, '1' - enabled).
     * @param groupLeave - Left community notifications ('0' - disabled, '1' - enabled).
     * @param groupChangeSettings
     * @param groupChangePhoto
     * @param groupOfficersEdit
     * @param userBlock - User added to community blacklist
     * @param userUnblock - User removed from community blacklist
     * @param leadFormsNew - New form in lead forms
     * @param likeAdd
     * @param likeRemove
     * @param messageEvent
     * @param donutSubscriptionCreate
     * @param donutSubscriptionProlonged
     * @param donutSubscriptionCancelled
     * @param donutSubscriptionPriceChanged
     * @param donutSubscriptionExpired
     * @param donutMoneyWithdraw
     * @param donutMoneyWithdrawError
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsSetCallbackSettings(
        groupId: UserId,
        serverId: Int? = null,
        apiVersion: String? = null,
        messageNew: Boolean? = null,
        messageReply: Boolean? = null,
        messageAllow: Boolean? = null,
        messageEdit: Boolean? = null,
        messageDeny: Boolean? = null,
        messageTypingState: Boolean? = null,
        photoNew: Boolean? = null,
        audioNew: Boolean? = null,
        videoNew: Boolean? = null,
        wallReplyNew: Boolean? = null,
        wallReplyEdit: Boolean? = null,
        wallReplyDelete: Boolean? = null,
        wallReplyRestore: Boolean? = null,
        wallPostNew: Boolean? = null,
        wallRepost: Boolean? = null,
        boardPostNew: Boolean? = null,
        boardPostEdit: Boolean? = null,
        boardPostRestore: Boolean? = null,
        boardPostDelete: Boolean? = null,
        photoCommentNew: Boolean? = null,
        photoCommentEdit: Boolean? = null,
        photoCommentDelete: Boolean? = null,
        photoCommentRestore: Boolean? = null,
        videoCommentNew: Boolean? = null,
        videoCommentEdit: Boolean? = null,
        videoCommentDelete: Boolean? = null,
        videoCommentRestore: Boolean? = null,
        marketCommentNew: Boolean? = null,
        marketCommentEdit: Boolean? = null,
        marketCommentDelete: Boolean? = null,
        marketCommentRestore: Boolean? = null,
        marketOrderNew: Boolean? = null,
        marketOrderEdit: Boolean? = null,
        pollVoteNew: Boolean? = null,
        groupJoin: Boolean? = null,
        groupLeave: Boolean? = null,
        groupChangeSettings: Boolean? = null,
        groupChangePhoto: Boolean? = null,
        groupOfficersEdit: Boolean? = null,
        userBlock: Boolean? = null,
        userUnblock: Boolean? = null,
        leadFormsNew: Boolean? = null,
        likeAdd: Boolean? = null,
        likeRemove: Boolean? = null,
        messageEvent: Boolean? = null,
        donutSubscriptionCreate: Boolean? = null,
        donutSubscriptionProlonged: Boolean? = null,
        donutSubscriptionCancelled: Boolean? = null,
        donutSubscriptionPriceChanged: Boolean? = null,
        donutSubscriptionExpired: Boolean? = null,
        donutMoneyWithdraw: Boolean? = null,
        donutMoneyWithdrawError: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.setCallbackSettings") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        serverId?.let { addParam("server_id", it, min = 0) }
        apiVersion?.let { addParam("api_version", it) }
        messageNew?.let { addParam("message_new", it) }
        messageReply?.let { addParam("message_reply", it) }
        messageAllow?.let { addParam("message_allow", it) }
        messageEdit?.let { addParam("message_edit", it) }
        messageDeny?.let { addParam("message_deny", it) }
        messageTypingState?.let { addParam("message_typing_state", it) }
        photoNew?.let { addParam("photo_new", it) }
        audioNew?.let { addParam("audio_new", it) }
        videoNew?.let { addParam("video_new", it) }
        wallReplyNew?.let { addParam("wall_reply_new", it) }
        wallReplyEdit?.let { addParam("wall_reply_edit", it) }
        wallReplyDelete?.let { addParam("wall_reply_delete", it) }
        wallReplyRestore?.let { addParam("wall_reply_restore", it) }
        wallPostNew?.let { addParam("wall_post_new", it) }
        wallRepost?.let { addParam("wall_repost", it) }
        boardPostNew?.let { addParam("board_post_new", it) }
        boardPostEdit?.let { addParam("board_post_edit", it) }
        boardPostRestore?.let { addParam("board_post_restore", it) }
        boardPostDelete?.let { addParam("board_post_delete", it) }
        photoCommentNew?.let { addParam("photo_comment_new", it) }
        photoCommentEdit?.let { addParam("photo_comment_edit", it) }
        photoCommentDelete?.let { addParam("photo_comment_delete", it) }
        photoCommentRestore?.let { addParam("photo_comment_restore", it) }
        videoCommentNew?.let { addParam("video_comment_new", it) }
        videoCommentEdit?.let { addParam("video_comment_edit", it) }
        videoCommentDelete?.let { addParam("video_comment_delete", it) }
        videoCommentRestore?.let { addParam("video_comment_restore", it) }
        marketCommentNew?.let { addParam("market_comment_new", it) }
        marketCommentEdit?.let { addParam("market_comment_edit", it) }
        marketCommentDelete?.let { addParam("market_comment_delete", it) }
        marketCommentRestore?.let { addParam("market_comment_restore", it) }
        marketOrderNew?.let { addParam("market_order_new", it) }
        marketOrderEdit?.let { addParam("market_order_edit", it) }
        pollVoteNew?.let { addParam("poll_vote_new", it) }
        groupJoin?.let { addParam("group_join", it) }
        groupLeave?.let { addParam("group_leave", it) }
        groupChangeSettings?.let { addParam("group_change_settings", it) }
        groupChangePhoto?.let { addParam("group_change_photo", it) }
        groupOfficersEdit?.let { addParam("group_officers_edit", it) }
        userBlock?.let { addParam("user_block", it) }
        userUnblock?.let { addParam("user_unblock", it) }
        leadFormsNew?.let { addParam("lead_forms_new", it) }
        likeAdd?.let { addParam("like_add", it) }
        likeRemove?.let { addParam("like_remove", it) }
        messageEvent?.let { addParam("message_event", it) }
        donutSubscriptionCreate?.let { addParam("donut_subscription_create", it) }
        donutSubscriptionProlonged?.let { addParam("donut_subscription_prolonged", it) }
        donutSubscriptionCancelled?.let { addParam("donut_subscription_cancelled", it) }
        donutSubscriptionPriceChanged?.let { addParam("donut_subscription_price_changed", it) }
        donutSubscriptionExpired?.let { addParam("donut_subscription_expired", it) }
        donutMoneyWithdraw?.let { addParam("donut_money_withdraw", it) }
        donutMoneyWithdrawError?.let { addParam("donut_money_withdraw_error", it) }
    }

    /**
     * Sets Long Poll notification settings
     *
     * @param groupId - Community ID.
     * @param enabled - Sets whether Long Poll is enabled ('0' - disabled, '1' - enabled).
     * @param apiVersion
     * @param messageNew - A new incoming message has been received ('0' - disabled, '1' - enabled).
     * @param messageReply - A new outcoming message has been received ('0' - disabled, '1' -
     * enabled).
     * @param messageAllow - Allowed messages notifications ('0' - disabled, '1' - enabled).
     * @param messageDeny - Denied messages notifications ('0' - disabled, '1' - enabled).
     * @param messageEdit - A message has been edited ('0' - disabled, '1' - enabled).
     * @param messageTypingState
     * @param photoNew - New photos notifications ('0' - disabled, '1' - enabled).
     * @param audioNew - New audios notifications ('0' - disabled, '1' - enabled).
     * @param videoNew - New videos notifications ('0' - disabled, '1' - enabled).
     * @param wallReplyNew - New wall replies notifications ('0' - disabled, '1' - enabled).
     * @param wallReplyEdit - Wall replies edited notifications ('0' - disabled, '1' - enabled).
     * @param wallReplyDelete - A wall comment has been deleted ('0' - disabled, '1' - enabled).
     * @param wallReplyRestore - A wall comment has been restored ('0' - disabled, '1' - enabled).
     * @param wallPostNew - New wall posts notifications ('0' - disabled, '1' - enabled).
     * @param wallRepost - New wall posts notifications ('0' - disabled, '1' - enabled).
     * @param boardPostNew - New board posts notifications ('0' - disabled, '1' - enabled).
     * @param boardPostEdit - Board posts edited notifications ('0' - disabled, '1' - enabled).
     * @param boardPostRestore - Board posts restored notifications ('0' - disabled, '1' - enabled).
     * @param boardPostDelete - Board posts deleted notifications ('0' - disabled, '1' - enabled).
     * @param photoCommentNew - New comment to photo notifications ('0' - disabled, '1' - enabled).
     * @param photoCommentEdit - A photo comment has been edited ('0' - disabled, '1' - enabled).
     * @param photoCommentDelete - A photo comment has been deleted ('0' - disabled, '1' - enabled).
     * @param photoCommentRestore - A photo comment has been restored ('0' - disabled, '1' -
     * enabled).
     * @param videoCommentNew - New comment to video notifications ('0' - disabled, '1' - enabled).
     * @param videoCommentEdit - A video comment has been edited ('0' - disabled, '1' - enabled).
     * @param videoCommentDelete - A video comment has been deleted ('0' - disabled, '1' - enabled).
     * @param videoCommentRestore - A video comment has been restored ('0' - disabled, '1' -
     * enabled).
     * @param marketCommentNew - New comment to market item notifications ('0' - disabled, '1' -
     * enabled).
     * @param marketCommentEdit - A market comment has been edited ('0' - disabled, '1' - enabled).
     * @param marketCommentDelete - A market comment has been deleted ('0' - disabled, '1' -
     * enabled).
     * @param marketCommentRestore - A market comment has been restored ('0' - disabled, '1' -
     * enabled).
     * @param pollVoteNew - A vote in a public poll has been added ('0' - disabled, '1' - enabled).
     * @param groupJoin - Joined community notifications ('0' - disabled, '1' - enabled).
     * @param groupLeave - Left community notifications ('0' - disabled, '1' - enabled).
     * @param groupChangeSettings
     * @param groupChangePhoto
     * @param groupOfficersEdit
     * @param userBlock - User added to community blacklist
     * @param userUnblock - User removed from community blacklist
     * @param likeAdd
     * @param likeRemove
     * @param messageEvent
     * @param donutSubscriptionCreate
     * @param donutSubscriptionProlonged
     * @param donutSubscriptionCancelled
     * @param donutSubscriptionPriceChanged
     * @param donutSubscriptionExpired
     * @param donutMoneyWithdraw
     * @param donutMoneyWithdrawError
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsSetLongPollSettings(
        groupId: UserId,
        enabled: Boolean? = null,
        apiVersion: String? = null,
        messageNew: Boolean? = null,
        messageReply: Boolean? = null,
        messageAllow: Boolean? = null,
        messageDeny: Boolean? = null,
        messageEdit: Boolean? = null,
        messageTypingState: Boolean? = null,
        photoNew: Boolean? = null,
        audioNew: Boolean? = null,
        videoNew: Boolean? = null,
        wallReplyNew: Boolean? = null,
        wallReplyEdit: Boolean? = null,
        wallReplyDelete: Boolean? = null,
        wallReplyRestore: Boolean? = null,
        wallPostNew: Boolean? = null,
        wallRepost: Boolean? = null,
        boardPostNew: Boolean? = null,
        boardPostEdit: Boolean? = null,
        boardPostRestore: Boolean? = null,
        boardPostDelete: Boolean? = null,
        photoCommentNew: Boolean? = null,
        photoCommentEdit: Boolean? = null,
        photoCommentDelete: Boolean? = null,
        photoCommentRestore: Boolean? = null,
        videoCommentNew: Boolean? = null,
        videoCommentEdit: Boolean? = null,
        videoCommentDelete: Boolean? = null,
        videoCommentRestore: Boolean? = null,
        marketCommentNew: Boolean? = null,
        marketCommentEdit: Boolean? = null,
        marketCommentDelete: Boolean? = null,
        marketCommentRestore: Boolean? = null,
        pollVoteNew: Boolean? = null,
        groupJoin: Boolean? = null,
        groupLeave: Boolean? = null,
        groupChangeSettings: Boolean? = null,
        groupChangePhoto: Boolean? = null,
        groupOfficersEdit: Boolean? = null,
        userBlock: Boolean? = null,
        userUnblock: Boolean? = null,
        likeAdd: Boolean? = null,
        likeRemove: Boolean? = null,
        messageEvent: Boolean? = null,
        donutSubscriptionCreate: Boolean? = null,
        donutSubscriptionProlonged: Boolean? = null,
        donutSubscriptionCancelled: Boolean? = null,
        donutSubscriptionPriceChanged: Boolean? = null,
        donutSubscriptionExpired: Boolean? = null,
        donutMoneyWithdraw: Boolean? = null,
        donutMoneyWithdrawError: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.setLongPollSettings") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        enabled?.let { addParam("enabled", it) }
        apiVersion?.let { addParam("api_version", it) }
        messageNew?.let { addParam("message_new", it) }
        messageReply?.let { addParam("message_reply", it) }
        messageAllow?.let { addParam("message_allow", it) }
        messageDeny?.let { addParam("message_deny", it) }
        messageEdit?.let { addParam("message_edit", it) }
        messageTypingState?.let { addParam("message_typing_state", it) }
        photoNew?.let { addParam("photo_new", it) }
        audioNew?.let { addParam("audio_new", it) }
        videoNew?.let { addParam("video_new", it) }
        wallReplyNew?.let { addParam("wall_reply_new", it) }
        wallReplyEdit?.let { addParam("wall_reply_edit", it) }
        wallReplyDelete?.let { addParam("wall_reply_delete", it) }
        wallReplyRestore?.let { addParam("wall_reply_restore", it) }
        wallPostNew?.let { addParam("wall_post_new", it) }
        wallRepost?.let { addParam("wall_repost", it) }
        boardPostNew?.let { addParam("board_post_new", it) }
        boardPostEdit?.let { addParam("board_post_edit", it) }
        boardPostRestore?.let { addParam("board_post_restore", it) }
        boardPostDelete?.let { addParam("board_post_delete", it) }
        photoCommentNew?.let { addParam("photo_comment_new", it) }
        photoCommentEdit?.let { addParam("photo_comment_edit", it) }
        photoCommentDelete?.let { addParam("photo_comment_delete", it) }
        photoCommentRestore?.let { addParam("photo_comment_restore", it) }
        videoCommentNew?.let { addParam("video_comment_new", it) }
        videoCommentEdit?.let { addParam("video_comment_edit", it) }
        videoCommentDelete?.let { addParam("video_comment_delete", it) }
        videoCommentRestore?.let { addParam("video_comment_restore", it) }
        marketCommentNew?.let { addParam("market_comment_new", it) }
        marketCommentEdit?.let { addParam("market_comment_edit", it) }
        marketCommentDelete?.let { addParam("market_comment_delete", it) }
        marketCommentRestore?.let { addParam("market_comment_restore", it) }
        pollVoteNew?.let { addParam("poll_vote_new", it) }
        groupJoin?.let { addParam("group_join", it) }
        groupLeave?.let { addParam("group_leave", it) }
        groupChangeSettings?.let { addParam("group_change_settings", it) }
        groupChangePhoto?.let { addParam("group_change_photo", it) }
        groupOfficersEdit?.let { addParam("group_officers_edit", it) }
        userBlock?.let { addParam("user_block", it) }
        userUnblock?.let { addParam("user_unblock", it) }
        likeAdd?.let { addParam("like_add", it) }
        likeRemove?.let { addParam("like_remove", it) }
        messageEvent?.let { addParam("message_event", it) }
        donutSubscriptionCreate?.let { addParam("donut_subscription_create", it) }
        donutSubscriptionProlonged?.let { addParam("donut_subscription_prolonged", it) }
        donutSubscriptionCancelled?.let { addParam("donut_subscription_cancelled", it) }
        donutSubscriptionPriceChanged?.let { addParam("donut_subscription_price_changed", it) }
        donutSubscriptionExpired?.let { addParam("donut_subscription_expired", it) }
        donutMoneyWithdraw?.let { addParam("donut_money_withdraw", it) }
        donutMoneyWithdrawError?.let { addParam("donut_money_withdraw_error", it) }
    }

    /**
     * @param groupId
     * @param messages
     * @param botsCapabilities
     * @param botsStartButton
     * @param botsAddToChat
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsSetSettings(
        groupId: UserId,
        messages: Boolean? = null,
        botsCapabilities: Boolean? = null,
        botsStartButton: Boolean? = null,
        botsAddToChat: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.setSettings") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        messages?.let { addParam("messages", it) }
        botsCapabilities?.let { addParam("bots_capabilities", it) }
        botsStartButton?.let { addParam("bots_start_button", it) }
        botsAddToChat?.let { addParam("bots_add_to_chat", it) }
    }

    /**
     * In order to save note about group participant
     *
     * @param groupId
     * @param userId
     * @param note - Note body
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun groupsSetUserNote(
        groupId: UserId,
        userId: UserId,
        note: String? = null
    ): VKRequest<BaseBoolInt> = NewApiRequest("groups.setUserNote") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("user_id", userId, min = 1)
        note?.let { addParam("note", it, maxLength = 96) }
    }

    /**
     * Add new group's tag
     *
     * @param groupId
     * @param tagName
     * @param tagColor
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun groupsTagAdd(
        groupId: UserId,
        tagName: String,
        tagColor: GroupsTagAddTagColor? = null
    ): VKRequest<BaseBoolInt> = NewApiRequest("groups.tagAdd") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("tag_name", tagName, maxLength = 20)
        tagColor?.let { addParam("tag_color", it.value) }
    }

    /**
     * Bind or unbind group's tag to user
     *
     * @param groupId
     * @param tagId
     * @param userId
     * @param act - Describe the action
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun groupsTagBind(
        groupId: UserId,
        tagId: Int,
        userId: UserId,
        act: GroupsTagBindAct
    ): VKRequest<BaseBoolInt> = NewApiRequest("groups.tagBind") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("tag_id", tagId, min = 0)
        addParam("user_id", userId, min = 1, max = 2000000000)
        addParam("act", act.value)
    }

    /**
     * Delete group's tag
     *
     * @param groupId
     * @param tagId
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun groupsTagDelete(groupId: UserId, tagId: Int): VKRequest<BaseBoolInt> =
            NewApiRequest("groups.tagDelete") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("tag_id", tagId, min = 0)
    }

    /**
     * Update group's tag
     *
     * @param groupId
     * @param tagId
     * @param tagName
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun groupsTagUpdate(
        groupId: UserId,
        tagId: Int,
        tagName: String
    ): VKRequest<BaseBoolInt> = NewApiRequest("groups.tagUpdate") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("tag_id", tagId, min = 0)
        addParam("tag_name", tagName, maxLength = 20)
    }

    /**
     * @param groupId
     * @param state
     * @param ref
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsToggleMarket(
        groupId: UserId,
        state: GroupsToggleMarketState,
        ref: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("groups.toggleMarket") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("state", state.value)
        ref?.let { addParam("ref", it) }
    }

    /**
     * @param groupId
     * @param ownerId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun groupsUnban(groupId: UserId, ownerId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("groups.unban") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        ownerId?.let { addParam("owner_id", it) }
    }
}
