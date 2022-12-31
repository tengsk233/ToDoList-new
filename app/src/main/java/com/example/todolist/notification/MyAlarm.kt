package com.example.todolist.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_MAX
import com.example.todolist.R

class MyAlarm: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        try {
            val title = intent.getStringExtra("title")
            val desc = intent.getStringExtra("desc")
            if (desc != null && title != null) {
                showNotification(context, title, desc)
            }
        } catch (ex: Exception) {
            Log.d("Receive Ex", "onReceive: ${ex.printStackTrace()}")
        }
    }
}

private fun showNotification(context: Context, title: String, desc: String) {
    val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val channelId = "message_channel"
    val channelName = "message_name"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(channel)
    }

    val builder = NotificationCompat.Builder(context, channelId)
        .setContentTitle(title)
        .setContentText(desc)
        .setPriority(PRIORITY_MAX)
        .setSmallIcon(R.mipmap.ic_launcher)



    manager.notify(1, builder.build())
}