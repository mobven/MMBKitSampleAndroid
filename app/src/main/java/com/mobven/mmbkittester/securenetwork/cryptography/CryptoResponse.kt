package com.mobven.mmbkittester.securenetwork.cryptography

import com.google.gson.annotations.SerializedName

data class CryptoResponse (
    @SerializedName("numbers")
    val numbers: List<Int> = listOf()
)