package com.mobven.mmbkittester.securenetwork.oauth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.mmbkittester.securenetwork.oauth.client.SpotifyApi
import com.mobven.mmbkittester.securenetwork.oauth.model.Album
import com.mobven.mmbkittester.securenetwork.oauth.model.Track
import com.mobven.network.SecureNetwork
import kotlinx.android.synthetic.main.activity_album.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class AlbumActivity : AppCompatActivity() {

    private val spotifyApi: SpotifyApi =
        SecureNetwork.createOAuthAPI(
            "https://api.spotify.com/v1/",
            SpotifyApi::class.java,
            retrofitConfigCallback = {
                it.addConverterFactory(GsonConverterFactory.create())
            })

    private val trackAdapter = KeyValueAdapter()
    private val albumTitleAdapter = KeyValueAdapter()
    private val albumAdapter = AlbumAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        rvTracks.adapter = MergeAdapter(trackAdapter, albumTitleAdapter, albumAdapter)
        intent.getStringExtra(KEY_ALBUM_ID)?.let { id ->
            spotifyApi.getAlbum(id).enqueue(object : Callback<Album> {
                override fun onFailure(call: Call<Album>, t: Throwable) {
                    showToast("Failure:${t.message}")
                }

                override fun onResponse(call: Call<Album>, response: Response<Album>) {
                    response.body()?.let {
                        albumTitleAdapter.pair = "Requested Album" to it.name.orEmpty()
                        albumAdapter.setItems(it.tracks?.items.orEmpty())
                    } ?: showToast("No response")
                }
            })
        }
        intent.getStringExtra(KEY_TRACK_ID)?.let { id ->
            spotifyApi.getTrack(id).enqueue(object : Callback<Track> {
                override fun onFailure(call: Call<Track>, t: Throwable) {
                    showToast("Failure: ${t.message}")
                }

                override fun onResponse(call: Call<Track>, response: Response<Track>) {
                    response.body()?.let {
                        trackAdapter.pair = "Requested Track" to it.name.orEmpty()
                    }
                }
            })
        }
    }

    companion object {
        private const val KEY_ALBUM_ID = "album_id"
        private const val KEY_TRACK_ID = "track_id"
        fun callingIntent(
            context: Context,
            albumId: String? = null,
            trackId: String? = null
        ): Intent =
            Intent(context, AlbumActivity::class.java).apply {
                putExtra(KEY_ALBUM_ID, albumId)
                putExtra(KEY_TRACK_ID, trackId)
            }
    }
}