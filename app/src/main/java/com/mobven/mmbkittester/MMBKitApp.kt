package com.mobven.mmbkittester

import android.app.Application
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.appsecurity.AppSecurity
import com.mobven.core.MMBKit


class MMBKitApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MMBKit.init(this, AppSecurity, AccountSecurity)
    }
}