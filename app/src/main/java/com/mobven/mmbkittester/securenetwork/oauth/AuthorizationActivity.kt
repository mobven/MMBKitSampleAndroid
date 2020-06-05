package com.mobven.mmbkittester.securenetwork.oauth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.network.SecureNetwork
import kotlinx.android.synthetic.main.activity_authorization.*

class AuthorizationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        with(SecureNetwork) {
            isDebug = true
            enableOAuth2(
                "https://accounts.spotify.com/api/token/",
                "45007d1680b9491680b50384349ad198",
                "496354bb3fbb45498bab4180dc7fe1f3"
            )
        }
        btnGetToken.setOnClickListener {
            SecureNetwork.tokenize { isSuccess, throwable ->
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
            startActivity(AlbumActivity.callingIntent(this, edtAlbumId.text.toString()))
        }
    }

}