package com.mobven.mmbkittester.appsecurity.appprotection.passcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_passcode_detection.*

class PassCodeDetectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passcode_detection)

        btnTest.setOnClickListener {
            val passCodeEnabled = AppSecurity.hasDeviceOwnerAuthentication()
            txtMessage.text = if (passCodeEnabled) {
                "Device's passcode enabled"
            } else {
                "Device's passcode disabled"
            }
        }
    }
}