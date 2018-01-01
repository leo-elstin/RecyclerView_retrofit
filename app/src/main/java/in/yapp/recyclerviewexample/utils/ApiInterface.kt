package com.azinova.phptesting.utils

import com.azinova.phptesting.model.transData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Created by Leo elstin on 12/21/17.
 */
interface ApiInterface {

    @POST("login.php")
    fun registerUser(@Body jsonObject: JsonObject): Call<JsonElement>

    @POST("v2?key=AIzaSyB-BgmRqE-fS8t9gUMI6gbEuVXs1873i5o")
    fun transllate(@Body jsonObject: JsonObject): Call<transData>

}