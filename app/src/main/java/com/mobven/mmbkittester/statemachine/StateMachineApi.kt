package com.mobven.mmbkittester.statemachine

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface StateMachineApi {
    @GET("mmkit/classes/Forms")
    fun buildForm(@Header("X-Parse-Application-Id") appId: String = "cGzULzD6IY7PmVPJheOtbZTLtXnupEmA"): Call<Form>
}