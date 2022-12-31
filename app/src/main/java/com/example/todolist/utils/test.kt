package com.example.todolist.utils

import android.content.Context
import kotlin.Throws
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object test {
    /**
     * 将内容写入sd卡中
     * @param filename 要写入的文件名
     * @param content  待写入的内容
     * @throws IOException
     */
    @Throws(IOException::class)
    fun writeExternal(context: Context, filename: String, content: String) {

        //获取外部存储卡的可用状态
        var filename = filename
        val storageState = Environment.getExternalStorageState()

        //判断是否存在可用的的SD Card
        if (storageState == Environment.MEDIA_MOUNTED) {

            //路径： /storage/emulated/0/Android/data/com.yoryky.demo/cache/yoryky.txt
            filename = context.externalCacheDir!!.absolutePath + File.separator + filename
            val outputStream = FileOutputStream(filename)
            outputStream.write(content.toByteArray())
            outputStream.close()
        }
    }
}