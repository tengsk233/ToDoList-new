package com.example.todolist.view.viewmodel

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.example.todolist.database.repositories.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.database.model.ToDoTask
import com.example.todolist.notification.AlarmSetting
import com.example.todolist.utils.Action
import com.example.todolist.utils.Constants.MAX_TITLE_LENGTH
import com.example.todolist.utils.RequestState
import com.example.todolist.utils.SearchAppBarState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.gson.Gson
import com.google.gson.internal.`$Gson$Types`
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.ZoneId

@HiltViewModel
@OptIn(ExperimentalPermissionsApi::class)
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
):ViewModel() {
    val action: MutableState<Action> = mutableStateOf(Action.NO_ACTION)
    val id: MutableState<Int> = mutableStateOf(0)
    val title: MutableState<String> = mutableStateOf("")
    val description: MutableState<String?> = mutableStateOf(null)
    val time: MutableState<Long?> = mutableStateOf(null)
    val status:MutableState<Boolean> = mutableStateOf(false)
    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    var selectDay = mutableStateOf(1)

    private val _searchedTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val searchedTasks: StateFlow<RequestState<List<ToDoTask>>> = _searchedTasks

    fun searchDatabaseByString(searchQuery: String) {
        _searchedTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.searchDatabaseByName(searchQuery = "%$searchQuery").collect { searchTasks ->
                    _searchedTasks.value = RequestState.Success(searchTasks)
                }
            }
        } catch (e: Exception) {
            _searchedTasks.value = RequestState.Error(e)
        }
        searchAppBarState.value = SearchAppBarState.TRIGGERED
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun searchDatabaseByDate(searchDate: LocalDateTime) {
        _searchedTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.searchDatabaseByDate(searchDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()).collect { searchTasks ->
                    _searchedTasks.value = RequestState.Success(searchTasks)
                }
            }
        } catch (e: Exception) {
            _searchedTasks.value = RequestState.Error(e)
        }
        searchAppBarState.value = SearchAppBarState.TRIGGERED
    }

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<ToDoTask>>> = _allTasks

    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllTasks.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allTasks.value = RequestState.Error(e)
        }
    }

    private val _selectedTask: MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selectedTask: StateFlow<ToDoTask?> = _selectedTask

    fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            repository.getSelectedTask(taskId).collect { task ->
                _selectedTask.value = task
            }
        }
    }

    private val _doneTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val doneTasks: StateFlow<RequestState<List<ToDoTask>>> = _doneTasks

    fun getDoneTasks() {
        _doneTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getDoneTasks.collect {
                    _doneTasks.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _doneTasks.value = RequestState.Error(e)
        }
    }

    private val _undoneTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val undoneTasks: StateFlow<RequestState<List<ToDoTask>>> = _undoneTasks

    fun getUndoneTasks() {
        _undoneTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getUndoneTasks.collect {
                    _undoneTasks.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _undoneTasks.value = RequestState.Error(e)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = ToDoTask(
                title = title.value,
                description = description.value,
                time = time.value,
                status = status.value
            )
            repository.addTask(toDoTask)
        }
        searchAppBarState.value = SearchAppBarState.CLOSED
    }

    private fun updateTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = ToDoTask(
                id = id.value,
                title = title.value,
                description = description.value,
                time = time.value,
                status = status.value
            )
            repository.updateTask(toDoTask = toDoTask)
        }
    }

    private fun updateTaskStatus(status:Boolean){

    }
    private fun deleteTask(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = ToDoTask(
                id = id.value,
                title = title.value,
                description = description.value,
                time = time.value,
                status = status.value
            )
            AlarmSetting.cancelAlarm(context, toDoTask)
            repository.deleteTask(toDoTask = toDoTask)
        }
    }

    private fun deleteAllTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTasks()
        }
    }

    //更新viewModel内的Task
    fun updateTaskField(selectedTask: ToDoTask?) {
        if (selectedTask != null) {
            id.value = selectedTask.id
            title.value = selectedTask.title
            description.value = selectedTask.description
            time.value = selectedTask.time
            status.value = selectedTask.status
        } else {
            id.value = 0
            title.value = ""
            description.value = ""
            time.value = null
            status.value = false
        }
    }
    fun updateTaskField(selectedTask: ToDoTask?,status: Boolean) {
        if (selectedTask != null) {
            id.value = selectedTask.id
            title.value = selectedTask.title
            description.value = selectedTask.description
            time.value = selectedTask.time
            this.status.value = status
        } else {
            id.value = 0
            title.value = ""
            description.value = ""
            time.value = null
            this.status.value = false
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun handleDatabaseActions(action: Action,context:Context) {
        when (action) {
            Action.ADD -> addTask()
            Action.UPDATE -> updateTask()
            Action.DELETE -> deleteTask(context)
            Action.DELETE_ALL -> deleteAllTasks()
            Action.UNDO -> addTask()
            else -> {}
        }
        this.action.value = Action.NO_ACTION
    }

    fun updateTitle(newTitle: String) {
        if (newTitle.length < MAX_TITLE_LENGTH) {
            title.value = newTitle
        }
    }

    fun validateFields(): Boolean {
        return title.value.isNotEmpty()
    }

      fun exportAllTask():String {

          val allTasks=allTasks.value
          return if(allTasks is RequestState.Success) Gson().toJson(allTasks.data)
          else ""
          Log.d("daochu",1.toString())
      }

    private fun <T> getDataList(clazz: Class<T>?, string: String?, ): List<T>? {
        var datalist: List<T> = ArrayList()
        val gson = Gson()
        //        datalist = gson.fromJson(strJson, new TypeToken<List<T>>() {}.getType());
        //改为下面的方法，clazz传入实际想要解析出来的类
        val listType: Type = `$Gson$Types`.newParameterizedTypeWithOwner(
            null,
            ArrayList::class.java, clazz
        )
        datalist = gson.fromJson(string, listType)
        return datalist
    }

    fun importTasks(string:String){
      val tasks=getDataList(ToDoTask::class.java, string = string)

        viewModelScope.launch {
            tasks?.let { repository.addTasks(it) }
        }
    }
}