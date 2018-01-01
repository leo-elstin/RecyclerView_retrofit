package com.azinova.phptesting.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Leo elstin on 12/27/17.
 */
data class UserResponse(
        val status: String
)

data class transData( @SerializedName("data") val  data: translations)

//data class data(@SerializedName("translations") val  translations: translations)

data class translations(@SerializedName("translations") val translated: List<translated>)

data class translated(@SerializedName("translatedText") var translatedText:String,
                      @SerializedName("detectedSourceLanguage") val detectedSourceLanguage :String)