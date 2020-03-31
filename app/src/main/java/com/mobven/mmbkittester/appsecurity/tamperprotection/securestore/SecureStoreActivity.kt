package com.mobven.mmbkittester.appsecurity.tamperprotection.securestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mobven.appsecurity.AppSecurity
import com.mobven.mmbkittester.R
import kotlinx.android.synthetic.main.activity_secure_store.*

class SecureStoreActivity: AppCompatActivity() {

    private val tabTitles = listOf("WRITE", "READ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secure_store)

        AppSecurity.preferencesMasterKey = "MySecretKey"

        pager.adapter = SecureStorePagerAdapter(this)
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = tabTitles[position]
            pager.setCurrentItem(tab.position, true)
        }.attach()
    }
}

enum class StoreType {
    STRING, BOOLEAN, INT, FLOAT, LONG
}