package com.mobven.mmbkittester.pinlocator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.pinlocator.model.InfoViewBinder
import com.mobven.pinlocator.model.Pinnable
import kotlinx.android.synthetic.main.activity_google_maps.*
import kotlinx.android.synthetic.main.item_pin_detail_google.view.*

class GoogleMapsActivity : AppCompatActivity() {

    private val pins: List<GooglePin> = listOf(
        GooglePin(-33.8469759,150.3715249, "Sydney", "Not the capital city of Australia"),
        GooglePin(
            41.0039643,
            28.4517462,
            "İstanbul",
            "Not the capital city of Turkey"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps)
        pinLocatorGoogle.onCreate(this) {
            pinLocatorGoogle.setPins(pins)
            pinLocatorGoogle.setCustomInfoViewBinder(object : InfoViewBinder {
                override fun bindInfoView(view: View, pin: Pinnable) {
                    view.txtPinTitle.text = pin.title
                    view.txtPinDescription.text = pin.description
                }

                override fun onCreateInfoView(context: Context): View =
                    LayoutInflater.from(context).inflate(
                        R.layout.item_pin_detail_google, null, false
                    )

                override fun onInfoWindowClick(pin: Pinnable, context: Context) {
                    pinLocatorGoogle.launchNavigationToPin(pin)
                }
            })
            pinLocatorGoogle.setCamera(40.993900, 27.840890, 5f)
        }
    }
}