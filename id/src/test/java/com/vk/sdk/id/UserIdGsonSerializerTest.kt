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
package com.vk.sdk.id

import com.google.gson.JsonNull
import com.google.gson.JsonPrimitive
import com.vk.dto.common.id.UserId
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class UserIdGsonSerializerTest {

    // ---------------------------------------------------------------------------------------------
    // Deserialize tests:

    @Test
    fun `When json is null - Then deserialize should return null`() {
        val deserialized = gson().deserialize(null, null, null)
        assertNull(deserialized)
    }

    @Test
    fun `When json is JsonNull - Then deserialize should return null`() {
        val deserialized = gson().deserialize(JsonNull.INSTANCE, null, null)
        assertNull(deserialized)
    }

    @Test
    fun `When not shifted - Then deserialize should return UserId with json value`() {
        val deserialized = gson(false).deserialize(JsonPrimitive(Long.MAX_VALUE), null, null)
        assertEquals(UserId(Long.MAX_VALUE), deserialized)
    }

    @Test
    fun `When shifted - Then deserialize should return UserId with decreased by INT_MAX value`() {
        val value = Long.MAX_VALUE
        val deserialized = gson(true).deserialize(JsonPrimitive(value), null, null)
        assertEquals(UserId(value - Int.MAX_VALUE), deserialized)
    }

    @Test
    fun `When shifted and is group - Then deserialize should UserId with increased by INT_MAX value`() {
        val value = -Long.MAX_VALUE
        val deserialized = gson(true).deserialize(JsonPrimitive(value), null, null)
        assertEquals(UserId(value + Int.MAX_VALUE), deserialized)
    }

    @Test(expected = IllegalStateException::class)
    fun `When shifted, is user and value is 0 - Then IllegalStateException should be thrown`() {
        gson(true).deserialize(JsonPrimitive(0), null, null)
    }

    @Test(expected = IllegalStateException::class)
    fun `When shifted, is user and value is less then MAX_INT - Then IllegalStateException should be thrown`() {
        gson(true).deserialize(JsonPrimitive(1), null, null)
    }

    @Test(expected = IllegalStateException::class)
    fun `When shifted, is group and value is greater then -MAX_INT - Then IllegalStateException should be thrown`() {
        gson(true).deserialize(JsonPrimitive(-1), null, null)
    }

    // ---------------------------------------------------------------------------------------------
    // Serialize tests:

    @Test
    fun `When UserId is null - Then serialize should return -1 primitive`() {
        val serialized = gson().serialize(null, null, null)
        assertEquals(JsonPrimitive(-1), serialized)
    }

    @Test
    fun `When not shifted - Then serialize should return primitive with original value`() {
        val value = Long.MAX_VALUE
        val serialized = gson().serialize(UserId(value), null, null)
        assertEquals(JsonPrimitive(value), serialized)
    }

    @Test
    fun `When shifted - Then serialize should return primitive with increased by INT_MAX value`() {
        val value = Int.MAX_VALUE.toLong()
        val serialized = gson(true).serialize(UserId(value), null, null)
        assertEquals(JsonPrimitive(value + Int.MAX_VALUE), serialized)
    }

    @Test
    fun `When shifted and is group - Then serialize should return primitive with decreased by INT_MAX value`() {
        val value = Int.MIN_VALUE.toLong()
        val serialized = gson(true).serialize(UserId(value), null, null)
        assertEquals(JsonPrimitive(value - Int.MAX_VALUE), serialized)
    }

    companion object {
        private fun gson(shift: Boolean = false) = UserId.GsonSerializer(shift)
    }
}