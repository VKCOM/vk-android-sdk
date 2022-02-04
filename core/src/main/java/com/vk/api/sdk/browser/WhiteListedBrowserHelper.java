/*
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
package com.vk.api.sdk.browser;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class WhiteListedBrowserHelper {

    private static final List<VersionedBrowserMatcher> WHITE_LIST = Arrays.asList(
            VersionedBrowserMatcher.CHROME_BROWSER,
            VersionedBrowserMatcher.CHROME_CUSTOM_TAB,
            VersionedBrowserMatcher.FIREFOX_CUSTOM_TAB,
            VersionedBrowserMatcher.FIREFOX_BROWSER,
            VersionedBrowserMatcher.SAMSUNG_BROWSER,
            VersionedBrowserMatcher.SAMSUNG_CUSTOM_TAB);

    @Nullable
    public static BrowserDescriptor selectBestBrowser(Context context) {
        try {
            List<BrowserDescriptor> allBrowsers = BrowserSelector.getAllBrowsers(context);
            for (BrowserDescriptor descriptor : allBrowsers) {
                for (VersionedBrowserMatcher versionedBrowserMatcher : WHITE_LIST) {
                    if (versionedBrowserMatcher.matches(descriptor)) {
                        return descriptor;
                    }
                }
            }
            return allBrowsers.isEmpty() ? null : allBrowsers.get(0);
        } catch (Exception e) {
            Log.e("BrowserSelector", "Exception in select browser", e);
            return null;
        }
    }
}
