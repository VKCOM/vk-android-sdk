package com.vk.api.sdk.listeners

class CompositeRequestEventListener : ApiCallListener {

    private val listOfListeners = mutableListOf<ApiCallListener>()

    fun addListener(listener: ApiCallListener){
        listOfListeners.add(listener)
    }

    fun addListeners(listener: Iterable<ApiCallListener>){
        listOfListeners.addAll(listener)
    }

    fun clear(){
        listOfListeners.clear()
    }

    override fun onApiCallStart(reqId: Long, url: String) {
        listOfListeners.forEach { listener ->
            listener.onApiCallStart(reqId = reqId, url = url)
        }
    }

    override fun onApiCallSuccess(reqId: Long) {
        listOfListeners.forEach { listener ->
            listener.onApiCallSuccess(reqId = reqId)
        }
    }

    override fun onApiCallFailed(reqId: Long, throwable: Throwable) {
        listOfListeners.forEach { listener ->
            listener.onApiCallFailed(reqId = reqId, throwable = throwable)
        }
    }
}