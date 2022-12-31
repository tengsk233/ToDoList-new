package com.example.todolist.utils

import android.content.Context
import android.net.Uri
import kotlin.Throws
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import java.io.*
import java.lang.StringBuilder
import java.net.URI

object FilesUtil {
    @Throws(IOException::class)
    fun writeInternal(context: Context, filename: String, content: String) {
        //获取文件在内存卡中files目录下的路径
        var filename = filename
        val file = context.filesDir
        //filename = file.absolutePath + File.separator + filename

        //打开文件输出流
        val outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE)

        val writer=BufferedWriter(OutputStreamWriter(outputStream))
        //写数据到文件中
        writer.use {
            it.write(content)
        }
    }

    @Throws(IOException::class)
    fun readInternal(context: Context, filename: String): String {
        var filename = filename
        val sb = StringBuilder("")

        //获取文件在内存卡中files目录下的路径
        val file = context.filesDir
        filename = file.absolutePath + File.separator + filename

        //打开文件输入流
        val inputStream = FileInputStream(filename)
        val buffer = ByteArray(1024)
        var len = inputStream.read(buffer)
        //读取文件内容
        while (len > 0) {
            sb.append(String(buffer, 0, len))

            //继续将数据放到buffer中
            len = inputStream.read(buffer)
        }
        //关闭输入流
        inputStream.close()
        return sb.toString()
    }

    /**
     * 将内容写入sd卡中
     * @param filename 要写入的文件名
     * @param content  待写入的内容
     * @throws IOException
     */
    @Throws(IOException::class)
    fun writeExternal(context: Context, filename: String, content: String): Uri? {

        //获取外部存储卡的可用状态
        var filename = filename
        val storageState = Environment.getExternalStorageState()

        //判断是否存在可用的的SD Card
        if (storageState == Environment.MEDIA_MOUNTED) {
            //路径： /storage/emulated/0/Android/data/com.yoryky.demo/cache/yoryky.txt
            filename = context.getExternalFilesDir(null)!!.absolutePath + File.separator + filename
            /*val outputStream = FileOutputStream(filename)
            outputStream.write(content.toByteArray())
            outputStream.close()*/
            val file=File(filename)
            file.appendText(content)
            Toast.makeText(context,"文件存储成功,存储路径为$filename",Toast.LENGTH_LONG).show()
            Log.d("xieru",content)
            return FileProvider.getUriForFile(context,context.packageName+".fileprovider",file)
        }
        else
            return null
    }

    /**
     * 从sd card文件中读取数据
     * @param filename 待读取的sd card
     * @return
     * @throws IOException
     */
    @Throws(IOException::class)
    fun readExternal(context: Context, filename: String): String {
        var filename = filename
        val sb = StringBuilder()
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            filename = Environment.getExternalStorageDirectory().absolutePath + File.separator + filename
            //打开文件输入流
            val inputStream = FileInputStream(filename)
            val reader=BufferedReader(InputStreamReader(inputStream))
            reader.use {
                reader.forEachLine {
                    sb.append(it)
                }
            }
        }
        Log.d("读取数据",sb.toString())
        return sb.toString()
    }
}