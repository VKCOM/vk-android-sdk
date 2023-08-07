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
package com.vk.sdk.api.ads

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.ads.dto.AdsAccountDto
import com.vk.sdk.api.ads.dto.AdsAdDto
import com.vk.sdk.api.ads.dto.AdsAdLayoutDto
import com.vk.sdk.api.ads.dto.AdsCampaignDto
import com.vk.sdk.api.ads.dto.AdsCheckLinkLinkTypeDto
import com.vk.sdk.api.ads.dto.AdsClientDto
import com.vk.sdk.api.ads.dto.AdsCreateAdStatusDto
import com.vk.sdk.api.ads.dto.AdsCreateCampaignStatusDto
import com.vk.sdk.api.ads.dto.AdsCreateClientsStatusDto
import com.vk.sdk.api.ads.dto.AdsCreateLookalikeRequestResponseDto
import com.vk.sdk.api.ads.dto.AdsCreateTargetGroupResponseDto
import com.vk.sdk.api.ads.dto.AdsCreateTargetPixelResponseDto
import com.vk.sdk.api.ads.dto.AdsDemoStatsDto
import com.vk.sdk.api.ads.dto.AdsFloodStatsDto
import com.vk.sdk.api.ads.dto.AdsGetCampaignsFieldsDto
import com.vk.sdk.api.ads.dto.AdsGetCategoriesResponseDto
import com.vk.sdk.api.ads.dto.AdsGetDemographicsIdsTypeDto
import com.vk.sdk.api.ads.dto.AdsGetDemographicsPeriodDto
import com.vk.sdk.api.ads.dto.AdsGetLookalikeRequestsResponseDto
import com.vk.sdk.api.ads.dto.AdsGetMusiciansResponseDto
import com.vk.sdk.api.ads.dto.AdsGetPostsReachIdsTypeDto
import com.vk.sdk.api.ads.dto.AdsGetStatisticsIdsTypeDto
import com.vk.sdk.api.ads.dto.AdsGetStatisticsPeriodDto
import com.vk.sdk.api.ads.dto.AdsGetStatisticsStatsFieldsDto
import com.vk.sdk.api.ads.dto.AdsGetSuggestionsSectionDto
import com.vk.sdk.api.ads.dto.AdsGetTargetingStatsAdFormatDto
import com.vk.sdk.api.ads.dto.AdsGetUploadURLAdFormatDto
import com.vk.sdk.api.ads.dto.AdsLinkStatusDto
import com.vk.sdk.api.ads.dto.AdsPromotedPostReachDto
import com.vk.sdk.api.ads.dto.AdsRejectReasonDto
import com.vk.sdk.api.ads.dto.AdsRemoveTargetContactsResponseDto
import com.vk.sdk.api.ads.dto.AdsSaveLookalikeRequestResultResponseDto
import com.vk.sdk.api.ads.dto.AdsShareTargetGroupResponseDto
import com.vk.sdk.api.ads.dto.AdsStatsDto
import com.vk.sdk.api.ads.dto.AdsTargSettingsDto
import com.vk.sdk.api.ads.dto.AdsTargStatsDto
import com.vk.sdk.api.ads.dto.AdsTargSuggestionsDto
import com.vk.sdk.api.ads.dto.AdsTargetGroupDto
import com.vk.sdk.api.ads.dto.AdsTargetPixelInfoDto
import com.vk.sdk.api.ads.dto.AdsUpdateAdsStatusDto
import com.vk.sdk.api.ads.dto.AdsUpdateClientsStatusDto
import com.vk.sdk.api.ads.dto.AdsUpdateOfficeUsersResultDto
import com.vk.sdk.api.ads.dto.AdsUserSpecificationCuttedDto
import com.vk.sdk.api.ads.dto.AdsUserSpecificationDto
import com.vk.sdk.api.ads.dto.AdsUsersDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class AdsService {
    /**
     * Adds managers and/or supervisors to advertising account.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe added managers. Description of
     * 'user_specification' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsAddOfficeUsers(accountId: Int, data: List<AdsUserSpecificationCuttedDto>):
            VKRequest<List<Boolean>> = NewApiRequest("ads.addOfficeUsers") {
        GsonHolder.gson.parseList<Boolean>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("data", GsonHolder.gson.toJson(data))
    }

    /**
     * Allows to check the ad link.
     *
     * @param accountId - Advertising account ID.
     * @param linkType - Object type_ *'community' - community,, *'post' - community post,,
     * *'application' - VK application,, *'video' - video,, *'site' - external site.
     * @param linkUrl - Object URL.
     * @param campaignId - Campaign ID
     * @return [VKRequest] with [AdsLinkStatusDto]
     */
    fun adsCheckLink(
        accountId: Int,
        linkType: AdsCheckLinkLinkTypeDto,
        linkUrl: String,
        campaignId: Int? = null
    ): VKRequest<AdsLinkStatusDto> = NewApiRequest("ads.checkLink") {
        GsonHolder.gson.parse<AdsLinkStatusDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("link_type", linkType.value)
        addParam("link_url", linkUrl)
        campaignId?.let { addParam("campaign_id", it) }
    }

    /**
     * Creates ads.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe created ads. Description of
     * 'ad_specification' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsCreateAds(accountId: Int, data: String): VKRequest<List<AdsCreateAdStatusDto>> =
            NewApiRequest("ads.createAds") {
        GsonHolder.gson.parseList<AdsCreateAdStatusDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("data", data)
    }

    /**
     * Creates advertising campaigns.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe created campaigns. Description
     * of 'campaign_specification' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsCreateCampaigns(accountId: Int, data: String):
            VKRequest<List<AdsCreateCampaignStatusDto>> = NewApiRequest("ads.createCampaigns") {
        GsonHolder.gson.parseList<AdsCreateCampaignStatusDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("data", data)
    }

    /**
     * Creates clients of an advertising agency.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe created campaigns. Description
     * of 'client_specification' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsCreateClients(accountId: Int, data: String): VKRequest<List<AdsCreateClientsStatusDto>> =
            NewApiRequest("ads.createClients") {
        GsonHolder.gson.parseList<AdsCreateClientsStatusDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("data", data)
    }

    /**
     * @param accountId
     * @param sourceType
     * @param clientId
     * @param retargetingGroupId
     * @return [VKRequest] with [AdsCreateLookalikeRequestResponseDto]
     */
    fun adsCreateLookalikeRequest(
        accountId: Int,
        sourceType: String,
        clientId: Int? = null,
        retargetingGroupId: Int? = null
    ): VKRequest<AdsCreateLookalikeRequestResponseDto> =
            NewApiRequest("ads.createLookalikeRequest") {
        GsonHolder.gson.parse<AdsCreateLookalikeRequestResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("source_type", sourceType)
        clientId?.let { addParam("client_id", it) }
        retargetingGroupId?.let { addParam("retargeting_group_id", it) }
    }

    /**
     * Creates a group to re-target ads for users who visited advertiser's site (viewed information
     * about the product, registered, etc.).
     *
     * @param accountId - Advertising account ID.
     * @param name - Name of the target group - a string up to 64 characters long.
     * @param lifetime - 'For groups with auditory created with pixel code only.', , Number of days
     * after that users will be automatically removed from the group.
     * @param clientId - 'Only for advertising agencies.', ID of the client with the advertising
     * account where the group will be created.
     * @param targetPixelId
     * @param targetPixelRules
     * @return [VKRequest] with [AdsCreateTargetGroupResponseDto]
     */
    fun adsCreateTargetGroup(
        accountId: Int,
        name: String,
        lifetime: Int,
        clientId: Int? = null,
        targetPixelId: Int? = null,
        targetPixelRules: String? = null
    ): VKRequest<AdsCreateTargetGroupResponseDto> = NewApiRequest("ads.createTargetGroup") {
        GsonHolder.gson.parse<AdsCreateTargetGroupResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("name", name)
        addParam("lifetime", lifetime, min = 1, max = 720)
        clientId?.let { addParam("client_id", it) }
        targetPixelId?.let { addParam("target_pixel_id", it) }
        targetPixelRules?.let { addParam("target_pixel_rules", it) }
    }

    /**
     * @param accountId
     * @param name
     * @param categoryId
     * @param clientId
     * @param domain
     * @return [VKRequest] with [AdsCreateTargetPixelResponseDto]
     */
    fun adsCreateTargetPixel(
        accountId: Int,
        name: String,
        categoryId: Int,
        clientId: Int? = null,
        domain: String? = null
    ): VKRequest<AdsCreateTargetPixelResponseDto> = NewApiRequest("ads.createTargetPixel") {
        GsonHolder.gson.parse<AdsCreateTargetPixelResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("name", name)
        addParam("category_id", categoryId)
        clientId?.let { addParam("client_id", it) }
        domain?.let { addParam("domain", it) }
    }

    /**
     * Archives ads.
     *
     * @param accountId - Advertising account ID.
     * @param ids - Serialized JSON array with ad IDs.
     * @return [VKRequest] with [Unit]
     */
    fun adsDeleteAds(accountId: Int, ids: String): VKRequest<List<Int>> =
            NewApiRequest("ads.deleteAds") {
        GsonHolder.gson.parseList<Int>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ids", ids)
    }

    /**
     * Archives advertising campaigns.
     *
     * @param accountId - Advertising account ID.
     * @param ids - Serialized JSON array with IDs of deleted campaigns.
     * @return [VKRequest] with [Unit]
     */
    fun adsDeleteCampaigns(accountId: Int, ids: String): VKRequest<List<Int>> =
            NewApiRequest("ads.deleteCampaigns") {
        GsonHolder.gson.parseList<Int>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ids", ids)
    }

    /**
     * Archives clients of an advertising agency.
     *
     * @param accountId - Advertising account ID.
     * @param ids - Serialized JSON array with IDs of deleted clients.
     * @return [VKRequest] with [Unit]
     */
    fun adsDeleteClients(accountId: Int, ids: String): VKRequest<List<Int>> =
            NewApiRequest("ads.deleteClients") {
        GsonHolder.gson.parseList<Int>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ids", ids)
    }

    /**
     * Deletes a retarget group.
     *
     * @param accountId - Advertising account ID.
     * @param targetGroupId - Group ID.
     * @param clientId - 'Only for advertising agencies.' , ID of the client with the advertising
     * account where the group will be created.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun adsDeleteTargetGroup(
        accountId: Int,
        targetGroupId: Int,
        clientId: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("ads.deleteTargetGroup") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("target_group_id", targetGroupId)
        clientId?.let { addParam("client_id", it) }
    }

    /**
     * @param accountId
     * @param targetPixelId
     * @param clientId
     * @return [VKRequest] with [Any]
     */
    fun adsDeleteTargetPixel(
        accountId: Int,
        targetPixelId: Int,
        clientId: Int? = null
    ): VKRequest<Any> = NewApiRequest("ads.deleteTargetPixel") {
        GsonHolder.gson.parse<Any>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("target_pixel_id", targetPixelId)
        clientId?.let { addParam("client_id", it) }
    }

    /**
     * Returns a list of advertising accounts.
     *
     * @return [VKRequest] with [Unit]
     */
    fun adsGetAccounts(): VKRequest<List<AdsAccountDto>> = NewApiRequest("ads.getAccounts") {
        GsonHolder.gson.parseList<AdsAccountDto>(it)
    }

    /**
     * Returns number of ads.
     *
     * @param accountId - Advertising account ID.
     * @param adIds - Filter by ads. Serialized JSON array with ad IDs. If the parameter is null,
     * all ads will be shown.
     * @param campaignIds - Filter by advertising campaigns. Serialized JSON array with campaign
     * IDs. If the parameter is null, ads of all campaigns will be shown.
     * @param clientId - 'Available and required for advertising agencies.' ID of the client ads are
     * retrieved from.
     * @param includeDeleted - Flag that specifies whether archived ads shall be shown_ *0 - show
     * only active ads,, *1 - show all ads.
     * @param onlyDeleted - Flag that specifies whether to show only archived ads_ *0 - show all
     * ads,, *1 - show only archived ads. Available when include_deleted flag is *1
     * @param limit - Limit of number of returned ads. Used only if ad_ids parameter is null, and
     * 'campaign_ids' parameter contains ID of only one campaign.
     * @param offset - Offset. Used in the same cases as 'limit' parameter.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetAds(
        accountId: Int,
        adIds: String? = null,
        campaignIds: String? = null,
        clientId: Int? = null,
        includeDeleted: Boolean? = null,
        onlyDeleted: Boolean? = null,
        limit: Int? = null,
        offset: Int? = null
    ): VKRequest<List<AdsAdDto>> = NewApiRequest("ads.getAds") {
        GsonHolder.gson.parseList<AdsAdDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        adIds?.let { addParam("ad_ids", it) }
        campaignIds?.let { addParam("campaign_ids", it) }
        clientId?.let { addParam("client_id", it) }
        includeDeleted?.let { addParam("include_deleted", it) }
        onlyDeleted?.let { addParam("only_deleted", it) }
        limit?.let { addParam("limit", it) }
        offset?.let { addParam("offset", it) }
    }

    /**
     * Returns descriptions of ad layouts.
     *
     * @param accountId - Advertising account ID.
     * @param clientId - 'For advertising agencies.' ID of the client ads are retrieved from.
     * @param includeDeleted - Flag that specifies whether archived ads shall be shown. *0 - show
     * only active ads,, *1 - show all ads.
     * @param onlyDeleted - Flag that specifies whether to show only archived ads_ *0 - show all
     * ads,, *1 - show only archived ads. Available when include_deleted flag is *1
     * @param campaignIds - Filter by advertising campaigns. Serialized JSON array with campaign
     * IDs. If the parameter is null, ads of all campaigns will be shown.
     * @param adIds - Filter by ads. Serialized JSON array with ad IDs. If the parameter is null,
     * all ads will be shown.
     * @param limit - Limit of number of returned ads. Used only if 'ad_ids' parameter is null, and
     * 'campaign_ids' parameter contains ID of only one campaign.
     * @param offset - Offset. Used in the same cases as 'limit' parameter.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetAdsLayout(
        accountId: Int,
        clientId: Int? = null,
        includeDeleted: Boolean? = null,
        onlyDeleted: Boolean? = null,
        campaignIds: String? = null,
        adIds: String? = null,
        limit: Int? = null,
        offset: Int? = null
    ): VKRequest<List<AdsAdLayoutDto>> = NewApiRequest("ads.getAdsLayout") {
        GsonHolder.gson.parseList<AdsAdLayoutDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        clientId?.let { addParam("client_id", it) }
        includeDeleted?.let { addParam("include_deleted", it) }
        onlyDeleted?.let { addParam("only_deleted", it) }
        campaignIds?.let { addParam("campaign_ids", it) }
        adIds?.let { addParam("ad_ids", it) }
        limit?.let { addParam("limit", it) }
        offset?.let { addParam("offset", it) }
    }

    /**
     * Returns ad targeting parameters.
     *
     * @param accountId - Advertising account ID.
     * @param adIds - Filter by ads. Serialized JSON array with ad IDs. If the parameter is null,
     * all ads will be shown.
     * @param campaignIds - Filter by advertising campaigns. Serialized JSON array with campaign
     * IDs. If the parameter is null, ads of all campaigns will be shown.
     * @param clientId - 'For advertising agencies.' ID of the client ads are retrieved from.
     * @param includeDeleted - flag that specifies whether archived ads shall be shown_ *0 - show
     * only active ads,, *1 - show all ads.
     * @param limit - Limit of number of returned ads. Used only if 'ad_ids' parameter is null, and
     * 'campaign_ids' parameter contains ID of only one campaign.
     * @param offset - Offset needed to return a specific subset of results.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetAdsTargeting(
        accountId: Int,
        adIds: String? = null,
        campaignIds: String? = null,
        clientId: Int? = null,
        includeDeleted: Boolean? = null,
        limit: Int? = null,
        offset: Int? = null
    ): VKRequest<List<AdsTargSettingsDto>> = NewApiRequest("ads.getAdsTargeting") {
        GsonHolder.gson.parseList<AdsTargSettingsDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        adIds?.let { addParam("ad_ids", it) }
        campaignIds?.let { addParam("campaign_ids", it) }
        clientId?.let { addParam("client_id", it) }
        includeDeleted?.let { addParam("include_deleted", it) }
        limit?.let { addParam("limit", it) }
        offset?.let { addParam("offset", it) }
    }

    /**
     * Returns current budget of the advertising account.
     *
     * @param accountId - Advertising account ID.
     * @return [VKRequest] with [String]
     */
    fun adsGetBudget(accountId: Int): VKRequest<String> = NewApiRequest("ads.getBudget") {
        GsonHolder.gson.parse<String>(it)
    }
    .apply {
        addParam("account_id", accountId)
    }

    /**
     * Returns a list of campaigns in an advertising account.
     *
     * @param accountId - Advertising account ID.
     * @param clientId - 'For advertising agencies'. ID of the client advertising campaigns are
     * retrieved from.
     * @param includeDeleted - Flag that specifies whether archived ads shall be shown. *0 - show
     * only active campaigns,, *1 - show all campaigns.
     * @param campaignIds - Filter of advertising campaigns to show. Serialized JSON array with
     * campaign IDs. Only campaigns that exist in 'campaign_ids' and belong to the specified
     * advertising account will be shown. If the parameter is null, all campaigns will be shown.
     * @param fields
     * @return [VKRequest] with [Unit]
     */
    fun adsGetCampaigns(
        accountId: Int,
        clientId: Int? = null,
        includeDeleted: Boolean? = null,
        campaignIds: String? = null,
        fields: List<AdsGetCampaignsFieldsDto>? = null
    ): VKRequest<List<AdsCampaignDto>> = NewApiRequest("ads.getCampaigns") {
        GsonHolder.gson.parseList<AdsCampaignDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        clientId?.let { addParam("client_id", it) }
        includeDeleted?.let { addParam("include_deleted", it) }
        campaignIds?.let { addParam("campaign_ids", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of possible ad categories.
     *
     * @param lang - Language. The full list of supported languages is
     * [vk.com/dev/api_requests|here].
     * @return [VKRequest] with [AdsGetCategoriesResponseDto]
     */
    fun adsGetCategories(lang: String? = null): VKRequest<AdsGetCategoriesResponseDto> =
            NewApiRequest("ads.getCategories") {
        GsonHolder.gson.parse<AdsGetCategoriesResponseDto>(it)
    }
    .apply {
        lang?.let { addParam("lang", it) }
    }

    /**
     * Returns a list of advertising agency's clients.
     *
     * @param accountId - Advertising account ID.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetClients(accountId: Int): VKRequest<List<AdsClientDto>> =
            NewApiRequest("ads.getClients") {
        GsonHolder.gson.parseList<AdsClientDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
    }

    /**
     * Returns demographics for ads or campaigns.
     *
     * @param accountId - Advertising account ID.
     * @param idsType - Type of requested objects listed in 'ids' parameter_ *ad - ads,, *campaign -
     * campaigns.
     * @param ids - IDs requested ads or campaigns, separated with a comma, depending on the value
     * set in 'ids_type'. Maximum 2000 objects.
     * @param period - Data grouping by dates_ *day - statistics by days,, *month - statistics by
     * months,, *overall - overall statistics. 'date_from' and 'date_to' parameters set temporary
     * limits.
     * @param dateFrom - Date to show statistics from. For different value of 'period' different
     * date format is used_ *day_ YYYY-MM-DD, example_ 2011-09-27 - September 27, 2011, **0 - day it
     * was created on,, *month_ YYYY-MM, example_ 2011-09 - September 2011, **0 - month it was created
     * in,, *overall_ 0.
     * @param dateTo - Date to show statistics to. For different value of 'period' different date
     * format is used_ *day_ YYYY-MM-DD, example_ 2011-09-27 - September 27, 2011, **0 - current day,,
     * *month_ YYYY-MM, example_ 2011-09 - September 2011, **0 - current month,, *overall_ 0.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetDemographics(
        accountId: Int,
        idsType: AdsGetDemographicsIdsTypeDto,
        ids: String,
        period: AdsGetDemographicsPeriodDto,
        dateFrom: String,
        dateTo: String
    ): VKRequest<List<AdsDemoStatsDto>> = NewApiRequest("ads.getDemographics") {
        GsonHolder.gson.parseList<AdsDemoStatsDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ids_type", idsType.value)
        addParam("ids", ids)
        addParam("period", period.value)
        addParam("date_from", dateFrom)
        addParam("date_to", dateTo)
    }

    /**
     * Returns information about current state of a counter - number of remaining runs of methods
     * and time to the next counter nulling in seconds.
     *
     * @param accountId - Advertising account ID.
     * @return [VKRequest] with [AdsFloodStatsDto]
     */
    fun adsGetFloodStats(accountId: Int): VKRequest<AdsFloodStatsDto> =
            NewApiRequest("ads.getFloodStats") {
        GsonHolder.gson.parse<AdsFloodStatsDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
    }

    /**
     * @param accountId
     * @param clientId
     * @param requestsIds
     * @param offset
     * @param limit
     * @param sortBy
     * @return [VKRequest] with [AdsGetLookalikeRequestsResponseDto]
     */
    fun adsGetLookalikeRequests(
        accountId: Int,
        clientId: Int? = null,
        requestsIds: String? = null,
        offset: Int? = null,
        limit: Int? = null,
        sortBy: String? = null
    ): VKRequest<AdsGetLookalikeRequestsResponseDto> = NewApiRequest("ads.getLookalikeRequests") {
        GsonHolder.gson.parse<AdsGetLookalikeRequestsResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        clientId?.let { addParam("client_id", it) }
        requestsIds?.let { addParam("requests_ids", it) }
        offset?.let { addParam("offset", it, min = 0) }
        limit?.let { addParam("limit", it, min = 0, max = 200) }
        sortBy?.let { addParam("sort_by", it) }
    }

    /**
     * @param artistName
     * @return [VKRequest] with [AdsGetMusiciansResponseDto]
     */
    fun adsGetMusicians(artistName: String): VKRequest<AdsGetMusiciansResponseDto> =
            NewApiRequest("ads.getMusicians") {
        GsonHolder.gson.parse<AdsGetMusiciansResponseDto>(it)
    }
    .apply {
        addParam("artist_name", artistName, minLength = 3)
    }

    /**
     * @param ids
     * @return [VKRequest] with [AdsGetMusiciansResponseDto]
     */
    fun adsGetMusiciansByIds(ids: List<UserId>): VKRequest<AdsGetMusiciansResponseDto> =
            NewApiRequest("ads.getMusiciansByIds") {
        GsonHolder.gson.parse<AdsGetMusiciansResponseDto>(it)
    }
    .apply {
        addParam("ids", ids, min = 1)
    }

    /**
     * Returns a list of managers and supervisors of advertising account.
     *
     * @param accountId - Advertising account ID.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetOfficeUsers(accountId: Int): VKRequest<List<AdsUsersDto>> =
            NewApiRequest("ads.getOfficeUsers") {
        GsonHolder.gson.parseList<AdsUsersDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
    }

    /**
     * Returns detailed statistics of promoted posts reach from campaigns and ads.
     *
     * @param accountId - Advertising account ID.
     * @param idsType - Type of requested objects listed in 'ids' parameter_ *ad - ads,, *campaign -
     * campaigns.
     * @param ids - IDs requested ads or campaigns, separated with a comma, depending on the value
     * set in 'ids_type'. Maximum 100 objects.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetPostsReach(
        accountId: Int,
        idsType: AdsGetPostsReachIdsTypeDto,
        ids: String
    ): VKRequest<List<AdsPromotedPostReachDto>> = NewApiRequest("ads.getPostsReach") {
        GsonHolder.gson.parseList<AdsPromotedPostReachDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ids_type", idsType.value)
        addParam("ids", ids)
    }

    /**
     * Returns a reason of ad rejection for pre-moderation.
     *
     * @param accountId - Advertising account ID.
     * @param adId - Ad ID.
     * @return [VKRequest] with [AdsRejectReasonDto]
     */
    fun adsGetRejectionReason(accountId: Int, adId: Int): VKRequest<AdsRejectReasonDto> =
            NewApiRequest("ads.getRejectionReason") {
        GsonHolder.gson.parse<AdsRejectReasonDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ad_id", adId)
    }

    /**
     * Returns statistics of performance indicators for ads, campaigns, clients or the whole
     * account.
     *
     * @param accountId - Advertising account ID.
     * @param idsType - Type of requested objects listed in 'ids' parameter_ *ad - ads,, *campaign -
     * campaigns,, *client - clients,, *office - account.
     * @param ids - IDs requested ads, campaigns, clients or account, separated with a comma,
     * depending on the value set in 'ids_type'. Maximum 2000 objects.
     * @param period - Data grouping by dates_ *day - statistics by days,, *month - statistics by
     * months,, *overall - overall statistics. 'date_from' and 'date_to' parameters set temporary
     * limits.
     * @param dateFrom - Date to show statistics from. For different value of 'period' different
     * date format is used_ *day_ YYYY-MM-DD, example_ 2011-09-27 - September 27, 2011, **0 - day it
     * was created on,, *month_ YYYY-MM, example_ 2011-09 - September 2011, **0 - month it was created
     * in,, *overall_ 0.
     * @param dateTo - Date to show statistics to. For different value of 'period' different date
     * format is used_ *day_ YYYY-MM-DD, example_ 2011-09-27 - September 27, 2011, **0 - current day,,
     * *month_ YYYY-MM, example_ 2011-09 - September 2011, **0 - current month,, *overall_ 0.
     * @param statsFields - Additional fields to add to statistics
     * @return [VKRequest] with [Unit]
     */
    fun adsGetStatistics(
        accountId: Int,
        idsType: AdsGetStatisticsIdsTypeDto,
        ids: String,
        period: AdsGetStatisticsPeriodDto,
        dateFrom: String,
        dateTo: String,
        statsFields: List<AdsGetStatisticsStatsFieldsDto>? = null
    ): VKRequest<List<AdsStatsDto>> = NewApiRequest("ads.getStatistics") {
        GsonHolder.gson.parseList<AdsStatsDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ids_type", idsType.value)
        addParam("ids", ids)
        addParam("period", period.value)
        addParam("date_from", dateFrom)
        addParam("date_to", dateTo)
        val statsFieldsJsonConverted = statsFields?.map {
            it.value
        }
        statsFieldsJsonConverted?.let { addParam("stats_fields", it) }
    }

    /**
     * Returns a set of auto-suggestions for various targeting parameters.
     *
     * @param section - Section, suggestions are retrieved in. Available values_ *countries -
     * request of a list of countries. If q is not set or blank, a short list of countries is shown.
     * Otherwise, a full list of countries is shown. *regions - requested list of regions. 'country'
     * parameter is required. *cities - requested list of cities. 'country' parameter is required.
     * *districts - requested list of districts. 'cities' parameter is required. *stations - requested
     * list of subway stations. 'cities' parameter is required. *streets - requested list of streets.
     * 'cities' parameter is required. *schools - requested list of educational organizations. 'cities'
     * parameter is required. *interests - requested list of interests. *positions - requested list of
     * positions (professions). *group_types - requested list of group types. *religions - requested
     * list of religious commitments. *browsers - requested list of browsers and mobile devices.
     * @param ids - Objects IDs separated by commas. If the parameter is passed, 'q, country,
     * cities' should not be passed.
     * @param q - Filter-line of the request (for countries, regions, cities, streets, schools,
     * interests, positions).
     * @param country - ID of the country objects are searched in.
     * @param cities - IDs of cities where objects are searched in, separated with a comma.
     * @param lang - Language of the returned string values. Supported languages_ *ru - Russian,,
     * *ua - Ukrainian,, *en - English.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetSuggestions(
        section: AdsGetSuggestionsSectionDto,
        ids: String? = null,
        q: String? = null,
        country: Int? = null,
        cities: String? = null,
        lang: String? = null
    ): VKRequest<List<AdsTargSuggestionsDto>> = NewApiRequest("ads.getSuggestions") {
        GsonHolder.gson.parseList<AdsTargSuggestionsDto>(it)
    }
    .apply {
        addParam("section", section.value)
        ids?.let { addParam("ids", it) }
        q?.let { addParam("q", it) }
        country?.let { addParam("country", it) }
        cities?.let { addParam("cities", it) }
        lang?.let { addParam("lang", it) }
    }

    /**
     * Returns a list of target groups.
     *
     * @param accountId - Advertising account ID.
     * @param clientId - 'Only for advertising agencies.', ID of the client with the advertising
     * account where the group will be created.
     * @param extended - '1' - to return pixel code.
     * @return [VKRequest] with [Unit]
     */
    fun adsGetTargetGroups(
        accountId: Int,
        clientId: Int? = null,
        extended: Boolean? = null
    ): VKRequest<List<AdsTargetGroupDto>> = NewApiRequest("ads.getTargetGroups") {
        GsonHolder.gson.parseList<AdsTargetGroupDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        clientId?.let { addParam("client_id", it) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * @param accountId
     * @param clientId
     * @return [VKRequest] with [Unit]
     */
    fun adsGetTargetPixels(accountId: Int, clientId: Int? = null):
            VKRequest<List<AdsTargetPixelInfoDto>> = NewApiRequest("ads.getTargetPixels") {
        GsonHolder.gson.parseList<AdsTargetPixelInfoDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        clientId?.let { addParam("client_id", it) }
    }

    /**
     * Returns the size of targeting audience, and also recommended values for CPC and CPM.
     *
     * @param accountId - Advertising account ID.
     * @param linkUrl - URL for the advertised object.
     * @param clientId
     * @param criteria - Serialized JSON object that describes targeting parameters. Description of
     * 'criteria' object see below.
     * @param adId - ID of an ad which targeting parameters shall be analyzed.
     * @param adFormat - Ad format. Possible values_ *'1' - image and text,, *'2' - big image,,
     * *'3' - exclusive format,, *'4' - community, square image,, *'7' - special app format,, *'8' -
     * special community format,, *'9' - post in community,, *'10' - app board.
     * @param adPlatform - Platforms to use for ad showing. Possible values_ (for 'ad_format' =
     * '1'), *'0' - VK and partner sites,, *'1' - VK only. (for 'ad_format' = '9'), *'all' - all
     * platforms,, *'desktop' - desktop version,, *'mobile' - mobile version and apps.
     * @param adPlatformNoWall
     * @param adPlatformNoAdNetwork
     * @param publisherPlatforms
     * @param linkDomain - Domain of the advertised object.
     * @param needPrecise - Additionally return recommended cpc and cpm to reach 5,10..95 percents
     * of audience.
     * @param impressionsLimitPeriod - Impressions limit period in seconds, must be a multiple of
     * 86400(day)
     * @return [VKRequest] with [AdsTargStatsDto]
     */
    fun adsGetTargetingStats(
        accountId: Int,
        linkUrl: String,
        clientId: Int? = null,
        criteria: String? = null,
        adId: Int? = null,
        adFormat: AdsGetTargetingStatsAdFormatDto? = null,
        adPlatform: String? = null,
        adPlatformNoWall: String? = null,
        adPlatformNoAdNetwork: String? = null,
        publisherPlatforms: String? = null,
        linkDomain: String? = null,
        needPrecise: Boolean? = null,
        impressionsLimitPeriod: Int? = null
    ): VKRequest<AdsTargStatsDto> = NewApiRequest("ads.getTargetingStats") {
        GsonHolder.gson.parse<AdsTargStatsDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("link_url", linkUrl)
        clientId?.let { addParam("client_id", it) }
        criteria?.let { addParam("criteria", it) }
        adId?.let { addParam("ad_id", it) }
        adFormat?.let { addParam("ad_format", it.value) }
        adPlatform?.let { addParam("ad_platform", it) }
        adPlatformNoWall?.let { addParam("ad_platform_no_wall", it) }
        adPlatformNoAdNetwork?.let { addParam("ad_platform_no_ad_network", it) }
        publisherPlatforms?.let { addParam("publisher_platforms", it) }
        linkDomain?.let { addParam("link_domain", it) }
        needPrecise?.let { addParam("need_precise", it) }
        impressionsLimitPeriod?.let { addParam("impressions_limit_period", it) }
    }

    /**
     * Returns URL to upload an ad photo to.
     *
     * @param adFormat - Ad format_ *1 - image and text,, *2 - big image,, *3 - exclusive format,,
     * *4 - community, square image,, *7 - special app format.
     * @param icon
     * @return [VKRequest] with [String]
     */
    fun adsGetUploadURL(adFormat: AdsGetUploadURLAdFormatDto, icon: Int? = null): VKRequest<String>
            = NewApiRequest("ads.getUploadURL") {
        GsonHolder.gson.parse<String>(it)
    }
    .apply {
        addParam("ad_format", adFormat.value)
        icon?.let { addParam("icon", it) }
    }

    /**
     * Returns URL to upload an ad video to.
     *
     * @return [VKRequest] with [String]
     */
    fun adsGetVideoUploadURL(): VKRequest<String> = NewApiRequest("ads.getVideoUploadURL") {
        GsonHolder.gson.parse<String>(it)
    }

    /**
     * Imports a list of advertiser's contacts to count VK registered users against the target
     * group.
     *
     * @param accountId - Advertising account ID.
     * @param targetGroupId - Target group ID.
     * @param contacts - List of phone numbers, emails or user IDs separated with a comma.
     * @param clientId - 'Only for advertising agencies.' , ID of the client with the advertising
     * account where the group will be created.
     * @return [VKRequest] with [Int]
     */
    fun adsImportTargetContacts(
        accountId: Int,
        targetGroupId: Int,
        contacts: String,
        clientId: Int? = null
    ): VKRequest<Int> = NewApiRequest("ads.importTargetContacts") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("target_group_id", targetGroupId)
        addParam("contacts", contacts)
        clientId?.let { addParam("client_id", it) }
    }

    /**
     * Removes managers and/or supervisors from advertising account.
     *
     * @param accountId - Advertising account ID.
     * @param ids - Serialized JSON array with IDs of deleted managers.
     * @return [VKRequest] with [Unit]
     */
    fun adsRemoveOfficeUsers(accountId: Int, ids: String): VKRequest<List<Boolean>> =
            NewApiRequest("ads.removeOfficeUsers") {
        GsonHolder.gson.parseList<Boolean>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("ids", ids)
    }

    /**
     * @param accountId
     * @param targetGroupId
     * @param contacts
     * @param clientId
     * @return [VKRequest] with [AdsRemoveTargetContactsResponseDto]
     */
    fun adsRemoveTargetContacts(
        accountId: Int,
        targetGroupId: Int,
        contacts: String,
        clientId: Int? = null
    ): VKRequest<AdsRemoveTargetContactsResponseDto> = NewApiRequest("ads.removeTargetContacts") {
        GsonHolder.gson.parse<AdsRemoveTargetContactsResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("target_group_id", targetGroupId)
        addParam("contacts", contacts)
        clientId?.let { addParam("client_id", it) }
    }

    /**
     * @param accountId
     * @param requestId
     * @param level
     * @param clientId
     * @return [VKRequest] with [AdsSaveLookalikeRequestResultResponseDto]
     */
    fun adsSaveLookalikeRequestResult(
        accountId: Int,
        requestId: Int,
        level: Int,
        clientId: Int? = null
    ): VKRequest<AdsSaveLookalikeRequestResultResponseDto> =
            NewApiRequest("ads.saveLookalikeRequestResult") {
        GsonHolder.gson.parse<AdsSaveLookalikeRequestResultResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("request_id", requestId)
        addParam("level", level)
        clientId?.let { addParam("client_id", it) }
    }

    /**
     * @param accountId
     * @param targetGroupId
     * @param clientId
     * @param shareWithClientId
     * @return [VKRequest] with [AdsShareTargetGroupResponseDto]
     */
    fun adsShareTargetGroup(
        accountId: Int,
        targetGroupId: Int,
        clientId: Int? = null,
        shareWithClientId: Int? = null
    ): VKRequest<AdsShareTargetGroupResponseDto> = NewApiRequest("ads.shareTargetGroup") {
        GsonHolder.gson.parse<AdsShareTargetGroupResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("target_group_id", targetGroupId)
        clientId?.let { addParam("client_id", it) }
        shareWithClientId?.let { addParam("share_with_client_id", it) }
    }

    /**
     * Edits ads.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe changes in ads. Description of
     * 'ad_edit_specification' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsUpdateAds(accountId: Int, data: String): VKRequest<List<AdsUpdateAdsStatusDto>> =
            NewApiRequest("ads.updateAds") {
        GsonHolder.gson.parseList<AdsUpdateAdsStatusDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("data", data)
    }

    /**
     * Edits advertising campaigns.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe changes in campaigns.
     * Description of 'campaign_mod' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsUpdateCampaigns(accountId: Int, data: String):
            VKRequest<List<AdsCreateCampaignStatusDto>> = NewApiRequest("ads.updateCampaigns") {
        GsonHolder.gson.parseList<AdsCreateCampaignStatusDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("data", data)
    }

    /**
     * Edits clients of an advertising agency.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe changes in clients. Description
     * of 'client_mod' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsUpdateClients(accountId: Int, data: String): VKRequest<List<AdsUpdateClientsStatusDto>> =
            NewApiRequest("ads.updateClients") {
        GsonHolder.gson.parseList<AdsUpdateClientsStatusDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("data", data)
    }

    /**
     * Adds managers and/or supervisors to advertising account.
     *
     * @param accountId - Advertising account ID.
     * @param data - Serialized JSON array of objects that describe added managers. Description of
     * 'user_specification' objects see below.
     * @return [VKRequest] with [Unit]
     */
    fun adsUpdateOfficeUsers(accountId: Int, data: List<AdsUserSpecificationDto>):
            VKRequest<List<AdsUpdateOfficeUsersResultDto>> =
            NewApiRequest("ads.updateOfficeUsers") {
        GsonHolder.gson.parseList<AdsUpdateOfficeUsersResultDto>(it)
    }
    .apply {
        addParam("account_id", accountId, min = 0)
        addParam("data", GsonHolder.gson.toJson(data))
    }

    /**
     * Edits a retarget group.
     *
     * @param accountId - Advertising account ID.
     * @param targetGroupId - Group ID.
     * @param name - New name of the target group - a string up to 64 characters long.
     * @param lifetime - 'Only for the groups that get audience from sites with user accounting
     * code.', Time in days when users added to a retarget group will be automatically excluded from
     * it. '0' - automatic exclusion is off.
     * @param clientId - 'Only for advertising agencies.' , ID of the client with the advertising
     * account where the group will be created.
     * @param domain - Domain of the site where user accounting code will be placed.
     * @param targetPixelId
     * @param targetPixelRules
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun adsUpdateTargetGroup(
        accountId: Int,
        targetGroupId: Int,
        name: String,
        lifetime: Int,
        clientId: Int? = null,
        domain: String? = null,
        targetPixelId: Int? = null,
        targetPixelRules: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("ads.updateTargetGroup") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("target_group_id", targetGroupId)
        addParam("name", name)
        addParam("lifetime", lifetime, min = 1, max = 720)
        clientId?.let { addParam("client_id", it) }
        domain?.let { addParam("domain", it) }
        targetPixelId?.let { addParam("target_pixel_id", it) }
        targetPixelRules?.let { addParam("target_pixel_rules", it) }
    }

    /**
     * @param accountId
     * @param targetPixelId
     * @param name
     * @param categoryId
     * @param clientId
     * @param domain
     * @return [VKRequest] with [Any]
     */
    fun adsUpdateTargetPixel(
        accountId: Int,
        targetPixelId: Int,
        name: String,
        categoryId: Int,
        clientId: Int? = null,
        domain: String? = null
    ): VKRequest<Any> = NewApiRequest("ads.updateTargetPixel") {
        GsonHolder.gson.parse<Any>(it)
    }
    .apply {
        addParam("account_id", accountId)
        addParam("target_pixel_id", targetPixelId)
        addParam("name", name)
        addParam("category_id", categoryId)
        clientId?.let { addParam("client_id", it) }
        domain?.let { addParam("domain", it) }
    }

    object AdsCreateTargetGroupRestrictions {
        const val LIFETIME_MIN: Long = 1

        const val LIFETIME_MAX: Long = 720
    }

    object AdsGetLookalikeRequestsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val LIMIT_MIN: Long = 0

        const val LIMIT_MAX: Long = 200
    }

    object AdsGetMusiciansRestrictions {
        const val ARTIST_NAME_MIN_LENGTH: Int = 3
    }

    object AdsGetMusiciansByIdsRestrictions {
        const val IDS_MIN: Long = 1
    }

    object AdsUpdateOfficeUsersRestrictions {
        const val ACCOUNT_ID_MIN: Long = 0
    }

    object AdsUpdateTargetGroupRestrictions {
        const val LIFETIME_MIN: Long = 1

        const val LIFETIME_MAX: Long = 720
    }
}
