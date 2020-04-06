package com.mobven.mmbkittester.onelink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.onelink.LinkDirection
import com.mobven.onelink.OneLink
import kotlinx.android.synthetic.main.activity_onelink_info.*

class OneLinkInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onelink_info)
        val scheme = "http"
        val host = "www.abc.com"
        val prefixes = arrayListOf("accounts")
        OneLink.putLinks(LinkDirection(scheme, host, prefixes, OneLinkHandlerActivity::class.java))
        val messageBuilder = StringBuilder("Currently handling;\n")
        prefixes.forEach {
            messageBuilder.append("$scheme://$host/$it*\n")
        }
        messageBuilder.append("See also OneLinkInfoActivity definition in AndroidManifest.xml")
        txtMessage.text = messageBuilder.toString()

        intent.data?.let {
            OneLink.handleLink(it, this)
        }
    }

}