package com.mobven.mmbkittester.accountsecurity.timedcache

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class TimedCachePagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> TimedCacheWriteFragment.newInstance()
        1 -> TimedCacheReadFragment.newInstance()
        else -> Fragment()
    }

}