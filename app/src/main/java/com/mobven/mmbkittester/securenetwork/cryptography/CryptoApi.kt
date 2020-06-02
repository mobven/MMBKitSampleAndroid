package com.mobven.mmbkittester.securenetwork.cryptography

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CryptoApi {

    @POST("aes/getNumbers.php")
    fun getNumbers(@Body cryptoRequest: CryptoRequest): Call<CryptoResponse>
}