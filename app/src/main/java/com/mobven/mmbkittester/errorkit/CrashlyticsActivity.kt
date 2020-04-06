package com.mobven.mmbkittester.errorkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_crashlytics.*
import java.lang.RuntimeException

class CrashlyticsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crashlytics)

        btn_crash.setOnClickListener {
            throw RuntimeException("Test Crash")
        }
    }
}
