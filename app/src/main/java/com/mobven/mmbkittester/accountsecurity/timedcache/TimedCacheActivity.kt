package com.mobven.mmbkittester.accountsecurity.timedcache

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import kotlinx.android.synthetic.main.activity_timed_cache.*

class TimedCacheActivity: AppCompatActivity() {

    private val tabTitles = listOf("WRITE", "READ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timed_cache)

        AccountSecurity.timedCacheExpireLiveData.observe(this, Observer { timedCache ->
            showToast("Cache expired, ${timedCache.first}:${timedCache.second}")
        })

        pager.adapter = TimedCachePagerAdapter(this)
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = tabTitles[position]
            pager.setCurrentItem(tab.position, true)
        }.attach()
    }
}

enum class StoreType {
    STRING, BOOLEAN, INT, FLOAT, LONG
}