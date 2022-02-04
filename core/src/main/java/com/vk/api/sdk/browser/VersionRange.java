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
import androidx.annotation.Nullable;

/**
 * A browser filter which matches when a browser falls into a version range. Versions are
 * expected to match the semantics of {@link DelimitedVersion}.
 */
public class VersionRange {

    /**
     * A version range that matches any delimited version.
     */
    public static final VersionRange ANY_VERSION = new VersionRange(null, null);

    private DelimitedVersion mLowerBound;
    private DelimitedVersion mUpperBound;

    /**
     * Creates a version range that will match any version at or above the specified version,
     * which will be parsed as a {@link DelimitedVersion}.
     */
    public static VersionRange atLeast(String version) {
        return atLeast(DelimitedVersion.parse(version));
    }

    /**
     * Creates a version range that will match any version at or above the specified version.
     */
    public static VersionRange atLeast(DelimitedVersion version) {
        return new VersionRange(version, null);
    }

    /**
     * Creates a version range that will match any version at or below the specified version,
     * which will be parsed as a {@link DelimitedVersion}.
     */
    public static VersionRange atMost(String version) {
        return atMost(DelimitedVersion.parse(version));
    }

    /**
     * Creates a version range that will match any version at or below the specified version.
     */
    public static VersionRange atMost(DelimitedVersion version) {
        return new VersionRange(null, version);
    }

    /**
     * Creates a version range that will match any version equal to or between the specified
     * versions, which will be parsed as {@link DelimitedVersion} instances.
     */
    public static VersionRange between(String lowerBound, String upperBound) {
        return new VersionRange(
                DelimitedVersion.parse(lowerBound),
                DelimitedVersion.parse(upperBound));
    }

    /**
     * Creates a version range with the specified bounds. A null bound is treated as "no bound"
     * on that end.
     */
    public VersionRange(
            @Nullable DelimitedVersion lowerBound,
            @Nullable DelimitedVersion upperBound) {
        mLowerBound = lowerBound;
        mUpperBound = upperBound;
    }

    /**
     * Determines whether the specified version (parsed as an {@link DelimitedVersion} falls within
     * the version range.
     */
    public boolean matches(@NonNull String version) {
        return matches(DelimitedVersion.parse(version));
    }

    /**
     * Determines whether the specified version falls within the version range.
     */
    public boolean matches(@NonNull DelimitedVersion version) {
        if (mLowerBound != null && mLowerBound.compareTo(version) > 0) {
            return false;
        }

        if (mUpperBound != null && mUpperBound.compareTo(version) < 0) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        if (mLowerBound == null) {
            if (mUpperBound == null) {
                return "any version";
            }

            return mUpperBound.toString() + " or lower";
        }

        if (mUpperBound != null) {
            return "between " + mLowerBound + " and " + mUpperBound;
        }

        return mLowerBound.toString() + " or higher";
    }
}