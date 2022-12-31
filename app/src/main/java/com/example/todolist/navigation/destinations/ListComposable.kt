package com.example.todolist.navigation.destinations

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todolist.utils.Constants.LIST_ARGUMENT_KEY
import com.example.todolist.utils.Constants.LIST_SCREEN
import com.example.todolist.utils.toAction
import com.example.todolist.view.viewmodel.ToDoViewModel
import com.example.todolist.view.viewui.ListScreen

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState")
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    toDoViewModel: ToDoViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = mutableStateListOf(
            navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        LaunchedEffect(key1 = action) {
            toDoViewModel.action.value = action
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            toDoViewModel = toDoViewModel
        )
    }
}















