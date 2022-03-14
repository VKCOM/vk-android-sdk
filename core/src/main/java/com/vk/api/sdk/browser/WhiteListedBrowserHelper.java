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