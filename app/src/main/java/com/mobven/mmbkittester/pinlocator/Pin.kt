package com.mobven.mmbkittester.pinlocator

import android.graphics.Bitmap
import com.mobven.pinlocator.view.Pinnable

data class Pin(
    val lat: Double,
    val lng: Double
) : Pinnable {
    override val title: String?
        get() = null
    override val description: String?
        get() = null
    override val iconBitmap: Bitmap?
        get() = null
    override val iconResource: Int?
        get() = null
    override val latitude: Double
        get() = lat
    override val longitude: Double
        get() = lng
}