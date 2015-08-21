//
//  Copyright (c) 2015 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

package com.vk.sdk.payments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.HashSet;


class VKPaymentsDatabase extends SQLiteOpenHelper {
    private static int VERSION = 1;
    public static final String DATABASE_NAME = "vk_sdk_db";

    public static final String TABLE_PURCHASE_INFO = "vk_sdk_table_purchase_info";
    public static final String TABLE_PURCHASE_INFO_PURCHASE = "purchase";
    public static final String TABLE_PURCHASE_INFO_CREATE_SQL = "CREATE TABLE IF NOT EXISTS "
            + TABLE_PURCHASE_INFO + " (" + TABLE_PURCHASE_INFO_PURCHASE + " TEXT);";

    private static VKPaymentsDatabase sInstance;

    // ---------- PURCHASE INFO ----------

    public void insertPurchase(String purchase) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_PURCHASE_INFO_PURCHASE, purchase);
        db.insert(TABLE_PURCHASE_INFO, TABLE_PURCHASE_INFO_PURCHASE, values);
    }

    public void deletePurchase(String purchase) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_PURCHASE_INFO, TABLE_PURCHASE_INFO_PURCHASE + "=?", new String[]{purchase});
    }

    public HashSet<String> getPurchases() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_PURCHASE_INFO, new String[]{TABLE_PURCHASE_INFO_PURCHASE}, null, null, null, null, null);
        HashSet<String> set = new HashSet<>();
        if (cursor.moveToFirst()) {
            do {
                set.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return set;
    }

    // ---------- SQLITE OPEN HELPER PART ----------

    public static VKPaymentsDatabase getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (VKPaymentsDatabase.class) {
                if (sInstance == null) {
                    sInstance = new VKPaymentsDatabase(context);
                }
            }
        }
        return sInstance;
    }

    private VKPaymentsDatabase(@NonNull Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL(TABLE_PURCHASE_INFO_CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
    }
}