package com.example.todolist.view.viewui.calender;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a,\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a,\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u000e"}, d2 = {"Calendar", "", "selectDay", "", "move", "Lkotlin/Function1;", "dayClick", "Ljava/time/MonthDay;", "Day", "day", "Month", "month", "Ljava/time/Month;", "monthDayClick", "app_debug"})
public final class CalenderKt {
    
    @androidx.compose.runtime.Composable()
    public static final void Day(int day, int selectDay, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> dayClick) {
    }
    
    /**
     * @param selectDay 动态更新
     * @param monthDayClick 点击高亮
     * LazyVerticalGrid是用来写网格列表，GridCells.Fixed(6)就是每行6个
     * month.length(true) 返回月份的天数，true则代表闰年
     */
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public static final void Month(@org.jetbrains.annotations.NotNull()
    java.time.Month month, int selectDay, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.MonthDay, kotlin.Unit> monthDayClick) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public static final void Calendar(int selectDay, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> move, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.MonthDay, kotlin.Unit> dayClick) {
    }
}