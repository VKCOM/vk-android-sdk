package com.vk.api.sdk

object VKHost {
    const val DEFAULT_HOST = "vk.com"

    @Volatile
    private var mutableHost = DEFAULT_HOST

    @JvmStatic
    val host: String get() = mutableHost

    fun setHost(newHost: String) {
        mutableHost = newHost
    }

    fun isDefault() = host == DEFAULT_HOST

    fun allHosts(): ArrayList<String> {
        val hosts = arrayListOf(DEFAULT_HOST,"vk.ru")
        if (!hosts.contains(host)) {
            hosts.add(host)
        }
        return hosts
    }
}