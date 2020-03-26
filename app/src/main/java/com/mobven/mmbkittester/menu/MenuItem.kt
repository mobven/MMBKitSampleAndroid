package com.mobven.mmbkittester.menu

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuItem(
    val name: String,
    val subItems: ArrayList<MenuItem> = arrayListOf(),
    val redirectClass: Class<*>? = null
) : Parcelable