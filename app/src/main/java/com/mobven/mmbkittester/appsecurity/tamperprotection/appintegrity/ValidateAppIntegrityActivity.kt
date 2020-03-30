package com.mobven.mmbkittester.appsecurity.tamperprotection.appintegrity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_validate_app_integrity.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.security.SecureRandom

class ValidateAppIntegrityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_app_integrity)
        AppSecurity.cryptographicNonce = createNonce()
        btn_run_success.setOnClickListener {
            AppSecurity.safetyNetApiKey = "AIzaSyCVDpyQHWie0yo3GwtNTdModthj1drCWBE"
            appIntegrityTest(false)
        }

        btn_run_problem.setOnClickListener {
            AppSecurity.safetyNetApiKey = "AIzaSyCVDpyQHWie0yo3GwtNTdModthj1drC"
            appIntegrityTest(false)
        }

        btn_run_fail.setOnClickListener {
            AppSecurity.safetyNetApiKey = "AIzaSyCVDpyQHWie0yo3GwtNTdModthj1drCWBE"
            appIntegrityTest(true)
        }
    }

    private fun appIntegrityTest(isDummyFail: Boolean) {
        AppSecurity.verifyAppIntegrity({
            val appIntegrityModel = OfflineVerify.process(it, isDummyFail)
            log_validate_app_integrity.text = appIntegrityModel.log
            root.setBackgroundColor(ContextCompat.getColor(this, appIntegrityModel.status))
        }, { _, message ->
            log_validate_app_integrity.text = message
            root.setBackgroundColor(ContextCompat.getColor(this, R.color.problem))
        })
    }

    private fun createNonce(): ByteArray? {
        val nonceData = "Safety Net Sample: " + System.currentTimeMillis()
        val byteStream = ByteArrayOutputStream()
        val bytes = ByteArray(32)
        SecureRandom().nextBytes(bytes)
        try {
            byteStream.write(bytes)
            byteStream.write(nonceData.toByteArray())
        } catch (e: IOException) {
            return null
        }

        return byteStream.toByteArray()
    }
}
