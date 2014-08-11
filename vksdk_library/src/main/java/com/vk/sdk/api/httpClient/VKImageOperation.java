package com.vk.sdk.api.httpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import com.vk.sdk.api.VKError;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Created by Roman Truba on 11.08.14.
 * Copyright (c) 2013 VK. All rights reserved.
 */
public class VKImageOperation extends VKHttpOperation {

    public float imageDensity;
    /**
     * Create new operation for loading prepared Http request.
     *
     * @param imageUrl URL for image
     */
    public VKImageOperation(String imageUrl) {
        super(new HttpGet(imageUrl));
    }
    /**
     * Set listener for current operation
     * @param listener Listener subclasses VKHTTPOperationCompleteListener
     */
    public void setImageOperationListener(final VKImageOperationListener listener) {
        this.setCompleteListener(new VKOperationCompleteListener() {
            @Override
            public void onComplete() {
                if (VKImageOperation.this.state() != VKOperationState.Finished || mLastException != null) {
                    listener.onError(VKImageOperation.this, generateError(mLastException));
                } else {
                    byte[] response = getResponseData();
                    Bitmap captchaImage = BitmapFactory.decodeByteArray(response, 0, response.length);
                    if (imageDensity > 0) {
                        captchaImage = Bitmap.createScaledBitmap(captchaImage, (int) (captchaImage.getWidth() * imageDensity), (int) (captchaImage.getHeight() * imageDensity), true);
                    }
                    final Bitmap result = captchaImage;
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onComplete(VKImageOperation.this, result);
                        }
                    });
                }
            }
        });
    }
    /**
     * Class representing operation listener for VKHttpOperation
     */
    public static abstract class VKImageOperationListener  extends VKHTTPOperationCompleteListener
    {
        public void onComplete(VKImageOperation operation, Bitmap image) {
        }

        public void onError(VKImageOperation operation, VKError error) {
        }
    }
}
