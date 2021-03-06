package com.mobven.mmbkittester

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.mobven.accountsecurity.AccountSecurity
import com.mobven.appsecurity.AppSecurity
import com.mobven.core.MobKit
import com.mobven.errorkit.ErrorKit
import com.mobven.localizeit.LocalizeIt
import com.mobven.network.SecureNetwork
import com.mobven.onelink.OneLink
import com.mobven.permissionmanager.PermissionManager


class MobKitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MobKit.init(
            this,
            true,
            AppSecurity,
            AccountSecurity,
            OneLink,
            ErrorKit,
            SecureNetwork,
            LocalizeIt.apply {
                stringsFile = "strings.json"
                supportedLanguages = listOf(LANGUAGE_ENGLISH, LANGUAGE_TURKISH, LANGUAGE_ALBANIAN)
                fallbackLanguage = LANGUAGE_ENGLISH
            },
            PermissionManager
        )
        createNotificationChannel()
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            Log.e("FirebaseIId", it.token)
        }
    }

    //https://developer.android.com/training/notify-user/build-notification#Priority
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = DEFAULT_NOTIFICATION_CHANNEL
            val name = "Default Channel Name"
            val descriptionText = "Default Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val DEFAULT_NOTIFICATION_CHANNEL = "Default"
        const val LANGUAGE_ENGLISH = "en"
        const val LANGUAGE_TURKISH = "tr"
        const val LANGUAGE_ALBANIAN = "sq"

    }
}