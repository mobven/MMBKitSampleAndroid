package com.mobven.mmbkittester.securenetwork.client

import com.mobven.mmbkittester.securenetwork.model.Album
import com.mobven.mmbkittester.securenetwork.model.Track
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpotifyApi {

    @GET("albums/{id}")
    fun getAlbum(@Path("id") albumId: String): Call<Album>

    @GET("tracks/{id}")
    fun getTrack(@Path("id") trackId: String): Call<Track>


}