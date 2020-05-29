package com.mobven.mmbkittester.securenetwork

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
        SecureNetwork.apply {
            baseUrl = "https://api.spotify.com/v1/"
            tokenUrl = "https://accounts.spotify.com/api/token/"
            clientId = "45007d1680b9491680b50384349ad198"
            clientSecret = "496354bb3fbb45498bab4180dc7fe1f3"
            isDebug = true
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
        btnExpire.setOnClickListener {
            SecureNetwork.authToken = "ExpiredToken"
            showToast("Expired token")
        }
        btnGetAlbum.setOnClickListener {
            startActivity(AlbumActivity.callingIntent(this, edtAlbumId.text.toString()))
        }
    }

}