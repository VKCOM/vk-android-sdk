package com.vk.api.sdk

object VKHost {
    private const val DEFAULT_HOST = "vk.com"

    @Volatile
    private var mutableHost = DEFAULT_HOST

    @JvmStatic
    val host: String get() = mutableHost

    fun setHost(newHost: String) {
        mutableHost = newHost
    }

    fun isDefault() = host == DEFAULT_HOST

    fun allHosts(): ArrayList<String> {
        val hosts = arrayListOf(host)
        if (host != DEFAULT_HOST) {
            hosts.add(DEFAULT_HOST)
        }

        return hosts
    }
}