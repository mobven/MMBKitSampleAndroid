package com.mobven.mmbkittester.securenetwork.oauth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.network.SecureNetwork
import com.mobven.network.provider.ClientCredentialsProvider
import kotlinx.android.synthetic.main.activity_authorization.*

class AuthorizationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        with(SecureNetwork) {
            enableOAuth2(
                "https://accounts.spotify.com/api/token/",
                autoRefreshAccessToken = true
            )
        }

        btnGetToken.setOnClickListener {
            SecureNetwork.tokenize(
                ClientCredentialsProvider(
                    "45007d1680b9491680b50384349ad198",
                    "496354bb3fbb45498bab4180dc7fe1f3"
                )
            ) { isSuccess, throwable ->
                if (isSuccess) {
                    showToast("Got token")
                } else {
                    showToast("error:${throwable?.message}")
                }
            }
        }
        /*btnExpire.setOnClickListener {
            SecureNetwork.authToken = "ExpiredToken"
            showToast("Expired token")
        }*/
        btnGetAlbum.setOnClickListener {
            startActivity(AlbumActivity.callingIntent(this, albumId = edtAlbumId.text.toString()))
        }

        btnGetAlbumWithError.setOnClickListener {
            startActivity(
                AlbumActivity.callingIntent(
                    this,
                    albumIdError = edtAlbumId.text.toString()
                )
            )
        }

        btnGetTrack.setOnClickListener {
            startActivity(AlbumActivity.callingIntent(this, trackId = edtTrackId.text.toString()))
        }
        btnGetAlbumAndTrack.setOnClickListener {
            startActivity(
                AlbumActivity.callingIntent(
                    this,
                    edtAlbumId.text.toString(),
                    edtTrackId.text.toString()
                )
            )
        }
    }

}