package com.mobven.mmbkittester.pinlocator

import android.graphics.Bitmap
import android.view.View
import com.mobven.pinlocator.view.Pinnable

data class Pin(
    val lat: Double,
    val lng: Double
) : Pinnable {
    override val latitude: Double
        get() = lat
    override val longitude: Double
        get() = lng
    override val iconBitmap: Bitmap?
        get() = null
    override val iconResource: Int?
        get() = null

    override val showDetailView: Boolean
        get() = false
    override val title: String?
        get() = null
    override val description: String?
        get() = null
    override val routeActionText: String?
        get() = null

    override fun getView(): View? = null
}