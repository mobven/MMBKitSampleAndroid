package com.mobven.mmbkittester.errorkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobven.errorkit.ErrorKit
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_crashlytics.*
import java.io.IOException
import java.lang.RuntimeException

class CrashlyticsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crashlytics)

        ErrorKit.reportCrash {
            Log.i("ERRORKIT", it.message)
        }

        btn_crash.setOnClickListener {
            throw RuntimeException("Test Crash")
        }

        btn_catch.setOnClickListener {
            ErrorKit.getMMBTryCatch {
                dummyReadFile("TEST")
            }
        }

    }

    @Throws(IOException::class)
    fun dummyReadFile(input: String) {
        throw IOException(input)
    }
}
