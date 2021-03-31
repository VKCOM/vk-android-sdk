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