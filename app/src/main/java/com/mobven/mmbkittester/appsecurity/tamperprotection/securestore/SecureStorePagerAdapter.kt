package com.mobven.mmbkittester.appsecurity.tamperprotection.securestore

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class SecureStorePagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> SecureStoreWriteFragment.newInstance()
        1 -> SecureStoreReadFragment.newInstance()
        else -> Fragment()
    }

}