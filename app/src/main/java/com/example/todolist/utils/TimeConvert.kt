package com.example.todolist.utils

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
class TimeConvert {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun timeToString(time: LocalDateTime?): String? {
        return formatter.format(time)
    }

    @TypeConverter
    fun stringToTime(value:String?):LocalDateTime{
        return formatter.parse(value,LocalDateTime::from)
    }
}