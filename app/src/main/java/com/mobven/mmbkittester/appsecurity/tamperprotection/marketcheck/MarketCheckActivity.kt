package com.mobven.mmbkittester.appsecurity.tamperprotection.marketcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_market_check.*

class MarketCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_check)
        btn_check.setOnClickListener {
            AppSecurity.isMyAppInstalledFromMarket().apply {
                if (not()) {
                    text_log.text = "Not installed valid sources!!!"
                }
            }
        }
    }
}
