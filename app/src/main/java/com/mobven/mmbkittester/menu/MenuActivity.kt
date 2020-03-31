package com.mobven.mmbkittester.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.appsecurity.appprotection.passcode.PassCodeDetectionActivity
import com.mobven.mmbkittester.appsecurity.appprotection.root.RootDetectionActivity
import com.mobven.mmbkittester.appsecurity.appprotection.screenrecord.ScreenRecordSettingActivity
import com.mobven.mmbkittester.appsecurity.appprotection.securetext.SecureTextActivity
import com.mobven.mmbkittester.appsecurity.appprotection.snapshot.SnapshotSettingActivity
import com.mobven.mmbkittester.appsecurity.tamperprotection.appintegrity.ValidateAppIntegrityActivity
import com.mobven.mmbkittester.appsecurity.tamperprotection.forceupdate.ForceUpdateActivity
import com.mobven.mmbkittester.accountsecurity.loginbiometrics.LoginBiometricsActivity
import com.mobven.mmbkittester.accountsecurity.timedcache.TimedCacheActivity
import com.mobven.mmbkittester.appsecurity.tamperprotection.marketcheck.MarketCheckActivity
import com.mobven.mmbkittester.appsecurity.tamperprotection.securestore.SecureStoreActivity

class MenuActivity : AppCompatActivity() {

    private val menu: ArrayList<MenuItem> = arrayListOf(
        MenuItem(
            "App Security", arrayListOf(
                MenuItem("Prevent Snapshots", redirectClass = SnapshotSettingActivity::class.java),
                MenuItem("Root Detection", redirectClass = RootDetectionActivity::class.java),
                MenuItem("Disable Copy/Paste", redirectClass = SecureTextActivity::class.java),
                MenuItem("Prevent Screen Record", redirectClass = ScreenRecordSettingActivity::class.java),
                MenuItem("PassCode Detection", redirectClass = PassCodeDetectionActivity::class.java),
                MenuItem("Secure Store", redirectClass = SecureStoreActivity::class.java),
                MenuItem("Force Update", redirectClass = ForceUpdateActivity::class.java),
                MenuItem("Validate App Integrity", redirectClass = ValidateAppIntegrityActivity::class.java),
                MenuItem("Market Check", redirectClass = MarketCheckActivity::class.java)
            )
        ),
        MenuItem(
            "Account Security", arrayListOf(
                MenuItem("Login with Biometrics", redirectClass = LoginBiometricsActivity::class.java),
                MenuItem("Timed Cache", redirectClass = TimedCacheActivity::class.java)
            )
        ),
        MenuItem("Secure Network"),
        MenuItem("UI Components"),
        MenuItem("State Machine Forms"),
        MenuItem("Permission Manager"),
        MenuItem("Pin Locator"),
        MenuItem("One Link"),
        MenuItem("Error Kit"),
        MenuItem("Audio2Pay"),
        MenuItem("NFC Payment")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                R.id.frameContainer, MenuFragment.newInstance(menu)
            ).commit()
        }
    }
}
