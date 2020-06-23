package com.mobven.mmbkittester.pinlocator

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.pinlocator.model.InfoViewBinder
import com.mobven.pinlocator.model.Pinnable
import kotlinx.android.synthetic.main.activity_yandex_maps.*
import kotlinx.android.synthetic.main.item_pin_detail_yandex.view.*

class YandexMapsActivity : AppCompatActivity() {

    private val pins: List<YandexPin> = listOf(
        YandexPin(-33.8469759,150.3715249, "Sydney", "Not the capital city of Australia"),
        YandexPin(
            41.041726,
            29.0029393,
            "İstanbul",
            "Not the capital city of Turkey"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yandex_maps)
        pinLocatorYandex.onCreate(this, "https://tech.yandex.com/maps/mapkit/doc/3.x/concepts/android/quickstart-docpage/") {
            pinLocatorYandex.setCamera(41.041726,29.0029393, 14f, 5f)
        }
    }

    override fun onStart() {
        super.onStart()
        pinLocatorYandex.onStart()
        pinLocatorYandex.setPins(pins)
        pinLocatorYandex.setCustomInfoViewBinder(object : InfoViewBinder {
            override fun bindInfoView(view: View, pin: Pinnable) {
                view.txtPinTitle.text = pin.title
                view.txtPinDescription.text = pin.description
            }

            override fun onCreateInfoView(context: Context): View =
                LayoutInflater.from(context).inflate(
                    R.layout.item_pin_detail_yandex, null, false
                )

            override fun onInfoWindowClick(pin: Pinnable, context: Context) {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("yandexnavi://build_route_on_map?lat_to=${pin.latitude}&lon_to=${pin.longitude}")
                )
                context.startActivity(intent)
            }
        })
    }

    override fun onStop() {
        pinLocatorYandex.onStop()
        super.onStop()
    }

}