package com.pandey.saurabh.kotlinfcm

import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "onNewToken: $token")

        //server code will be here
        sendRegistrationToServer(token)

    }

    private fun sendRegistrationToServer(token: String?) {



    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

      /*  val messageReceived = remoteMessage.data["message"]!!
        Log.d(TAG, "onMessageReceived: message received from  remote server is  $remoteMessage")
        passMessageToActivity(messageReceived)*/


      /*  remoteMessage?.data.let {
            Log.d(TAG, "Message data payload: $remoteMessage")
        }


        remoteMessage?.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.imageUrl}")
           // sendNotification(it.body!!)

        //    NotificationHelper.displayNotification(applicationContext, title!!, body!!)


            it.title?.let { it1 -> it.body?.let { it2 ->
                NotifyMe.displayNotification(applicationContext, it1,
                    it2
                )
            } }
        }*/


        if (remoteMessage.notification != null) {
            val title = remoteMessage.notification!!.title
            val body = remoteMessage.notification!!.body

            NotifyMe.displayNotification(applicationContext, title!!, body!!)
        }

    }

    private fun passMessageToActivity(messageReceived: String) {

        val intent = Intent().apply {

            action = INTENT_ACTION_SEND_MESSAGE
            putExtra("message", messageReceived)
        }

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

    }

    companion object {
        const val TAG = "MyFirebaseMessagingServ"
        const val INTENT_ACTION_SEND_MESSAGE = "INTENT_ACTION_SEND_MESSAGE"

    }
}