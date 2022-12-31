package com.example.todolist

import ando.file.core.FileOperator
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.database.model.ToDoTask
import com.example.todolist.navigation.ToDoNavigation
import com.example.todolist.notification.AlarmSetting.addAlarm
import com.example.todolist.notification.AlarmSetting.cancelAlarm
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.utils.PersionUtil
import com.example.todolist.view.viewmodel.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val toDoViewModel: ToDoViewModel by viewModels()
    private var isRefuse:Boolean=false
    @OptIn(ExperimentalMaterialApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        FileOperator.init(this.application, BuildConfig.DEBUG)
       //PersionUtil.verifyStoragePermissions(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !isRefuse) {// android 11  且 不是已经被拒绝
            // 先判断有没有权限
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.data = Uri.parse("package:$packageName");
                startActivityForResult(intent, 1024);
            }
        }

        super.onCreate(savedInstanceState)
        //页面的开始
        setContent {
            ToDoListTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    //用navigation进行页面调整
                    navController = rememberNavController()
                    ToDoNavigation(
                        navHostController = navController,
                        toDoViewModel = toDoViewModel
                    )
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1024 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 检查是否有权限
            isRefuse = !Environment.isExternalStorageManager()
        }
    }


}
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val context = LocalContext.current
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "AlarmManager Notification",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Set Alarm Time : 10 Seconds",
                                modifier = Modifier
                                    .padding(10.dp),
                                fontSize = 16.sp
                            )
                            Button(
                                onClick = {
                                    addAlarm(
                                        context,
                                        toDoTask = ToDoTask(1, "fasfdw", "dwqdasf", 10000, true)
                                    )
                                }
                            ) {
                                Text(text = "Set Alarm")
                            }
                            Button(
                                onClick = {
                                    addAlarm(
                                        context,
                                        toDoTask = ToDoTask(1, "11111", "22222", 10000, true)
                                    )
                                }
                            ) {
                                Text(text = "Set Alarm 2")
                            }
                            Button(
                                onClick = {
                                    cancelAlarm(
                                        context,
                                        toDoTask = ToDoTask(1, "fasfdw", "dwqdasf", 10000, true)
                                    )
                                }
                            ) {
                                Text(text = "Cancel Alarm")
                            }
                        }
                    }
                }
            }
        }
    }
}
*/


/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToDoListTheme {
        Greeting("Android")
    }
}*/
