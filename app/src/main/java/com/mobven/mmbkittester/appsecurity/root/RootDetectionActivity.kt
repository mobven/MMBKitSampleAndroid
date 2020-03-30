package com.mobven.mmbkittester.appsecurity.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_root_detection.*

class RootDetectionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root_detection)
        switchTerminate.setOnCheckedChangeListener { _, isChecked ->
            AppSecurity.terminateAppForRootedDevices = isChecked
        }
        btnTest.setOnClickListener {
            val isRooted = AppSecurity.isRooted()
            txtMessage.text = "isRooted:$isRooted"
        }
    }

}