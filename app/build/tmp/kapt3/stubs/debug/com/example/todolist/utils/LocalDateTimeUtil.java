package com.example.todolist.utils;

import java.lang.System;

/**
 * @Author ：feiyang
 * @Date ：Created in 2019/5/15
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0007J\b\u0010\u0013\u001a\u00020\u000eH\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/example/todolist/utils/LocalDateTimeUtil;", "", "()V", "convertDateToString", "", "localDateTime", "Ljava/time/LocalDateTime;", "lo", "", "convertDateToStringYMD", "convertStringToDate", "time", "convertStringToDateYMD", "dayOfThisMonth", "Ljava/time/LocalDate;", "n", "", "endOfThisMonth", "firstDayOfThisMonth", "lastDayOfThisMonth", "startOfThisMonth", "app_debug"})
public final class LocalDateTimeUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.todolist.utils.LocalDateTimeUtil INSTANCE = null;
    
    private LocalDateTimeUtil() {
        super();
    }
    
    /**
     * @Description: long类型转换成日期
     *
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String convertDateToString(long lo) {
        return null;
    }
    
    /**
     * 将日期转换为字符串，格式为：yyyy-MM-dd HH:mm:ss
     * @param localDateTime
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final java.lang.String convertDateToString(@org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime localDateTime) {
        return null;
    }
    
    /**
     * 将日期转换为字符串，格式为：yyyy-MM-dd
     * @param localDateTime
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.lang.String convertDateToStringYMD(@org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime localDateTime) {
        return null;
    }
    
    /**
     * 将字符串转换为日期，格式为：yyyy-MM-dd HH:mm:ss
     * @param time
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDateTime convertStringToDate(@org.jetbrains.annotations.Nullable()
    java.lang.String time) {
        return null;
    }
    
    /**
     * 将字符串转换为日期，格式为：yyyy-MM-dd
     * @param time
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDateTime convertStringToDateYMD(@org.jetbrains.annotations.Nullable()
    java.lang.String time) {
        return null;
    }
    
    /**
     * 取本月第一天
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDate firstDayOfThisMonth() {
        return null;
    }
    
    /**
     * 取本月第N天
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDate dayOfThisMonth(int n) {
        return null;
    }
    
    /**
     * 取本月最后一天
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDate lastDayOfThisMonth() {
        return null;
    }
    
    /**
     * 取本月第一天的开始时间
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDateTime startOfThisMonth() {
        return null;
    }
    
    /**
     * 取本月最后一天的结束时间
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.O)
    public final java.time.LocalDateTime endOfThisMonth() {
        return null;
    }
}