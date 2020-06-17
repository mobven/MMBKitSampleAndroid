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
import com.mobven.mmbkittester.errorkit.CrashlyticsActivity
import com.mobven.mmbkittester.onelink.OneLinkHandlerActivity
import com.mobven.mmbkittester.pinlocator.GoogleMapsActivity
import com.mobven.mmbkittester.pinlocator.YandexMapsActivity
import com.mobven.mmbkittester.securenetwork.cryptography.CryptographyActivity
import com.mobven.mmbkittester.securenetwork.oauth.AuthorizationActivity
import com.mobven.mmbkittester.statemachine.StateMachineActivity
import com.mobven.mmbkittester.uicomponents.*
import com.newrelic.agent.android.NewRelic

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
        MenuItem("Secure Network", arrayListOf(
            MenuItem("OAuth", redirectClass = AuthorizationActivity::class.java),
            MenuItem("Cryptography", redirectClass = CryptographyActivity::class.java)
        )),
        MenuItem("UI Components", arrayListOf(
            MenuItem("Key-Value Label", redirectClass = KeyValueLabelActivity::class.java),
            MenuItem("Key-Value List", redirectClass = KeyValueListActivity::class.java),
            MenuItem("Toolbar Activity", redirectClass = ToolbarActivity::class.java),
            MenuItem("Custom Popups", redirectClass = CustomPopupsActivity::class.java),
            MenuItem("Amount Input View", redirectClass = AmountInputActivity::class.java),
            //MenuItem("Custom Dashboard", redirectClass = CustomDashboardActivity::class.java),
            MenuItem("Add-on Features", redirectClass = AddOnsActivity::class.java)
        )),
        MenuItem("State Machine Forms", redirectClass = StateMachineActivity::class.java),
        MenuItem("Permission Manager"),
        MenuItem("Pin Locator", arrayListOf(
            MenuItem("Google Maps", redirectClass = GoogleMapsActivity::class.java),
            MenuItem("Yandex Maps", redirectClass = YandexMapsActivity::class.java)
        )),
        MenuItem("One Link", redirectClass = OneLinkHandlerActivity::class.java),
        MenuItem("Error Kit", redirectClass = CrashlyticsActivity::class.java),
        MenuItem("Audio2Pay"),
        MenuItem("NFC Payment")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        NewRelic.withApplicationToken(
            "eu01xx8722a9e05128b8db50b8ec5ca76de62a51c4-NRMA"
        ).start(this.application);

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                R.id.frameContainer, MenuFragment.newInstance(menu)
            ).commit()
        }
    }
}
