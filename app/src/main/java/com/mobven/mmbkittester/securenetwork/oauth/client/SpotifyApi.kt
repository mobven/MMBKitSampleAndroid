package com.mobven.mmbkittester.securenetwork.oauth.client

import com.mobven.mmbkittester.securenetwork.oauth.model.Album
import com.mobven.mmbkittester.securenetwork.oauth.model.Track
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpotifyApi {

    @GET("albums/{id}")
    fun getAlbum(@Path("id") albumId: String): Call<Album>

    @GET("tracks/{id}")
    fun getTrack(@Path("id") trackId: String): Call<Track>


}