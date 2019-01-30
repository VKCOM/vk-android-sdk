package com.vk.api.sdk.internal

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.vk.api.sdk.VK

/**
 * Fake content provider for sdk auto initialization
 */
class VKInitProvider: ContentProvider() {
    override fun onCreate(): Boolean {
        try {
            VK.initialize(context)
        } catch (e: Exception) {
            Log.e(VKInitProvider::class.java.simpleName, "Failed to initialize the VK SDK", e)
        }
        return false
    }

    override fun insert(uri: Uri?, p1: ContentValues?): Uri? = null

    override fun query(uri: Uri?, p1: Array<out String>?, p2: String?, p3: Array<out String>?, p4: String?): Cursor? = null

    override fun update(uri: Uri?, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int = 0

    override fun delete(uri: Uri?, p1: String?, p2: Array<out String>?): Int = 0

    override fun getType(uri: Uri?): String? = null
}