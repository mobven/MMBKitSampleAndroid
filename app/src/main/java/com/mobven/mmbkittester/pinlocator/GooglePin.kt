package com.mobven.mmbkittester.pinlocator

import android.graphics.Bitmap
import com.mobven.mmbkittester.R
import com.mobven.pinlocator.model.Pinnable

data class GooglePin(
    val lat: Double,
    val lng: Double,
    val pinTitle: String,
    val pinDescription: String
) : Pinnable {
    override val latitude: Double
        get() = lat
    override val longitude: Double
        get() = lng
    override val iconBitmap: Bitmap?
        get() = null
    override val iconResource: Int?
        get() = R.drawable.pin

    override val showDetailView: Boolean
        get() = true
    override val title: String?
        get() = pinTitle
    override val description: String?
        get() = pinDescription
    override val routeActionText: String?
        get() = "Yol Tarifi Al"
}