package com.mobven.mmbkittester.pinlocator

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import com.mobven.mmbkittester.R
import com.mobven.pinlocator.view.Pinnable
import kotlinx.android.synthetic.main.item_pin_detail_yandex.view.*

data class YandexPin(
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
        get() = false
    override val title: String?
        get() = pinTitle
    override val description: String?
        get() = pinDescription
    override val routeActionText: String?
        get() = null

    override fun getView(context: Context): View? {
        val pinDetail = LayoutInflater.from(context).inflate(
            R.layout.item_pin_detail_yandex, null, false)
        pinDetail.txtPinTitle.text = pinTitle
        pinDetail.txtPinDescription.text = pinDescription
        return pinDetail
    }
}