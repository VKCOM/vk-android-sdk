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
package com.vk.sdk.api.classifieds.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseGeoCoordinates
import com.vk.sdk.api.base.dto.BaseImage
import com.vk.sdk.api.base.dto.BaseLinkButton
import com.vk.sdk.api.base.dto.BaseLinkProductStatus
import com.vk.sdk.api.groups.dto.GroupsGroupFull
import com.vk.sdk.api.market.dto.MarketPrice
import com.vk.sdk.api.photos.dto.PhotosPhoto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param internalOwnerId - Internal owner id
 * @param internalId - Internal id
 * @param id - Youla item id
 * @param ownerId - Youla item owner`s id
 * @param price - Youla item price
 * @param isOwner - If the current user is owner
 * @param description - Item description
 * @param geo
 * @param locationText - Compiled item location text (for ex_ distance to item in kilometers)
 * @param distance - Distance to item location
 * @param city - Item city name
 * @param status
 * @param blockMode - Classified blocking status
 * @param detailsUrl - Youla Item url for classifieds section block
 * @param actionUrl - Youla Item snippet url
 * @param photos - First 3 youla item photos
 * @param photoTotalCountDescription - How many photos are left in the original post
 * @param commercialProfileButton - Youla item author's profile
 * @param rootCategory - Youla item root category name
 * @param category - Youla item category name
 * @param subCategory - Youla item sub-category name
 * @param publishedDate - Youla item published date
 * @param group - Youla item group info
 * @param attributes - Youla item attributes
 * @param actionProperties - Youla item actions properties
 * @param address - Youla item address
 * @param radiusMeters - Item readius
 * @param distanceText - Distance to classified
 * @param statusInfo
 * @param menuActions
 * @param buttonActions
 * @param isUserBlacklisted - User blacklisted flag
 * @param favoriteCounter - Classified favorite counter
 * @param views - Classified views
 * @param blockTypeText - Decline reason text
 * @param shareUrl - Classified share ur
 * @param author - Author
 * @param youlaOwnerName - Youla item owner`s name
 * @param youlaUserId - Youla item owner`s id
 * @param title - Item title
 * @param onClickOptions - On click options
 * @param isFavorite - Information whether the current item has been added to bookmarks
 * @param thumb
 * @param photo
 */
data class ClassifiedsYoulaItemExtended(
    @SerializedName("internal_owner_id")
    val internalOwnerId: Int,
    @SerializedName("internal_id")
    val internalId: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("price")
    val price: MarketPrice,
    @SerializedName("is_owner")
    val isOwner: Boolean? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("geo")
    val geo: BaseGeoCoordinates? = null,
    @SerializedName("location_text")
    val locationText: String? = null,
    @SerializedName("distance")
    val distance: Int? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("status")
    val status: BaseLinkProductStatus? = null,
    @SerializedName("block_mode")
    val blockMode: ClassifiedsYoulaItemExtended.BlockMode? = null,
    @SerializedName("details_url")
    val detailsUrl: String? = null,
    @SerializedName("action_url")
    val actionUrl: String? = null,
    @SerializedName("photos")
    val photos: List<ClassifiedsYoulaItemPhoto>? = null,
    @SerializedName("photo_total_count_description")
    val photoTotalCountDescription: String? = null,
    @SerializedName("commercial_profile_button")
    val commercialProfileButton: BaseLinkButton? = null,
    @SerializedName("root_category")
    val rootCategory: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("sub_category")
    val subCategory: String? = null,
    @SerializedName("published_date")
    val publishedDate: Int? = null,
    @SerializedName("group")
    val group: GroupsGroupFull? = null,
    @SerializedName("attributes")
    val attributes: List<ClassifiedsYoulaItemAttribute>? = null,
    @SerializedName("action_properties")
    val actionProperties: ClassifiedsYoulaItemActionProperties? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("radius_meters")
    val radiusMeters: Int? = null,
    @SerializedName("distance_text")
    val distanceText: String? = null,
    @SerializedName("status_info")
    val statusInfo: ClassifiedsYoulaItemStatusInfo? = null,
    @SerializedName("menu_actions")
    val menuActions: List<ClassifiedsYoulaItemActionButton>? = null,
    @SerializedName("button_actions")
    val buttonActions: List<ClassifiedsYoulaItemActionButton>? = null,
    @SerializedName("is_user_blacklisted")
    val isUserBlacklisted: Boolean? = null,
    @SerializedName("favorite_counter")
    val favoriteCounter: Int? = null,
    @SerializedName("views")
    val views: Int? = null,
    @SerializedName("block_type_text")
    val blockTypeText: String? = null,
    @SerializedName("share_url")
    val shareUrl: String? = null,
    @SerializedName("author")
    val author: ClassifiedsYoulaItemVkAuthor? = null,
    @SerializedName("youla_owner_name")
    val youlaOwnerName: String? = null,
    @SerializedName("youla_user_id")
    val youlaUserId: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("on_click_options")
    val onClickOptions: ClassifiedsYoulaItemOnClickOptions? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("thumb")
    val thumb: List<BaseImage>? = null,
    @SerializedName("photo")
    val photo: PhotosPhoto? = null
) {
    enum class BlockMode(
        val value: Int
    ) {
        @SerializedName("0")
        NO_BLOCK(0),

        @SerializedName("1")
        BLOCKED(1),

        @SerializedName("2")
        REJECTED(2),

        @SerializedName("3")
        VK_BLOCKED(3);
    }
}
