package com.example.todolist.database.model

import androidx.compose.runtime.CompositionContext
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todolist.utils.Constants
import com.example.todolist.utils.TimeConvert
import java.time.LocalDateTime


@Entity(tableName =Constants.DATABASE_TABLE)
@TypeConverters(TimeConvert::class)
class ToDoTask (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String?,
    val time:Long?,
    val status:Boolean
    //val priority: Priority
)


