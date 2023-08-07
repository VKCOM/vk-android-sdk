package com.vk.api.sdk

interface SectionAvailabilityListener {
    fun onSectionAvailable(sectionName: String)
    fun onSectionUnavailable(sectionName: String)
}
