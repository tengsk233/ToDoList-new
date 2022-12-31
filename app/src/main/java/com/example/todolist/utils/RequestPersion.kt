package com.example.todolist.utils

import android.Manifest
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun RequestPermissionUsingAccompanist(onPermissionConfirmed:@Composable ()->Unit) {
    val permission = Manifest.permission.READ_EXTERNAL_STORAGE
    // 定义 Permission State
    val permissionState = rememberPermissionState(permission)
    PermissionRequired(
        permissionState = permissionState,
        permissionNotAvailableContent = {
        }, permissionNotGrantedContent = {
        }, content = onPermissionConfirmed
    )
}
