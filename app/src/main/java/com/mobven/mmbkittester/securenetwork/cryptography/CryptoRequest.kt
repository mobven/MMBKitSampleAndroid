package com.mobven.mmbkittester.securenetwork.cryptography

import com.google.gson.annotations.SerializedName

data class CryptoRequest(
    @SerializedName("count")
    val count: Int
)