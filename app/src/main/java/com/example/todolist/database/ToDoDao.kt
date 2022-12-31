package com.example.todolist.database

import androidx.room.*
import com.example.todolist.database.model.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE id = :taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY  time ASC")
    fun sortByNewTime(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY time DESC")
    fun sortByOldTime(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE status = 1")
    fun getDoneTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE status = 0")
    fun getUndoneTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE date(time/1000,'unixepoch')=date(:date/1000)")
    fun getTaskByDay(date: Long): Flow<List<ToDoTask>>

}