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
package com.vk.sdk.api.messages.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import kotlin.String

/**
 * @param invite Who can invite users to chat
 * @param changeInfo Who can change chat info
 * @param changePin Who can change pinned message
 * @param useMassMentions Who can use mass mentions
 * @param seeInviteLink Who can see invite link
 * @param call Who can make calls
 * @param changeAdmins Who can change admins
 */
data class MessagesChatSettingsPermissions(
    @SerializedName(value="invite")
    val invite: Invite? = null,
    @SerializedName(value="change_info")
    val changeInfo: ChangeInfo? = null,
    @SerializedName(value="change_pin")
    val changePin: ChangePin? = null,
    @SerializedName(value="use_mass_mentions")
    val useMassMentions: UseMassMentions? = null,
    @SerializedName(value="see_invite_link")
    val seeInviteLink: SeeInviteLink? = null,
    @SerializedName(value="call")
    val call: Call? = null,
    @SerializedName(value="change_admins")
    val changeAdmins: ChangeAdmins? = null
) {
    enum class ChangeInfo(
        val value: String
    ) {
        OWNER("owner"),

        OWNER_AND_ADMINS("owner_and_admins"),

        ALL("all");

        class Serializer : JsonSerializer<ChangeInfo>, JsonDeserializer<ChangeInfo> {
            override fun serialize(
                src: ChangeInfo?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): ChangeInfo {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class Call(
        val value: String
    ) {
        OWNER("owner"),

        OWNER_AND_ADMINS("owner_and_admins"),

        ALL("all");

        class Serializer : JsonSerializer<Call>, JsonDeserializer<Call> {
            override fun serialize(
                src: Call?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): Call {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class UseMassMentions(
        val value: String
    ) {
        OWNER("owner"),

        OWNER_AND_ADMINS("owner_and_admins"),

        ALL("all");

        class Serializer : JsonSerializer<UseMassMentions>, JsonDeserializer<UseMassMentions> {
            override fun serialize(
                src: UseMassMentions?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): UseMassMentions {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class ChangePin(
        val value: String
    ) {
        OWNER("owner"),

        OWNER_AND_ADMINS("owner_and_admins"),

        ALL("all");

        class Serializer : JsonSerializer<ChangePin>, JsonDeserializer<ChangePin> {
            override fun serialize(
                src: ChangePin?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): ChangePin {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class ChangeAdmins(
        val value: String
    ) {
        OWNER("owner"),

        OWNER_AND_ADMINS("owner_and_admins");

        class Serializer : JsonSerializer<ChangeAdmins>, JsonDeserializer<ChangeAdmins> {
            override fun serialize(
                src: ChangeAdmins?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): ChangeAdmins {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class Invite(
        val value: String
    ) {
        OWNER("owner"),

        OWNER_AND_ADMINS("owner_and_admins"),

        ALL("all");

        class Serializer : JsonSerializer<Invite>, JsonDeserializer<Invite> {
            override fun serialize(
                src: Invite?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): Invite {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class SeeInviteLink(
        val value: String
    ) {
        OWNER("owner"),

        OWNER_AND_ADMINS("owner_and_admins"),

        ALL("all");

        class Serializer : JsonSerializer<SeeInviteLink>, JsonDeserializer<SeeInviteLink> {
            override fun serialize(
                src: SeeInviteLink?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): SeeInviteLink {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }
}
