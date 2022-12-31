package com.example.todolist.navigation.destinations

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todolist.utils.Action
import com.example.todolist.utils.Constants.TASK_ARGUMENT_KEY
import com.example.todolist.utils.Constants.TASK_SCREEN
import com.example.todolist.view.viewmodel.ToDoViewModel
import com.example.todolist.view.viewui.task.TaskScreen

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState")
fun NavGraphBuilder.taskComposable(
    toDoViewModel: ToDoViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    //用composable进行封装
    composable(
        //设置路由
        route = TASK_SCREEN,
        //传递参数
        arguments = mutableStateListOf(
            navArgument(TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )
    ) { //传参的具体实现
            navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId) {
            //更新ViewModel里的taskID，确定选择的界面
            toDoViewModel.getSelectedTask(taskId)
        }

        //选界面传到screen里
        val selectedTask by toDoViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                toDoViewModel.updateTaskField(selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            toDoViewModel = toDoViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}

















