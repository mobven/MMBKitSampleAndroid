package com.mobven.mmbkittester.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R

class MenuActivity : AppCompatActivity() {

    private val menu: ArrayList<MenuItem> = arrayListOf(
        MenuItem(
            "App Security", arrayListOf(
                MenuItem("Prevent Snapshots"),
                MenuItem("Root Detection"),
                MenuItem("Disable Copy/Paste"),
                MenuItem("Prevent Screen Record"),
                MenuItem("PassCode Detection"),
                MenuItem("Secure Store"),
                MenuItem("Force Update"),
                MenuItem("Validate App Integrity"),
                MenuItem("Market Check")
            )
        ),
        MenuItem(
            "Account Security", arrayListOf(
                MenuItem("Login with Biometrics"),
                MenuItem("Timed Cache")
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
