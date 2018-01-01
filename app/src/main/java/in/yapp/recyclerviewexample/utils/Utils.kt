package com.azinova.phptesting.utils


/**
 * Created by Leo elstin on 12/21/17.
 */

fun getApiService(): ApiInterface {

    return ApiClient().getClient()!!.create(ApiInterface::class.java)
}

var BROADCAST_DETECTED_ACTIVITY = "activity_intent"