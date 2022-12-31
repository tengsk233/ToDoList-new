package com.example.todolist.view.viewui

import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.DocumentsContract
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.todolist.R
import com.example.todolist.ui.theme.fabBackgroundColor
import com.example.todolist.utils.Action
import com.example.todolist.utils.FilesUtil
import com.example.todolist.utils.SearchAppBarState
import com.example.todolist.view.viewmodel.ToDoViewModel
import com.example.todolist.view.viewui.calender.Calendar
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int ) -> Unit,
    toDoViewModel: ToDoViewModel
) {
    LaunchedEffect(key1 = true) {
        toDoViewModel.getAllTasks()
        /*toDoViewModel.getDoneTasks()
        toDoViewModel.getUndoneTasks()*/
        /*toDoNotesViewModel.readSortState()*/
    }

    //从ViewModel中提取所需数据
    val action by toDoViewModel.action
    val allTasks by toDoViewModel.allTasks.collectAsState()
    val searchedTasks by toDoViewModel.searchedTasks.collectAsState()
    val searchAppBarState : SearchAppBarState by toDoViewModel.searchAppBarState
    val searchTextState : String by toDoViewModel.searchTextState
    val scaffoldState = rememberScaffoldState()
    val result = remember { mutableStateOf<Uri?>(null) }
    val context= LocalContext.current

    //导入文件的回调函数
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        result.value = it
        if (it != null) {
            val docId = DocumentsContract.getDocumentId(it)
            val split = docId.split(":").toTypedArray()
            val type = split[0]
            if ("primary".equals(type, ignoreCase = true)) {
                val path = "/" + split[1]
                toDoViewModel.importTasks(
                    FilesUtil.readExternal(
                        context = context,
                        filename = path
                    )
                )
                Toast.makeText(context, "导入成功", Toast.LENGTH_SHORT).show()
            }
        }
    }


    DisplaySnackBar(
        scaffoldState = scaffoldState,
        handleDatabaseActions = {
            //调用viewModel中的方法检测页面变化
            toDoViewModel.handleDatabaseActions(action = action,context)},
        onUndoClicked = {
            toDoViewModel.action.value = it
        },
        taskTitle = toDoViewModel.title.value ,
        action = action
    )


    //主要界面
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ListAppBar(
                toDoNotesViewModel = toDoViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState,
                onImportClick = {
                    launcher.launch("text/plain")

                }
            )
        },
        content = {
            ListContent(
                allTasks = allTasks,
                searchedTasks = searchedTasks,
                searchAppBarState = searchAppBarState,
                onSwipeToDelete = {action,task ->
                    toDoViewModel.action.value = action
                    toDoViewModel.updateTaskField(selectedTask = task)

                },
                onTaskStatusChange = {action, todoTask, status ->
                    toDoViewModel.action.value=action
                    toDoViewModel.updateTaskField(selectedTask = todoTask, status = status)
                },
                navigateToTaskScreen = navigateToTaskScreen,
                context
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}


//自定义悬浮按钮
@Composable
fun ListFab(
    onFabClicked: (taskId: Int ) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
            id = R.string.add_button),
            tint = Color.White
        )
    }
}

//自定义snackbar
@Composable
fun DisplaySnackBar(
    scaffoldState: ScaffoldState,
    handleDatabaseActions: () -> Unit,
    onUndoClicked: (Action) -> Unit,
    taskTitle : String,
    action: Action
) {
    handleDatabaseActions()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = action) {
        if (action != Action.NO_ACTION) {
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = setMessage(action = action,taskTitle = taskTitle),
                    actionLabel = setActionLabel(action = action)
                )
                undoDeletedTask(action = action,
                snackBarResult = snackBarResult,
                onUndoClicked = onUndoClicked)
            }
        }
    }
}

private fun setMessage(action: Action, taskTitle: String) : String {
    return when(action) {
        Action.DELETE_ALL -> "所有待办项均被删除"
        else -> "${action.name}: $taskTitle"
    }
}

private fun setActionLabel(action: Action): String {
    return if (action.name == "DELETE" ) "撤销" else "确定"
}

private fun undoDeletedTask(
    action: Action,
    snackBarResult: SnackbarResult,
    onUndoClicked : (Action) -> Unit,
) {
    if (snackBarResult == SnackbarResult.ActionPerformed && action == Action.DELETE) {
        onUndoClicked(Action.UNDO)
    }
}