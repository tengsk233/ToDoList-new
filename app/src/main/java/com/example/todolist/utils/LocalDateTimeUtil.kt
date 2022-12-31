package com.example.todolist.utils

import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import android.os.Build
import com.example.todolist.utils.LocalDateTimeUtil
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.*

/**
 * @Author ：feiyang
 * @Date ：Created in 2019/5/15
 */
object LocalDateTimeUtil {
    /**
     * @Description: long类型转换成日期
     *
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     */
    fun convertDateToString(lo: Long): String {
        val date = Date(lo)
        val sd = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sd.format(date)
    }

    /**
     * 将日期转换为字符串，格式为：yyyy-MM-dd HH:mm:ss
     * @param localDateTime
     * @return
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun convertDateToString(localDateTime: LocalDateTime?): String {
        @SuppressLint("NewApi", "LocalSuppress") val dtf =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return dtf.format(localDateTime)
    }

    /**
     * 将日期转换为字符串，格式为：yyyy-MM-dd
     * @param localDateTime
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun convertDateToStringYMD(localDateTime: LocalDateTime?): String {
        val dtf =
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return dtf.format(localDateTime)
    }

    /**
     * 将字符串转换为日期，格式为：yyyy-MM-dd HH:mm:ss
     * @param time
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun convertStringToDate(time: String?): LocalDateTime {
        val dft =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return LocalDateTime.parse(time, dft)
    }

    /**
     * 将字符串转换为日期，格式为：yyyy-MM-dd
     * @param time
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun convertStringToDateYMD(time: String?): LocalDateTime {
        val dft =
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return LocalDateTime.parse(time, dft)
    }

    /**
     * 取本月第一天
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun firstDayOfThisMonth(): LocalDate {
        val today = LocalDate.now()
        return today.with(TemporalAdjusters.firstDayOfMonth())
    }

    /**
     * 取本月第N天
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun dayOfThisMonth(n: Int): LocalDate {
        val today = LocalDate.now()
        return today.withDayOfMonth(n)
    }

    /**
     * 取本月最后一天
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun lastDayOfThisMonth(): LocalDate {
        val today = LocalDate.now()
        return today.with(TemporalAdjusters.lastDayOfMonth())
    }

    /**
     * 取本月第一天的开始时间
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun startOfThisMonth(): LocalDateTime {
        return LocalDateTime.of(firstDayOfThisMonth(), LocalTime.MIN)
    }

    /**
     * 取本月最后一天的结束时间
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun endOfThisMonth(): LocalDateTime {
        return LocalDateTime.of(lastDayOfThisMonth(), LocalTime.MAX)
    }
}