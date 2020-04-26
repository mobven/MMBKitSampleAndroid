package com.mobven.mmbkittester.appsecurity.tamperprotection.forceupdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobven.appsecurity.AppSecurity
import com.mobven.errorkit.ErrorKit
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_market_check.*

class ForceUpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_force_update)
        btn_check.setOnClickListener {
            //forceUpdateTest()
        }
    }

    private fun forceUpdateTest() {
        AppSecurity.checkForceUpdate({
            Toast.makeText(this, "onContinue", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(this, "onError:${it.message}", Toast.LENGTH_SHORT).show()
        }, dialogContext = this)
    }
}
