/**
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
package com.vk.api.sdk.utils

interface ApiMethodPriorityBackoff {

    /**
     * indicates that this backoff is active
     */
    fun isActive(): Boolean

    /**
     * @return new id for the client
     */
    fun newId(): Int

    /**
     * checks that the client should wait for the method
     * @param methodName - api method name
     */
    fun shouldWait(methodName: String): Boolean

    /**
     * @param clientId - id from newId method
     * @param methodName - api method name
     * processes method for the client with id could be blocking
     */
    fun processMethod(clientId: Int, methodName: String)

    /**
     * clears priority methods and notifies all waiting clients
     */
    fun clear()

    companion object {
        val DEFAULT = object : ApiMethodPriorityBackoff {

            override fun isActive(): Boolean = false

            override fun newId(): Int = 0

            override fun shouldWait(methodName: String): Boolean = false

            override fun processMethod(clientId: Int, methodName: String) {
                //do nothing
            }

            override fun clear() {
                //do nothing
            }
        }
    }
}