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

import android.util.LongSparseArray;

import java.util.Random;

public class VKObject {
    private static final LongSparseArray<VKObject> sRegisteredObjects;
    private long mRegisteredObjectId = 0;
    static {
        sRegisteredObjects = new LongSparseArray<>();
    }

    /**
     * Returns object saved in local cache
     * @param registeredObjectId Registered object id
     * @return Object which was saved with registerObject() method
     */
    public static VKObject getRegisteredObject(long registeredObjectId) {
        return sRegisteredObjects.get(registeredObjectId);
    }

    /**
     * Saves object in local cache for future use. Always call unregisterObject() after use
     * @return Registered object id
     */
    public long registerObject() {
        // sRegisteredObjects contains mRegisteredObjectId
        if (sRegisteredObjects.get(mRegisteredObjectId, null) != null) {
            return mRegisteredObjectId;
        }
        Random rand = new Random();
        while (true) {
            long nextRand = rand.nextLong();
            if (sRegisteredObjects.get(nextRand, null) != null)
                continue;
            if (nextRand == 0)
                continue;
            sRegisteredObjects.put(nextRand, this);
            mRegisteredObjectId = nextRand;
            return nextRand;
        }
    }

    /**
     * Unregister object from local cache.
     */
    public void unregisterObject() {
        sRegisteredObjects.remove(mRegisteredObjectId);
        mRegisteredObjectId = 0;
    }
}