package com.mobven.mmbkittester

import android.app.Application
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.appsecurity.AppSecurity
import com.mobven.core.MMBKit
import com.mobven.mmbkittester.onelink.OneLinkInfoActivity
import com.mobven.onelink.LinkDirection
import com.mobven.onelink.OneLink


class MMBKitApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MMBKit.init(this, AppSecurity, AccountSecurity, OneLink)
    }
}