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