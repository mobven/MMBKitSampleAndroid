package com.mobven.mmbkittester.statemachine

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("objectId") val objectId : String?,
    @SerializedName("createdAt") val createdAt : String?,
    @SerializedName("updatedAt") val updatedAt : String?,
    @SerializedName("title") val title: String?,
    @SerializedName("fields") val fields: MutableList<Fields>?
)

data class Form (
    @SerializedName("results") val results : MutableList<Results>?
)

data class Fields (
    @SerializedName("id") val id : String?,
    @SerializedName("label") val label : String?,
    @SerializedName("placeholder") val placeholder : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("value") val value : String?,
    @SerializedName("rules") val rules : Rules?,
    @SerializedName("options") val options: MutableList<Option>?
)

data class Rules (
    @SerializedName("regex") val regex : String?,
    @SerializedName("message") val message : String?
)

data class Option (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?
)