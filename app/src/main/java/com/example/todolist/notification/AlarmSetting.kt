package com.example.todolist.notification

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.todolist.database.model.ToDoTask
import com.example.todolist.utils.LocalDateTimeUtil

object  AlarmSetting {
    var tasklist = mutableMapOf<Int, PendingIntent>()
    var timeList = mutableMapOf<Int, Long>()

    @SuppressLint("UnspecifiedImmutableFlag")
    fun addAlarm(context: Context, toDoTask: ToDoTask) {
        val timeSec = toDoTask.time
        //val timeSec = System.currentTimeMillis() + toDoTask.time!!
        val alarmManager = context.getSystemService(ComponentActivity.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyAlarm::class.java)
        intent.putExtra("title", toDoTask.title)
        intent.putExtra("desc", toDoTask.description)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            toDoTask.id,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        if (timeSec != null && timeSec > System.currentTimeMillis()) {
            Log.d("alarmTime", LocalDateTimeUtil.convertDateToString(timeSec))
            when {
                tasklist[toDoTask.id] == null -> {
                    alarmManager.set(AlarmManager.RTC_WAKEUP, timeSec, pendingIntent)
                    tasklist[toDoTask.id] = pendingIntent
                    timeList[toDoTask.id] = toDoTask.time
                    Log.d("addAlarm", toDoTask.title)
                }
                toDoTask.status -> {
                    cancelAlarm(context, toDoTask = toDoTask)
                }
                timeList[toDoTask.id] != toDoTask.time -> {
                    alarmManager.cancel(tasklist[toDoTask.id])
                    alarmManager.set(AlarmManager.RTC_WAKEUP, timeSec, pendingIntent)
                    tasklist[toDoTask.id] = pendingIntent
                    timeList[toDoTask.id] = toDoTask.time
                    Log.d("update", toDoTask.title)
                }
            }
        }
    }


    fun cancelAlarm(context: Context, toDoTask: ToDoTask) {
        val alarmManager = context.getSystemService(ComponentActivity.ALARM_SERVICE) as AlarmManager
        if (tasklist[toDoTask.id] != null) {
            alarmManager.cancel(tasklist[toDoTask.id])
            tasklist.remove(toDoTask.id)
            timeList.remove(toDoTask.id)
        }
        Log.d("remove", toDoTask.title)
    }

}