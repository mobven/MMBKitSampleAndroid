package com.mobven.mmbkittester.securenetwork.oauth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.mmbkittester.securenetwork.oauth.client.SpotifyApi
import com.mobven.mmbkittester.securenetwork.oauth.model.Album
import com.mobven.network.SecureNetwork
import kotlinx.android.synthetic.main.activity_album.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class AlbumActivity : AppCompatActivity() {

    private val spotifyApi: SpotifyApi =
        SecureNetwork.create(SpotifyApi::class.java, retrofitConfigCallback = {
            it.addConverterFactory(GsonConverterFactory.create())
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        intent.getStringExtra(KEY_ALBUM_ID)?.let { id ->
            spotifyApi.getAlbum(id).enqueue(object : Callback<Album> {
                override fun onFailure(call: Call<Album>, t: Throwable) {
                    showToast("Failure:${t.message}")
                }

                override fun onResponse(call: Call<Album>, response: Response<Album>) {
                    response.body()?.let {
                        textTitle.text = "${it.name} - ${it.artists.firstOrNull()?.name.orEmpty()}"
                        rvTracks.adapter =
                            TrackAdapter(
                                it.tracks?.items.orEmpty()
                            )
                    } ?: showToast("No response")
                }
            })
        }
    }

    companion object {
        private const val KEY_ALBUM_ID = "album_id"
        fun callingIntent(context: Context, albumId: String): Intent =
            Intent(context, AlbumActivity::class.java).apply {
                putExtra(KEY_ALBUM_ID, albumId)
            }
    }
}