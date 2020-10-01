package com.pandey.saurabh.kotlinfcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.pandey.saurabh.kotlinfcm.MyFirebaseMessagingService.Companion.INTENT_ACTION_SEND_MESSAGE

class MainActivity : AppCompatActivity() {
    lateinit var  receiver:BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*receiver = object:BroadcastReceiver(){
            override fun onReceive(p0: Context?, intent: Intent?) {
                val  message:String? = intent?.getStringExtra("message")

              //  showNotification( message)

            }
        }
*/


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = CHANNEL_DESC
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }



    }


    override fun onResume() {
        super.onResume()

        //register_broadcast_receiver
      /*  val  filter = IntentFilter(INTENT_ACTION_SEND_MESSAGE)
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,filter)*/
    }

    override fun onPause() {
        super.onPause()
        //un_register_broadcast_receiver
       // LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver)

    }


    companion object {
        const val CHANNEL_ID = "test_channel_id"
        private const val CHANNEL_NAME= "Test Channel Name"
        private const val CHANNEL_DESC = "Android Push Notification"
    }



}