package com.mobven.mmbkittester.securenetwork.oauth.model

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("artists")
    val artists: List<Artist> = listOf(),
    @SerializedName("id")
    val id: String?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("total_tracks")
    val totalTracks: Int?,
    @SerializedName("tracks")
    val tracks: AlbumTracks?
)

data class AlbumError(
    @SerializedName("artists")
    val artists: List<Artist> = listOf(),
    @SerializedName("id")
    val id: String?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("total_tracks")
    val totalTracks: Int?,
    @SerializedName("tracks")
    val tracks: AlbumTracksError?
)

data class AlbumTracks(
    @SerializedName("items")
    val items: List<Track> = listOf()
)

data class AlbumTracksError(
    @SerializedName("items")
    val itemsError: Track?
)