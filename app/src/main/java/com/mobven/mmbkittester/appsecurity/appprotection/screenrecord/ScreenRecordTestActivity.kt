package com.mobven.mmbkittester.appsecurity.appprotection.screenrecord

import android.os.Bundle
import com.mobven.appsecurity.AppSecurity
import com.mobven.appsecurity.screenshot.SecureActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_screen_record_test.*

class ScreenRecordTestActivity : SecureActivity() {
    override fun getLayoutId(): Int = R.layout.activity_screen_record_test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        txtMessage.text = if (AppSecurity.declineScreenRecording) {
            "Decline Recording enabled, you can try to record a screen video."
        } else {
            "Decline Recording disabled, activity will permit all screen recordings."
        }
    }
}