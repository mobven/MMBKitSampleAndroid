package com.mobven.mmbkittester.pinlocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.runtime.image.ImageProvider
import kotlinx.android.synthetic.main.activity_yandex_maps.*

class YandexMapsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MapKitFactory.setApiKey("https://mobven.atlassian.net/browse/BKT-202")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_yandex_maps)
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        map_yandex.onStart()
    }

    override fun onResume() {
        super.onResume()
        map_yandex.map.mapObjects.addPlacemark(Point(59.945933, 30.320045), ImageProvider.fromResource(this, android.R.drawable.ic_menu_mylocation))
        map_yandex.map.move(
            CameraPosition(Point(59.945933, 30.320045), 14f, 0f, 0f),
            Animation(Animation.Type.SMOOTH, 5f),
            null
        )
    }

    override fun onStop() {
        map_yandex.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

}