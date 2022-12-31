package com.example.todolist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.database.model.ToDoTask

@Database(entities = [ToDoTask::class], version = 2 , exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun toDoDao() : ToDoDao
}