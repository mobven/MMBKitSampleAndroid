package com.mobven.mmbkittester.securenetwork.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSpotifyClient {
    const val API_ENDPOINT = "https://api.spotify.com/v1/"
    const val BEARER_TOKEN = "Bearer BQAipDr-uBAwsClmRxWrUEyzjh7t5wY0y46vjSyfVpwIhEczkkaeaAf_sNeD5GRMp39RbHcaWE-v80zbSnk"

    fun create(): SpotifyApi =
        Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .client(OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val original = chain.request()
                    val requestBuilder = original.newBuilder().apply {
                        addHeader("Authorization",
                            BEARER_TOKEN
                        )
                        method(original.method, original.body)
                    }
                    chain.proceed(requestBuilder.build())
                })
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SpotifyApi::class.java)
}