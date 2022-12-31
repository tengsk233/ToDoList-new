package com.example.todolist.view.viewui.task

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.database.model.ToDoTask
import com.example.todolist.utils.Action
import com.example.todolist.view.viewmodel.ToDoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    toDoViewModel: ToDoViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    //从ViewModel里提取所需数据
    val title: String by toDoViewModel.title
    val description: String? by toDoViewModel.description
    val time:Long? by toDoViewModel.time
    val status:Boolean by toDoViewModel.status
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (toDoViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            Toast.makeText(context, "Fields Empty", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    toDoViewModel.updateTitle(it)
                },
                description = description,
                onDescriptionChange = {
                    toDoViewModel.description.value = it
                },
                time = time,
                onTimeSelected = {
                    toDoViewModel.time.value=it
                }
            )
        }
    )
}
















