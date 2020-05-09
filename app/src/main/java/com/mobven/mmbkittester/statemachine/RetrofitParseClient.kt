package com.mobven.mmbkittester.statemachine

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitParseClient {
    private const val API_ENDPOINT = "https://capture.mobven.com:4043/"

    fun create(): StateMachineApi =
        Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(StateMachineApi::class.java)
}