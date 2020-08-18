package com.mobven.mmbkittester.localizeit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitTypicodeClient {
    private const val API_ENDPOINT = "http://my-json-server.typicode.com/ErelMobven/typicode/"

    fun create(): TypicodeApi =
        Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(TypicodeApi::class.java)
}