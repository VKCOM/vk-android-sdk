//
//  Copyright (c) 2014 VK.com
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

package com.vk.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;

/**
 * Class for VK authorization and dialogs helping
 */
public class VKUIHelper {
    private static Context sApplicationContext;

    /**
     * A forced setting of an application context for the SDK.
     * That method must be call in services of broadcast events for prepare the SDK for a work.
     *
     * @param appContext Context of application
     */
    static void setApplicationContext(Context appContext) {
        if (appContext != null) {
            sApplicationContext = appContext;
        }
    }

    @Nullable
    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    /**
     * Creates a bitmap with rounded corners
     *
     * @param bitmap    source bitmap
     * @param maxHeight maximal height for result bitmap
     * @param pixels    corner radius
     * @return a new bitmap if succeed, nil instead
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int maxHeight, int pixels) {
        if (bitmap == null || sApplicationContext == null) {
            return bitmap;
        }
        maxHeight = (int) (sApplicationContext.getResources().getDisplayMetrics().density * maxHeight);
        float scale = bitmap.getHeight() * 1.0f / maxHeight;
        int newWidth = (int) (bitmap.getWidth() / scale);

        Bitmap output = Bitmap.createBitmap(newWidth, maxHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xffffffff;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final Rect dstRect = new Rect(0, 0, newWidth, maxHeight);
        final RectF rectF = new RectF(dstRect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, (float) pixels, (float) pixels, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, dstRect, paint);

        return output;
    }


}
