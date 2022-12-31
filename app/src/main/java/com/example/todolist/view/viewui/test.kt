package com.example.todolist.view.viewui

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.components.TimeButton
import com.example.todolist.view.viewui.task.TaskContent

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun EmptyContent() {
    TaskContent(
        title = "123",
        onTitleChange = {},
        description = "123",
        onDescriptionChange = {},
        time = null,
        onTimeSelected = {}
    )
}
