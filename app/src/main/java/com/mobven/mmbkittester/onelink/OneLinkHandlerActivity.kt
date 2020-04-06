package com.mobven.mmbkittester.onelink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_onelink_handler.*

class OneLinkHandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onelink_handler)
        intent.extras?.let { bundle ->
            if (bundle.isEmpty) {
                showEmptyMessage()
            } else {
                val paramsBuilder = StringBuilder()
                bundle.keySet()?.forEach {
                    paramsBuilder.append("$it=${bundle.getString(it)}\n")
                }
                txtParams.text = paramsBuilder.toString()
            }
        }
    }

    private fun showEmptyMessage() {
        txtParams.text = "Link does not contain a query parameter"
    }
}