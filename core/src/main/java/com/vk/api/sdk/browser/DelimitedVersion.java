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

/**
 * Represents a delimited version number for an application. This can parse common version number
 * formats, treating any sequence of non-numeric characters as a delimiter, and discards these
 * to retain just the numeric content for comparison. Trailing zeroes in a version number
 * are discarded to produce a compact, canonical representation. Empty versions are equivalent to
 * "0". Each numeric part is expected to fit within a 64-bit integer.
 */
public class DelimitedVersion implements Comparable<DelimitedVersion> {

    // See: http://stackoverflow.com/a/2816747
    private static final int PRIME_HASH_FACTOR = 92821;

    private static final long BIT_MASK_32 = 0xFFFFFFFF;

    private final long[] mNumericParts;

    /**
     * Creates a version with the specified parts, ordered from major to minor.
     */
    public DelimitedVersion(long[] numericParts) {
        mNumericParts = numericParts;
    }

    @Override
    public String toString() {
        if (mNumericParts.length == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(mNumericParts[0]);

        int index = 1;
        while (index < mNumericParts.length) {
            builder.append('.');
            builder.append(mNumericParts[index]);
            index++;
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof DelimitedVersion)) {
            return false;
        }

        return this.compareTo((DelimitedVersion) obj) == 0;
    }

    @Override
    public int hashCode() {
        int result = 0;

        for (long numericPart : mNumericParts) {
            result = result * PRIME_HASH_FACTOR + (int) (numericPart & BIT_MASK_32);
        }

        return result;
    }

    @Override
    public int compareTo(@NonNull DelimitedVersion other) {
        int index = 0;

        while (index < this.mNumericParts.length && index < other.mNumericParts.length) {
            int currentPartOrder =
                    compareLongs(this.mNumericParts[index], other.mNumericParts[index]);
            if (currentPartOrder != 0) {
                return currentPartOrder;
            }
            index++;
        }

        return compareLongs(this.mNumericParts.length, other.mNumericParts.length);
    }

    /**
     * Parses a delimited version number from the provided string.
     */
    public static DelimitedVersion parse(String versionString) {

        if (versionString == null) {
            return new DelimitedVersion(new long[0]);
        }

        String[] stringParts = versionString.split("[^0-9]+");

        long[] parsedParts = new long[stringParts.length];
        int index = 0;
        for (String numericPart : stringParts) {
            if (numericPart.isEmpty()) {
                continue;
            }

            parsedParts[index] = Long.parseLong(numericPart);
            index++;
        }

        // discard all trailing zeroes
        index--;
        while (index >= 0) {
            if (parsedParts[index] > 0) {
                break;
            }
            index--;
        }

        int length = index + 1;
        long[] onlyParsedParts = new long[length];
        System.arraycopy(parsedParts, 0, onlyParsedParts, 0, length);
        return new DelimitedVersion(onlyParsedParts);
    }

    private static int compareLongs(long a, long b) {
        return a < b ? -1 : (a > b ? 1 : 0);
    }
}