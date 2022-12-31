package com.example.todolist.view.viewui

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.database.model.ToDoTask
import com.example.todolist.notification.AlarmSetting
import com.example.todolist.ui.theme.*
import com.example.todolist.utils.Action
import com.example.todolist.utils.LocalDateTimeUtil
import com.example.todolist.utils.RequestState
import com.example.todolist.utils.SearchAppBarState
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId


@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun ListContent(
    allTasks : RequestState<List<ToDoTask>>,
    /*doneTasks: RequestState<List<ToDoTask>>,
    undoneTasks:RequestState<List<ToDoTask>>,*/
    searchedTasks : RequestState<List<ToDoTask>>,
   /* lowPriorityTasks: List<ToDoTask>,
    highPriorityTasks: List<ToDoTask>,*/
    searchAppBarState: SearchAppBarState,
    //sortState: RequestState<Priority>,
    onSwipeToDelete: (Action, ToDoTask) -> Unit,
    onTaskStatusChange: (Action, todoTask: ToDoTask, status: Boolean) -> Unit,
    navigateToTaskScreen : (taskId: Int) -> Unit,
    context: Context

) {
    when (searchAppBarState) {
        SearchAppBarState.TRIGGERED -> {
            if (searchedTasks is RequestState.Success) {
                HandleListContent(
                    tasks = searchedTasks.data,
                    onSwipeToDelete = onSwipeToDelete,
                    navigateToTaskScreen = navigateToTaskScreen,
                    onTaskStatusChange = onTaskStatusChange,
                    context = context
                )
            }
        }
        else -> {
            if (allTasks is RequestState.Success) {
                HandleListContent(
                    tasks = allTasks.data,
                    onSwipeToDelete = onSwipeToDelete,
                    navigateToTaskScreen = navigateToTaskScreen,
                    onTaskStatusChange = onTaskStatusChange,
                    context
                )
            }
        }
        /*sortState.data == Priority.NONE -> {
            if (allTasks is RequestState.Success) {
                HandleListContent(
                    tasks = allTasks.data,
                    onSwipeToDelete = onSwipeToDelete,
                    navigateToTaskScreen = navigateToTaskScreen
                )
            }
        }
        sortState.data == Priority.LOW -> {
            HandleListContent(
                tasks = lowPriorityTasks,
                onSwipeToDelete = onSwipeToDelete,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
        sortState.data == Priority.HIGH -> {
            HandleListContent(
                tasks = highPriorityTasks,
                onSwipeToDelete = onSwipeToDelete,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }*/
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun HandleListContent(
    tasks: List<ToDoTask>,
    //滑动删除函数
    onSwipeToDelete:(Action, ToDoTask) -> Unit,
    //页面跳转
    navigateToTaskScreen: (taskId: Int) -> Unit,
    //任务状态改变
    onTaskStatusChange: (Action, todoTask: ToDoTask, status: Boolean)->Unit,
    context: Context
) {
    var expanded by remember { mutableStateOf(false) }
    val angel: Float by animateFloatAsState(targetValue = if (expanded) 0f else 270f)

    var dayExpanded by remember { mutableStateOf(false) }
    val dayAngel: Float by animateFloatAsState(targetValue = if (dayExpanded) 0f else 270f)

    //开启闹钟服务
    tasks.forEach {
        AlarmSetting.addAlarm(context = context, toDoTask = it)
    }

    if (tasks.isEmpty()) {
        com.jetpack.todonotes.view.EmptyContent()
    } else {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            DisplayTasks(
                tasks = tasks.filterTasks {
                    if (it.status)
                        return@filterTasks false
                    if (it.time == null)
                        return@filterTasks false
                    else {
                        val taskDate = LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(it.time),
                            ZoneId.systemDefault()
                        ).toLocalDate()
                        val systemDate = LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(System.currentTimeMillis()),
                            ZoneId.systemDefault()
                        ).toLocalDate()
                        return@filterTasks taskDate.isEqual(systemDate)||taskDate.isBefore(systemDate)
                    }
                },
                onSwipeToDelete = onSwipeToDelete,
                navigateToTaskScreen = navigateToTaskScreen,
                onTaskStatusChange = onTaskStatusChange
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { dayExpanded = !dayExpanded }
            ) {

                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Drop Down",
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .rotate(degrees = dayAngel)
                        .weight(1f)
                )
                Text(
                    text = "以后 " + tasks.filterTasks { if (it.status)
                        return@filterTasks false
                        if (it.time == null)
                            return@filterTasks true
                        else {
                            val taskDate = LocalDateTime.ofInstant(
                                Instant.ofEpochMilli(it.time),
                                ZoneId.systemDefault()
                            ).toLocalDate()
                            val systemDate = LocalDateTime.ofInstant(
                                Instant.ofEpochMilli(System.currentTimeMillis()),
                                ZoneId.systemDefault()
                            ).toLocalDate()
                            return@filterTasks taskDate.isAfter(systemDate)
                        } }.size,
                    modifier = Modifier
                        .weight(9f),
                    style = MaterialTheme.typography.subtitle2,
                    color = MediumGray
                )
            }
            if (dayExpanded)
                DisplayTasks(
                    tasks = tasks.filterTasks {
                        if (it.status)
                            return@filterTasks false
                        if (it.time == null)
                            return@filterTasks true
                        else {
                            val taskDate = LocalDateTime.ofInstant(
                                Instant.ofEpochMilli(it.time),
                                ZoneId.systemDefault()
                            ).toLocalDate()
                            val systemDate = LocalDateTime.ofInstant(
                                Instant.ofEpochMilli(System.currentTimeMillis()),
                                ZoneId.systemDefault()
                            ).toLocalDate()
                            return@filterTasks taskDate.isAfter(systemDate)
                        }
                    },
                    onSwipeToDelete = onSwipeToDelete,
                    navigateToTaskScreen = navigateToTaskScreen,
                    onTaskStatusChange = onTaskStatusChange
                )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { expanded = !expanded }
            ) {

                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Drop Down",
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .rotate(degrees = angel)
                        .weight(1f)
                )
                Text(
                    text = "已完成 " + tasks.filterTasks { it.status }.size,
                    modifier = Modifier
                        .weight(9f),
                    style = MaterialTheme.typography.subtitle2,
                    color = MediumGray
                )
            }
            if (expanded)
                DisplayTasks(
                    tasks = tasks.filterTasks { it.status },
                    onSwipeToDelete = onSwipeToDelete,
                    navigateToTaskScreen = navigateToTaskScreen,
                    onTaskStatusChange = onTaskStatusChange
                )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun DisplayTasks(
    tasks : List<ToDoTask>,
    onSwipeToDelete:(Action, ToDoTask) -> Unit,
    navigateToTaskScreen : (taskId: Int) -> Unit,
    onTaskStatusChange:(Action,todoTask:ToDoTask, status:Boolean)->Unit
) {

    LazyColumn {
        items(
            items = tasks,
            key = { task ->
                task.id
            }
        ) { task ->
            val dismissState = rememberDismissState()
            val dismissDirection = dismissState.dismissDirection
            val isDismissed = dismissState.isDismissed(direction = DismissDirection.EndToStart)
            if (isDismissed && dismissDirection == DismissDirection.EndToStart) {
                onSwipeToDelete(Action.DELETE, task)
            }

            val degrees by animateFloatAsState(if (dismissState.targetValue == DismissValue.Default) 0f else -45f)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MEDIUM_PADDING),
                elevation = 10.dp,
                shape = RoundedCornerShape(MEDIUM_PADDING)
            ) {
                SwipeToDismiss(
                    state = dismissState,
                    directions= setOf(DismissDirection.EndToStart),
                    dismissThresholds = {FractionalThreshold(0.2f)},
                    background = { RedBackground(degrees = degrees) },
                    dismissContent =  {
                        TaskItem(
                            toDoTask = task,
                            navigateToTaskScreen = navigateToTaskScreen,
                            onStatusChanged = { onTaskStatusChange(Action.UPDATE,task,it) }
                        )
                    }
                )
            }
        }
    }
}

private fun <E> List<E>.filterTasks(predicate: (E) -> Boolean):List<E> {
    val tasks= ArrayList<E>()
    this.forEach {
        if(predicate(it))
            tasks.add(it)
    }
    return tasks
}

@Composable
fun RedBackground(degrees : Float) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(HighPriorityColor)
        .padding(horizontal = LARGEST_PADDING),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            modifier = Modifier.rotate(degrees = degrees),
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(id = R.string.delete_icon),
            tint = Color.White
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@Composable
fun TaskItem(
    toDoTask : ToDoTask,
    navigateToTaskScreen : (taskId: Int) -> Unit,
    onStatusChanged:(status:Boolean)->Unit
) {
    val checkedState = remember { mutableStateOf(toDoTask.status) }
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(7f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.TaskTextColor(status = toDoTask.status),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        onStatusChanged(it)
                    },
                    modifier = Modifier.weight(1f)
                )
            }
            toDoTask.description?.let {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = it,
                    color = MaterialTheme.colors.TaskTextColor(status = toDoTask.status),
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (toDoTask.time != null)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_alarm_clock),
                        contentDescription = null,
                        modifier = Modifier
                            .size(18.dp, 18.dp)
                            .weight(0.9f),
                    )
                    Text(
                        modifier = Modifier.weight(9f),
                        text = LocalDateTimeUtil.convertDateToString(toDoTask.time),
                        style = MaterialTheme.typography.subtitle2,
                        color =
                        if (toDoTask.time < LocalDateTime.now().atZone(ZoneId.systemDefault())
                                .toInstant().toEpochMilli() && !toDoTask.status
                        ) TimeOutColor
                        else MaterialTheme.colors.TaskTextColor(status = toDoTask.status)
                    )
                }

        }
    }
}

