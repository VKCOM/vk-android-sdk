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

package com.vk.sdk;

import android.support.annotation.Nullable;

/**
 * Use this class for track access token changes.
 * <p/>
 * See example usage:
 * <pre>
 * <code>VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
 *  &#064;Override
 *   public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
 *       if (newToken == null) {
 *           Toast.makeText(Application.this, "AccessToken invalidated", Toast.LENGTH_LONG).show();
 *       }
 *   }
 * };
 * </code>
 * </pre>
 */
public abstract class VKAccessTokenTracker {

    private boolean isTracking = false;

    /**
     * This method will be call only from main thread
     *
     * @param oldToken Token before changes
     * @param newToken Actual token after changes
     */
    public abstract void onVKAccessTokenChanged(@Nullable VKAccessToken oldToken, @Nullable VKAccessToken newToken);

    public boolean isTracking() {
        return isTracking;
    }

    public void startTracking() {
        VKSdk.addVKTokenTracker(this);
        isTracking = true;
    }

    public void stopTracking() {
        VKSdk.removeVKTokenTracker(this);
        isTracking = false;
    }
}