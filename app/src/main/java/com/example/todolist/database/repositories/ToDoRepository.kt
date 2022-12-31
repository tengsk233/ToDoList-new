package com.example.todolist.database.repositories

import androidx.compose.foundation.lazy.LazyItemScope
import androidx.room.Room
import com.example.todolist.database.ToDoDao
import com.example.todolist.database.ToDoDatabase
import com.example.todolist.database.model.ToDoTask
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(
    private val toDoDao: ToDoDao
) {
    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByNewTime: Flow<List<ToDoTask>> = toDoDao.sortByNewTime()
    val sortByOldTime: Flow<List<ToDoTask>> = toDoDao.sortByOldTime()
    val getDoneTasks: Flow<List<ToDoTask>> = toDoDao.getDoneTasks()
    val getUndoneTasks: Flow<List<ToDoTask>> = toDoDao.getUndoneTasks()

    fun searchDatabaseByDate(date:Long):Flow<List<ToDoTask>>{
        return toDoDao.getTaskByDay(date = date)
    }

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(toDoTask)
    }

    suspend fun addTasks(list: List<ToDoTask>){
        list.forEach{
            toDoDao.addTask(it)
        }
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabaseByName(searchQuery: String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery)
    }


}