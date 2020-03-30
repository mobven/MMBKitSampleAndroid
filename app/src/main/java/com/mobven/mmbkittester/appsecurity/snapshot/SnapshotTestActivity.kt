package com.mobven.mmbkittester.appsecurity.snapshot

import android.os.Bundle
import com.mobven.appsecurity.AppSecurity
import com.mobven.appsecurity.screenshot.ScreenShotDeclineLevel
import com.mobven.appsecurity.screenshot.SecureActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_snapshot_test.*

class SnapshotTestActivity : SecureActivity() {
    override fun getLayoutId(): Int = R.layout.activity_snapshot_test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        txtMessage.text = when (AppSecurity.screenShotDeclineLevel) {
            ScreenShotDeclineLevel.DECLINE_ALL -> "DECLINE_ALL selected, you can try to take a snapshot anytime."
            ScreenShotDeclineLevel.DECLINE_ONLY_BACKGROUND -> "DECLINE_ONLY_BACKGROUND selected, you need to push home button to see your custom guard layout in app switcher."
            ScreenShotDeclineLevel.DECLINE_NOTHING -> "DECLINE_NOTHING selected, activity will permit all snapshots."
        }
    }
}