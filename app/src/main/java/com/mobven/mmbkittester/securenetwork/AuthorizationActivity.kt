package com.mobven.mmbkittester.securenetwork

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.securenetwork.client.RetrofitSpotifyClient
import com.mobven.mmbkittester.securenetwork.client.SpotifyApi
import com.mobven.mmbkittester.securenetwork.model.Album
import kotlinx.android.synthetic.main.activity_authorization.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthorizationActivity: AppCompatActivity() {

    private lateinit var spotifyApi: SpotifyApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        spotifyApi = RetrofitSpotifyClient.create()
        btnGetAlbum.setOnClickListener {
            spotifyApi.getAlbum(edtAlbumId.text.toString()).enqueue(object : Callback<Album> {
                override fun onFailure(call: Call<Album>, t: Throwable) {
                    Log.d("ServiceResult", "Failure:${t.message}")
                }

                override fun onResponse(call: Call<Album>, response: Response<Album>) {
                    Log.d("ServiceResult", response.body()?.name ?: "No response")
                }
            })
        }
    }

}