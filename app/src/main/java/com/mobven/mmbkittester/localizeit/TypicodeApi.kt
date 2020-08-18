package com.mobven.mmbkittester.localizeit

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TypicodeApi {
    @GET("tags")
    fun getTags(): Call<JsonArray>
}