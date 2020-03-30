package com.mobven.mmbkittester.appsecurity.snapshot

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.mobven.appsecurity.AppSecurity
import com.mobven.appsecurity.screenshot.ScreenShotDeclineLevel
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_snapshot_setting.*

class SnapshotSettingActivity : AppCompatActivity() {

    private val levels = listOf(
        ScreenShotDeclineLevel.DECLINE_NOTHING,
        ScreenShotDeclineLevel.DECLINE_ONLY_BACKGROUND,
        ScreenShotDeclineLevel.DECLINE_ALL
    )

    private val guardColors = listOf(
        GuardColor("Red", R.layout.item_guard_red),
        GuardColor("Green", R.layout.item_guard_green),
        GuardColor("Blue", R.layout.item_guard_blue)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snapshot_setting)

        initLevelsSpinner()
        initColorsSpinner()
        btnTest.setOnClickListener {
            startActivity(Intent(this, SnapshotTestActivity::class.java))
        }
    }

    private fun initLevelsSpinner() {
        spinnerDeclineLevel.adapter = ArrayAdapter<ScreenShotDeclineLevel>(
            this,
            android.R.layout.simple_spinner_item,
            levels
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinnerDeclineLevel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val level = levels[position]
                AppSecurity.screenShotDeclineLevel = level
                groupGuardColor.isVisible = level == ScreenShotDeclineLevel.DECLINE_ONLY_BACKGROUND
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun initColorsSpinner() {
        spinnerGuardColor.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            guardColors.map { it.name }
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinnerGuardColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                AppSecurity.screenShotGuardView = guardColors[position].layout
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}

data class GuardColor(val name: String, val layout: Int)