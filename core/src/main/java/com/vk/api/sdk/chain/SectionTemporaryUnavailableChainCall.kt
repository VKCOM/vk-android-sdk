package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.SectionTemporaryUnavailableException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.utils.TokenExponentialBackoff

internal class SectionTemporaryUnavailableChainCall<T>(
    manager: VKApiManager,
    private val section: String,
    private val backoff: TokenExponentialBackoff,
    private val chainCall: ChainCall<T>
) : ChainCall<T>(manager) {
    private val availabilityListener = manager.config.sectionAvailabilityListener
    private val errorDescription by lazy { "Section temporary unavailable for $section." }

    override fun call(args: ChainArgs): T? {
        if (backoff.shouldWait(section)) {
            throw SectionTemporaryUnavailableException(section, errorDescription)
        }

        try {
            return chainCall.call(args).also {
                backoff.reset(section)
                availabilityListener?.onSectionAvailable(section)
            }
        } catch (ex: VKApiExecutionException) {
            if (ex.isSectionTemporaryUnavailableError) {
                backoff.backoff(section)
                availabilityListener?.onSectionUnavailable(section)
                logDebug(errorDescription, ex)
            }
            throw ex
        }
    }
}