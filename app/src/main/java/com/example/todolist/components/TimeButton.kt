package com.example.todolist.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.ui.theme.PRIORITY_DROP_DOWN_HEIGHT
import com.example.todolist.utils.LocalDateTimeUtil
import com.loper7.date_time_picker.dialog.CardDatePickerDialog
import java.time.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeButton(
    time: Long?,
    onTimeChanged:(Long?)->Unit
) {
    val mContext = LocalContext.current
    var showPicker by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .height(PRIORITY_DROP_DOWN_HEIGHT)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(
                    alpha = ContentAlpha.disabled
                ),
                shape = MaterialTheme.shapes.small
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_alarm_clock), contentDescription = null,
            modifier = Modifier
                .size(24.dp, 24.dp)
                .weight(1f)
        )

            Text(
                text = if(time==null)"设置提醒" else LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()).toString(),
                modifier = Modifier
                    .weight(8f),
                style = MaterialTheme.typography.subtitle2
            )
            IconButton(
                onClick = {
                    showPicker = true
                },
                modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .weight(1.5f)
            ) {
                Icon(
                    imageVector = if(time==null) Icons.Filled.Settings else Icons.Filled.Settings,
                    contentDescription = null
                )
            }

        if (showPicker) {
            CardDatePickerDialog.builder(context = mContext)
                .setTitle("SET MAX DATE")
                .setOnChoose { millisecond ->
                    showPicker = false
                    val time = LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(millisecond),
                        ZoneId.systemDefault()
                    )
                    onTimeChanged(millisecond)
                }
                .setOnCancel {
                    showPicker=false
                    onTimeChanged(null)
                    Toast.makeText(mContext, "取消了选择", Toast.LENGTH_SHORT).show()
                }
                .build().show()
        }

    }
}

