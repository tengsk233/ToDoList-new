package com.example.todolist.view.viewui.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.todolist.R
import com.example.todolist.database.model.ToDoTask
import com.example.todolist.ui.theme.topAppBarBackgroundColor
import com.example.todolist.ui.theme.topAppBarContentColor
import com.example.todolist.utils.Action
import com.example.todolist.components.DisplayAlertDialog

//设置新建还是传递已有的界面
@Composable
fun TaskAppBar(
    selectedTask : ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedTask == null) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}

//新建taskBar界面设计
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        //返回
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        //标题
        title = {
            Text(
                text = stringResource(R.string.add_task),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        //添加
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
        AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(
    onBackClicked : (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION ) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_arrow),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun AddAction(
    onAddClicked : (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.add_task),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

//存在界面的Bar界面设计
@Composable
fun ExistingTaskAppBar(
    selectedTask : ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colors.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ExistingTaskAppBarActions(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        }
    )
}

@Composable
fun CloseAction(
    onCloseClicked : (Action) -> Unit
) {
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION ) }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(R.string.close_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun ExistingTaskAppBarActions(
    selectedTask : ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    var openDialog by remember { mutableStateOf(value = false) }
    //设置弹出框
    DisplayAlertDialog(
        title = stringResource(
            id = R.string.delete_task,
            selectedTask.title
        ),
        message = stringResource(
            id = R.string.delete_task_confirmation,
            selectedTask.title
        ),
        openDialog =openDialog,
        closeDialog = {openDialog = false },
        onYesClicked = {navigateToListScreen(Action.DELETE)}
    )

    DeleteAction(onDeleteClicked = {
        openDialog = true
    })
    UpdateAction(onUpdateClicked = navigateToListScreen)
}

@Composable
fun DeleteAction(
    onDeleteClicked : () -> Unit
) {
    IconButton(onClick = { onDeleteClicked() }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked : (Action) -> Unit
) {
    IconButton(onClick = { onUpdateClicked(Action.UPDATE ) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.update_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}