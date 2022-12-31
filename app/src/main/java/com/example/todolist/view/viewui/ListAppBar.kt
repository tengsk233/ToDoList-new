package com.example.todolist.view.viewui

import ando.file.core.FileOperator
import ando.file.selector.FileType
import android.Manifest
import android.app.Activity
import android.os.Build
import android.text.style.ClickableSpan
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.example.todolist.HiltApp
import com.example.todolist.MainActivity
import com.example.todolist.ui.theme.Typography
import com.example.todolist.R
import com.example.todolist.components.DisplayAlertDialog
import com.example.todolist.database.model.ToDoTask
import com.example.todolist.ui.theme.LARGE_PADDING
import com.example.todolist.ui.theme.TOP_APP_BAR_HEIGHT
import com.example.todolist.ui.theme.topAppBarBackgroundColor
import com.example.todolist.ui.theme.topAppBarContentColor
import com.example.todolist.utils.*
import com.example.todolist.view.viewmodel.ToDoViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ListAppBar(
    toDoNotesViewModel: ToDoViewModel,
    searchAppBarState : SearchAppBarState,
    searchTextState : String,
    onImportClick: () -> Unit,
) {
    val permissionState = rememberPermissionState(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    val context = LocalContext.current


    when(searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                onSearchClicked = {
                toDoNotesViewModel.searchAppBarState.value =
                    SearchAppBarState.OPENED
                },
                //onSortClicked = {toDoNotesViewModel.persistSortState(it)},
                onDeleteAllConfirmed = {
                    toDoNotesViewModel.action.value = Action.DELETE_ALL
                },
                onExportClick = {
                    val uri=FilesUtil.writeExternal(context = context, filename = LocalDateTimeUtil.convertDateToString(LocalDateTime.now())+".txt", content = toDoNotesViewModel.exportAllTask())
                    //uri?.let { FileOpener.openShare(context, it,"分享文件") }
                    //Toast.makeText(context,"生成了uri"+uri.toString(),Toast.LENGTH_SHORT).show()
                    FileOpener.openUrl(context,uri.toString())
                },
                onImportClick = onImportClick,
                onShareClick = {
                    //111111Toast.makeText(context,"点击了分享",Toast.LENGTH_SHORT).show()
                    val uri=FilesUtil.writeExternal(context = context, filename = LocalDateTimeUtil.convertDateToString(LocalDateTime.now())+".txt", content = toDoNotesViewModel.exportAllTask())
                    //Toast.makeText(context,"生成了uri"+uri.toString(),Toast.LENGTH_SHORT).show()
                    uri?.let { FileOpener.openShare(context, it,"分享文件") }
                }
            )
        }
        else -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = {newText ->
                    toDoNotesViewModel.searchTextState.value = newText
                },
                onCloseClicked = {
                    toDoNotesViewModel.searchAppBarState.value =
                        SearchAppBarState.CLOSED
                    toDoNotesViewModel.searchTextState.value = ""
                },
                onSearchClicked = {
                    toDoNotesViewModel.searchDatabaseByString(searchQuery = it)
                }
            )
        }
    }
}

@Composable
fun DefaultListAppBar(
    onSearchClicked : () -> Unit,
    onDeleteAllConfirmed : () -> Unit,
    onExportClick:()->Unit,
    onImportClick: () -> Unit,
    onShareClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.list_screen_title),
                color = MaterialTheme.colors.topAppBarContentColor,
            )
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onDeleteAllConfirmed = onDeleteAllConfirmed,
                onExportClick = onExportClick,
                onImportClick = onImportClick,
                onShareClick = onShareClick
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked : () -> Unit,
    onDeleteAllConfirmed : () -> Unit,
    onExportClick:()->Unit,
    onImportClick: () -> Unit,
    onShareClick: () -> Unit
) {
    var openDialog by remember {mutableStateOf(false) }
    DisplayAlertDialog(
        title = stringResource(id = R.string.delete_all_tasks),
        message = stringResource(id = R.string.delete_all_tasks_confirmation),
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = { onDeleteAllConfirmed() }
    )

    SearchAction(onSearchClicked = onSearchClicked)
    DeleteAllAction(onDeleteAllConfirmed = { openDialog = true},
    onExportClick = onExportClick,
    onImportClick = onImportClick,
    onShareClick = onShareClick)

}

@Composable
fun SearchAction(
    onSearchClicked : () -> Unit
) {
    IconButton(onClick = onSearchClicked) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun DeleteAllAction(
    onDeleteAllConfirmed: () -> Unit,
    onExportClick:()->Unit,
    onImportClick:()->Unit,
    onShareClick:()->Unit
 ) {
    var expanded by remember { mutableStateOf(false) }
    var checkPermission by remember { mutableStateOf(false) }
    val permission = Manifest.permission.READ_EXTERNAL_STORAGE
    val permissionState = rememberPermissionState(permission)
    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(id = R.string.delete_all_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteAllConfirmed()
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = LARGE_PADDING),
                    text = stringResource(R.string.delete_all_action),
                    style = Typography.subtitle2
                )
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onExportClick()
            }) {
                Text(
                    text = stringResource(id = R.string.export_Tasks),
                    modifier = Modifier
                        .padding(start = LARGE_PADDING),
                    style = Typography.subtitle2
                )
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onImportClick()
            }) {
                Text(
                    text = stringResource(id = R.string.import_Tasks),
                    modifier = Modifier
                        .padding(start = LARGE_PADDING),
                    style = Typography.subtitle2
                )
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onShareClick()
            }) {
                Text(
                    text = stringResource(id = R.string.share_Tasks),
                    modifier = Modifier
                        .padding(start = LARGE_PADDING),
                    style = Typography.subtitle2
                )
            }
        }
    }
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange : (String) -> Unit,
    onCloseClicked : () -> Unit,
    onSearchClicked :  (String) -> Unit
) {
    var trailingIconState by remember {
        mutableStateOf(TrailingIconState.READY_TO_DELETE)
    }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackgroundColor

    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = stringResource(R.string.search_placeholder),
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.disabled),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_icon),
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        when(trailingIconState) {
                            TrailingIconState.READY_TO_DELETE -> {
                                onTextChange("")
                                trailingIconState = TrailingIconState.READY_TO_CLOSE
                            }
                            TrailingIconState.READY_TO_CLOSE -> {
                                if (text.isNotEmpty()) {
                                    onTextChange("")
                                } else {
                                    onCloseClicked()
                                    trailingIconState = TrailingIconState.READY_TO_DELETE
                                }
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )
        )
    }
}