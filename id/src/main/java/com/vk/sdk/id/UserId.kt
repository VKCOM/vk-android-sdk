/**
 * Copyright (c) 2020 - present, LLC “V Kontakte”
 *
 * 1. Permission is hereby granted to any person obtaining a copy of this Software to
 * use the Software without charge.
 *
 * 2. Restrictions
 * You may not modify, merge, publish, distribute, sublicense, and/or sell copies,
 * create derivative works based upon the Software or any part thereof.
 *
 * 3. Termination
 * This License is effective until terminated. LLC “V Kontakte” may terminate this
 * License at any time without any negative consequences to our rights.
 * You may terminate this License at any time by deleting the Software and all copies
 * thereof. Upon termination of this license for any reason, you shall continue to be
 * bound by the provisions of Section 2 above.
 * Termination will be without prejudice to any rights LLC “V Kontakte” may have as
 * a result of this agreement.
 *
 * 4. Disclaimer of warranty and liability
 * THE SOFTWARE IS MADE AVAILABLE ON THE “AS IS” BASIS. LLC “V KONTAKTE” DISCLAIMS
 * ALL WARRANTIES THAT THE SOFTWARE MAY BE SUITABLE OR UNSUITABLE FOR ANY SPECIFIC
 * PURPOSES OF USE. LLC “V KONTAKTE” CAN NOT GUARANTEE AND DOES NOT PROMISE ANY
 * SPECIFIC RESULTS OF USE OF THE SOFTWARE.
 * UNDER NO CIRCUMSTANCES LLC “V KONTAKTE” BEAR LIABILITY TO THE LICENSEE OR ANY
 * THIRD PARTIES FOR ANY DAMAGE IN CONNECTION WITH USE OF THE SOFTWARE.
*/
package com.vk.dto.common.id

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.*
import java.lang.reflect.Type
import kotlin.math.absoluteValue

/**
 * wrapper class to support Long user id
 *
 * !!!IMPORTANT!!!
 * if you are gonna to change this class, please, don't forget to republish SDK
 * !!!IMPORTANT!!!
 */
data class UserId(val value: Long): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readLong()
    )

    override fun toString(): String {
        return value.toString()
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(value)
    }

    class GsonSerializer(
        private val shiftByMaxInt: Boolean = false
    ) : JsonSerializer<UserId?>, JsonDeserializer<UserId?> {
        override fun serialize(
            src: UserId?,
            typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            val value = when {
                src == null -> -1
                !shiftByMaxInt -> src.value
                else -> if (src.value < 0) { // is group
                    src.value - Int.MAX_VALUE
                } else { // is user
                    src.value + Int.MAX_VALUE
                }
            }
            return JsonPrimitive(value)
        }

        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): UserId? {
           return if (json != null && !json.isJsonNull) {
               val long = json.asLong
               if (!shiftByMaxInt) return UserId(long)

               val isGroup = long < 0
               val absLong = long.absoluteValue
               // Если не нужно сдвигать на максимальный инт, то возвращаем как есть
               if (absLong < Int.MAX_VALUE) throw IllegalStateException("abs of owner id should be >= MAX_INT")
               val shifted = absLong - Int.MAX_VALUE
               return UserId(if (isGroup) -shifted else shifted)
            } else {
                null
            }
        }
    }

    companion object {

        @JvmField
        val DEFAULT = UserId(0)

        @JvmField
        val CREATOR = object : Parcelable.Creator<UserId> {
            override fun createFromParcel(source: Parcel): UserId = UserId(source)
            override fun newArray(size: Int): Array<UserId?> = arrayOfNulls(size)
        }

        @Deprecated(message = "don't use it in new code",
            replaceWith = ReplaceWith("UserId()", "com.vk.dto.common.id.UserId")
        )
        @JvmStatic
        fun fromLegacyValue(value: Int): UserId {
            legacyObserver.invoke()
            return UserId(value.toLong())
        }

        @Deprecated(message = "don't use it in new code",
            replaceWith = ReplaceWith("UserId()", "com.vk.dto.common.id.UserId")
        )
        @JvmStatic
        fun fromLegacyValues(value: Collection<Int>): List<UserId> {
            legacyObserver.invoke()
            return value.map { fromLegacyValue(it) }
        }

        @Synchronized
        @Deprecated("Only for debug usage")
        fun setLegacyGlobalObserver(observer: () -> Unit) {
            legacyObserver = observer
        }

        @Synchronized
        @Deprecated("Only for debug usage")
        fun removeLegacyGlobalObserver() {
            legacyObserver = {}
        }
    }
}

fun UserId.isReal() = value != 0L

fun UserId.abs() = copy(value = value.absoluteValue)

fun UserId.negative() = copy(value = -value)

operator fun UserId.unaryMinus() = negative()

fun UserId.isGroupId() = value < 0

fun UserId.isUserId() = value > 0

fun Long.toUserId(): UserId = UserId(this)

@Volatile
@Deprecated("Only for debug usage")
private var legacyObserver: () -> Unit = {}

@Deprecated(message = "don't use it in new code",
    replaceWith = ReplaceWith("UserId()", "com.vk.dto.common.id.UserId")
)
fun UserId.legacyValue(): Int {
    legacyObserver.invoke()
    return value.toInt()
}

@Deprecated(message = "don't use it in new code",
    replaceWith = ReplaceWith("UserId()", "com.vk.dto.common.id.UserId")
)
fun List<UserId>.mapLegacyValues(): List<Int> {
    legacyObserver.invoke()
    return map { it.legacyValue() }
}

@Deprecated(message = "don't use it in new code",
    replaceWith = ReplaceWith("toUserId()", "com.vk.dto.common.id")
)
fun Int.toLegacyUserId(): UserId {
    legacyObserver.invoke()
    return UserId(toLong())
}
