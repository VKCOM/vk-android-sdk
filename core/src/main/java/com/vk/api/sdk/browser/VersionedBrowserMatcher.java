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

/*
 * Copyright 2016 The AppAuth for Android Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vk.api.sdk.browser;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.Set;

/**
 * Matches a browser based on its package name, set of signatures, version and whether it is
 * being used as a custom tab. This can be used as part of a browser whitelist or blacklist.
 */
public class VersionedBrowserMatcher implements BrowserMatcher {

    /**
     * Matches any version of Chrome for use as a custom tab.
     */
    public static final VersionedBrowserMatcher CHROME_CUSTOM_TAB = new VersionedBrowserMatcher(
            Browsers.Chrome.PACKAGE_NAME,
            Browsers.Chrome.SIGNATURE_SET,
            true,
            VersionRange.atLeast(Browsers.Chrome.MINIMUM_VERSION_FOR_CUSTOM_TAB));

    /**
     * Matches any version of Google Chrome for use as a standalone browser.
     */
    public static final VersionedBrowserMatcher CHROME_BROWSER = new VersionedBrowserMatcher(
            Browsers.Chrome.PACKAGE_NAME,
            Browsers.Chrome.SIGNATURE_SET,
            false,
            VersionRange.ANY_VERSION);

    /**
     * Matches any version of Firefox for use as a custom tab.
     */
    public static final VersionedBrowserMatcher FIREFOX_CUSTOM_TAB = new VersionedBrowserMatcher(
            Browsers.Firefox.PACKAGE_NAME,
            Browsers.Firefox.SIGNATURE_SET,
            true,
            VersionRange.atLeast(Browsers.Firefox.MINIMUM_VERSION_FOR_CUSTOM_TAB));

    /**
     * Matches any version of Mozilla Firefox.
     */
    public static final VersionedBrowserMatcher FIREFOX_BROWSER = new VersionedBrowserMatcher(
            Browsers.Firefox.PACKAGE_NAME,
            Browsers.Firefox.SIGNATURE_SET,
            false,
            VersionRange.ANY_VERSION);

    /**
     * Matches any version of SBrowser for use as a standalone browser.
     */
    public static final VersionedBrowserMatcher SAMSUNG_BROWSER = new VersionedBrowserMatcher(
            Browsers.SBrowser.PACKAGE_NAME,
            Browsers.SBrowser.SIGNATURE_SET,
            false,
            VersionRange.ANY_VERSION);

    /**
     * Matches any browser.
     */
    public static final BrowserMatcher ANY_BROWSER = new BrowserMatcher() {
        @Override
        public boolean matches(@NonNull BrowserDescriptor descriptor) {
            return true;
        }
    };

    /**
     * Matches any version of SBrowser for use as a custom tab.
     */
    public static final VersionedBrowserMatcher SAMSUNG_CUSTOM_TAB = new VersionedBrowserMatcher(
            Browsers.SBrowser.PACKAGE_NAME,
            Browsers.SBrowser.SIGNATURE_SET,
            true,
            VersionRange.atLeast(Browsers.SBrowser.MINIMUM_VERSION_FOR_CUSTOM_TAB));

    private String mPackageName;
    private Set<String> mSignatureHashes;
    private VersionRange mVersionRange;
    private boolean mUsingCustomTab;

    /**
     * Creates a browser matcher that requires an exact match on package name, single signature
     * hash, custom tab usage mode, and a version range.
     */
    public VersionedBrowserMatcher(
            @NonNull String packageName,
            @NonNull String signatureHash,
            boolean usingCustomTab,
            @NonNull VersionRange versionRange) {
        this(packageName,
                Collections.singleton(signatureHash),
                usingCustomTab,
                versionRange);
    }

    /**
     * Creates a browser matcher that requires an exact match on package name, set of signature
     * hashes, custom tab usage mode, and a version range.
     */
    public VersionedBrowserMatcher(
            @NonNull String packageName,
            @NonNull Set<String> signatureHashes,
            boolean usingCustomTab,
            @NonNull VersionRange versionRange) {
        mPackageName = packageName;
        mSignatureHashes = signatureHashes;
        mUsingCustomTab = usingCustomTab;
        mVersionRange = versionRange;
    }

    @Override
    public boolean matches(@NonNull BrowserDescriptor descriptor) {
        return mPackageName.equals(descriptor.packageName)
                && mUsingCustomTab == descriptor.useCustomTab
                && mVersionRange.matches(descriptor.version)
                && mSignatureHashes.equals(descriptor.signatureHashes);
    }
}