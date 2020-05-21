package com.mobven.mmbkittester.securenetwork.model

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("album")
    val album: Album?,
    @SerializedName("artists")
    val artists: List<Artist> = listOf(),
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)