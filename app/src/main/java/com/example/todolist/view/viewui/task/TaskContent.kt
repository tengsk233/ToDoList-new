package com.example.todolist.view.viewui.task

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.todolist.ui.theme.LARGE_PADDING
import com.example.todolist.ui.theme.MEDIUM_PADDING
import java.time.LocalDateTime
import com.example.todolist.R
import com.example.todolist.components.TimeButton

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String?,
    onDescriptionChange: (String) -> Unit,
    time: Long?,
    onTimeSelected: (Long?) -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(LARGE_PADDING)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { onTitleChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(id = R.string.title)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )

        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = MaterialTheme.colors.background
        )

        /*PriorityDropDown(
            priority = priority,
            onPrioritySelected = onTimeSelected
        )*/
        TimeButton(time = time, onTimeChanged = onTimeSelected)


        OutlinedTextField(
            value = description ?: "",
            onValueChange = { onDescriptionChange(it) },
            modifier = Modifier.fillMaxSize(),
            label = { Text(text = stringResource(id = R.string.description)) },
            textStyle = MaterialTheme.typography.body1
        )
    }
}



















