package com.mobven.mmbkittester.onelink

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.mobven.mmbkittester.MMBKitApp.Companion.DEFAULT_NOTIFICATION_CHANNEL
import com.mobven.onelink.OneLink
import com.mobven.onelink.model.NotificationParams
import com.mobven.onelink.model.OneLinkableState

class OneLinkMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        message.data[URL_KEY]?.let { url ->
            when (message.data[TYPE_KEY]) {
                TYPE_SENSITIVE -> OneLink.showNotification(
                    this, url, NotificationParams(
                        DEFAULT_NOTIFICATION_CHANNEL,
                        1,
                        OneLinkableState.WAITING_FOR_APPROVAL,
                        OneLinkHandlerActivity::class.java
                    )
                ) {
                    it.setSmallIcon(android.R.drawable.ic_popup_reminder)
                    it.setContentTitle(message.data[TITLE_KEY].orEmpty())
                    it.setContentText(message.data[CONTENT_KEY].orEmpty())
                }
                TYPE_GENERAL -> OneLink.showNotification(
                    this, url, NotificationParams(
                        DEFAULT_NOTIFICATION_CHANNEL,
                        2
                    )
                ) {
                    it.setSmallIcon(android.R.drawable.ic_popup_reminder)
                    it.setContentTitle(message.data[TITLE_KEY].orEmpty())
                    it.setContentText(message.data[CONTENT_KEY].orEmpty())
                }
            }
        }

    }

    companion object {
        private const val TYPE_KEY = "type"
        private const val TYPE_SENSITIVE = "sensitive"
        private const val TYPE_GENERAL = "general"
        private const val URL_KEY = "url"
        private const val TITLE_KEY = "title"
        private const val CONTENT_KEY = "content"
    }

}