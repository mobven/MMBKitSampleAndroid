package com.mobven.mmbkittester.pinlocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_google_maps.*

class GoogleMapsActivity : AppCompatActivity() {

    private val pins: List<GooglePin> = listOf(
        GooglePin(-34.0, 151.0, "Sydney", "Diamond of Pacific"),
        GooglePin(
            59.945933,
            30.320045,
            "St. Petersburg",
            "Town of Blyat"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps)
        pinLocatorGoogle.onCreate(this) {
            pinLocatorGoogle.setPins(pins)
            pinLocatorGoogle.setCamera(-34.0, 151.0, 5f)
        }
    }
}