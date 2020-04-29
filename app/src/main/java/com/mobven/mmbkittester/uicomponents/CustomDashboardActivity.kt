package com.mobven.mmbkittester.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.uicomponents.dashboard.Dashboard
import kotlinx.android.synthetic.main.activity_custom_dashboard.*

class CustomDashboardActivity: AppCompatActivity() {

    private var isList: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_dashboard)

        dashboard.buildDashboard(CustomDashboardAdapter())

        button.setOnClickListener {
            if (isList) {
                dashboard.setLayoutType(Dashboard.GRID)
                button.text = "LIST"
                isList = false
            } else {
                dashboard.setLayoutType(Dashboard.LIST)
                button.text = "GRID"
                isList = true
            }

        }
    }
}