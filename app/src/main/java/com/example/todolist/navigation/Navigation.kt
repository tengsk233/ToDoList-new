package com.example.todolist.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todolist.navigation.destinations.listComposable
import com.example.todolist.navigation.destinations.taskComposable
import com.example.todolist.utils.Constants.LIST_SCREEN
import com.example.todolist.view.viewmodel.ToDoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun ToDoNavigation(
    navHostController: NavHostController,
    toDoViewModel: ToDoViewModel
) {
    val screen = remember(navHostController) { Screens(navHostController) }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task,
            toDoViewModel = toDoViewModel
        )
        //把tesk界面添加到跳转列表
        taskComposable(
            toDoViewModel = toDoViewModel,
            navigateToListScreen = screen.list
        )
    }
}


















