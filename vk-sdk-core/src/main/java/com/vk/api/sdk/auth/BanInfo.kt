package com.vk.api.sdk.auth

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class BanInfo(
        val memberName: String? = null,
        val message: String? = null,
        val accessToken: String? = null,
        val secret: String? = null,
        val restoreUrl: String? = null
) : Parcelable {
    override fun writeToParcel(s: Parcel, flags: Int) {
        s.writeString(memberName)
        s.writeString(message)
        s.writeString(accessToken)
        s.writeString(secret)
        s.writeString(restoreUrl)
    }

    override fun describeContents() = 0

    companion object {
        @JvmStatic
        fun parse(json: JSONObject): BanInfo {
            val memberName = json.optString("member_name")
            val message = json.optString("message")
            val accessToken = json.optString("access_token")
            val secret = json.optString("secret")
            val restoreURL = json.optString("restore_url")
            return BanInfo(memberName, message, accessToken, secret, restoreURL)
        }
        @JvmField val CREATOR = object : Parcelable.Creator<BanInfo> {
            override fun createFromParcel(source: Parcel): BanInfo {
                return source.let {
                    BanInfo(it.readString(),
                            it.readString(),
                            it.readString(),
                            it.readString(),
                            it.readString()
                    )
                }
            }

            override fun newArray(size: Int): Array<BanInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}