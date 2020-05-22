package com.mobven.mmbkittester.securenetwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.mmbkittester.securenetwork.client.SpotifyApi
import com.mobven.mmbkittester.securenetwork.model.Album
import com.mobven.network.SecureNetwork
import kotlinx.android.synthetic.main.activity_authorization.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthorizationActivity: AppCompatActivity() {

    private lateinit var spotifyApi: SpotifyApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        SecureNetwork.apply {
            baseUrl = "https://api.spotify.com/v1/"
            tokenUrl = "https://accounts.spotify.com/api/token/"
            clientId = "45007d1680b9491680b50384349ad198"
            clientSecret = "496354bb3fbb45498bab4180dc7fe1f3"
            isDebug = true
        }
        spotifyApi = SecureNetwork.create(SpotifyApi::class.java)
        btnGetToken.setOnClickListener {
            SecureNetwork.tokenize { isSuccess, throwable ->
                if (isSuccess) {
                    showToast("Got token")
                } else {
                    showToast("error:${throwable?.message}")
                }
            }
        }
        btnGetAlbum.setOnClickListener {
            spotifyApi.getAlbum(edtAlbumId.text.toString()).enqueue(object : Callback<Album> {
                override fun onFailure(call: Call<Album>, t: Throwable) {
                    showToast("Failure:${t.message}")
                }

                override fun onResponse(call: Call<Album>, response: Response<Album>) {
                    showToast(response.body()?.name ?: "No response")
                }
            })
        }
    }

}