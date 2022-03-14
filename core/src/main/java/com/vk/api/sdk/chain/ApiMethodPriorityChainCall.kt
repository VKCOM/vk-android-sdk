package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKMethodCall
import com.vk.api.sdk.utils.ApiMethodPriorityBackoff

/**
 * Method priority ChainCall
 *
 * it processes method with [ApiMethodPriorityBackoff] until we have to wait for other priority
 * methods will be called
 *
 * proceeds calls according to the [ApiMethodPriorityBackoff] implementation
 */
class ApiMethodPriorityChainCall<T>(
    manager: VKApiManager,
    private val chain: ChainCall<T>,
    private val call: VKMethodCall,
    private val priorityBackoff: ApiMethodPriorityBackoff
) : ChainCall<T>(manager) {

    private val chainId by lazy {
        priorityBackoff.newId()
    }

    override fun call(args: ChainArgs): T? {
        if (!priorityBackoff.isActive()) {
            return chain.call(args)
        }

        val method = call.method

        while (priorityBackoff.shouldWait(method)) {
            if (Thread.interrupted()) {
                throw InterruptedException("request interrupted")
            }
            priorityBackoff.processMethod(chainId, method)
        }
        return chain.call(args)
    }
}