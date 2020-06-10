package com.mobven.mmbkittester.pinlocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_yandex_maps.*

class YandexMapsActivity : AppCompatActivity() {

    private val pins: List<Pin> = listOf(
        Pin(-34.0, 151.0, "Sydney", "Diamond of Pacific"),
        Pin(59.945933, 30.320045, "St. Petersburg","Town of Blyat")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yandex_maps)
        pinLocatorYandex.onCreate(this, "https://mobven.atlassian.net/browse/BKT-202") {
            pinLocatorYandex.setPins(pins)
            pinLocatorYandex.setCamera(59.945933, 30.320045, 5f, 5f)
        }
    }

    override fun onStart() {
        super.onStart()
        pinLocatorYandex.onStart()
    }

    override fun onStop() {
        pinLocatorYandex.onStop()
        super.onStop()
    }

}