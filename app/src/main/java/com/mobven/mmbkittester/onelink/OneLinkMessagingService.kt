package com.mobven.mmbkittester.onelink

import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.mobven.mmbkittester.MMBKitApp.Companion.DEFAULT_NOTIFICATION_CHANNEL
import com.mobven.onelink.OneLink
import com.mobven.onelink.model.NotificationParams
import com.mobven.onelink.model.OneLinkableState

class OneLinkMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val notifBuilder: (NotificationCompat.Builder) -> Unit = {
            it.setSmallIcon(android.R.drawable.ic_popup_reminder)
            it.setContentTitle(message.data[KEY_TITLE].orEmpty())
            it.setContentText(message.data[KEY_CONTENT].orEmpty())
            it.setAutoCancel(true)
        }
        message.data[KEY_URL]?.let { url ->
            when (message.data[KEY_TYPE]) {
                TYPE_SENSITIVE -> OneLink.showNotification(
                    this, url, NotificationParams(
                        DEFAULT_NOTIFICATION_CHANNEL,
                        1,
                        OneLinkableState.WAITING_FOR_APPROVAL,
                        OneLinkHandlerActivity::class.java
                    ), notifBuilder
                )
                TYPE_GENERAL -> OneLink.showNotification(
                    this, url, NotificationParams(
                        DEFAULT_NOTIFICATION_CHANNEL,
                        2
                    ), notifBuilder
                )
            }
        }

    }

    companion object {
        private const val KEY_TYPE = "type"
        private const val TYPE_SENSITIVE = "sensitive"
        private const val TYPE_GENERAL = "general"
        private const val KEY_URL = "url"
        private const val KEY_TITLE = "title"
        private const val KEY_CONTENT = "content"
    }

}