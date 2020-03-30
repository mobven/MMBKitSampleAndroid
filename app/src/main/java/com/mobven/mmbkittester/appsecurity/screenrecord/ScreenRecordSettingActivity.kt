package com.mobven.mmbkittester.appsecurity.screenrecord

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_screen_record_setting.*

class ScreenRecordSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_record_setting)

        switchRecordSetting.setOnCheckedChangeListener { _, isChecked ->
            AppSecurity.declineScreenRecording = isChecked
        }

        btnTest.setOnClickListener {
            startActivity(Intent(this, ScreenRecordTestActivity::class.java))
        }
    }
}