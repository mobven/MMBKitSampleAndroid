package com.mobven.mmbkittester.onelink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.mmbkittester.R
import com.mobven.onelink.OneLink
import com.mobven.onelink.model.LinkDirection
import com.mobven.onelink.model.OneLinkableState
import kotlinx.android.synthetic.main.activity_onelink_handler.*

class OneLinkHandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onelink_handler)
        createLinks()
        handleLinks()
        AccountSecurity.timedCacheExpireLiveData.observe(this, Observer {
            if (it.first == USER_KEY) {
                txtLoginState.text = "Session expired"
            }
        })
        btnLogin.setOnClickListener {
            AccountSecurity.putTimedCache(USER_KEY, UserState(true), TEN_MIN_IN_MILLIS)
            txtLoginState.text = "Now logined"
            OneLink.presentPendingRedirections(this)
        }
    }

    private fun createLinks() {
        val scheme = "http"
        val host = "www.abc.com"
        val prefixes = arrayListOf("announcements", "sensitive")
        OneLink.putLinks(
            LinkDirection(
                scheme,
                host,
                arrayListOf(prefixes[0]),
                OneLinkAnnouncementsActivity::class.java
            ),
            LinkDirection(
                scheme,
                host,
                arrayListOf(prefixes[1]),
                OneLinkSensitiveActivity::class.java
            )
        )
        val messageBuilder = StringBuilder("Currently handling;\n")
        prefixes.forEach {
            messageBuilder.append("$scheme://$host/$it*\n")
        }
        messageBuilder.append("See also OneLinkInfoActivity definition in AndroidManifest.xml")
        txtMessage.text = messageBuilder.toString()
    }

    private fun handleLinks() {
        intent.data?.let {
            if (it.pathSegments.contains("announcements")) {
                OneLink.handleLink(it, this)
            } else {
                val isLogined = AccountSecurity.getTimedCache<UserState>(USER_KEY)?.isLogined
                if (isLogined == true) {
                    OneLink.handleLink(it, this)
                } else {
                    OneLink.handleLink(it, this, OneLinkableState.WAITING_FOR_APPROVAL)
                }
            }
        }
    }

    companion object {
        private const val USER_KEY = "user_state"
        private const val TEN_MIN_IN_MILLIS = 10 * 60 * 1000L
    }

    data class UserState(val isLogined: Boolean)

}