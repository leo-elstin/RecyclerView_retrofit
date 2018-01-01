package com.azinova.phptesting.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Leo elstin on 12/21/17.
 */

class ApiClient {

    //val BASE_URL = "http://192.168.2.109:8888/android_login_api/source_files/"
    val BASE_URL = "https://translation.googleapis.com/language/translate/"

    var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor { chain ->
                    val request = chain.request().newBuilder()
                            .build()
                    chain.proceed(request)
                }.build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }


}