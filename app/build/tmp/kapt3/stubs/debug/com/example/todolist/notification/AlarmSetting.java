package com.example.todolist.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/example/todolist/notification/AlarmSetting;", "", "()V", "tasklist", "", "", "Landroid/app/PendingIntent;", "getTasklist", "()Ljava/util/Map;", "setTasklist", "(Ljava/util/Map;)V", "timeList", "", "getTimeList", "setTimeList", "addAlarm", "", "context", "Landroid/content/Context;", "toDoTask", "Lcom/example/todolist/database/model/ToDoTask;", "cancelAlarm", "app_debug"})
public final class AlarmSetting {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.todolist.notification.AlarmSetting INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static java.util.Map<java.lang.Integer, android.app.PendingIntent> tasklist;
    @org.jetbrains.annotations.NotNull()
    private static java.util.Map<java.lang.Integer, java.lang.Long> timeList;
    
    private AlarmSetting() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, android.app.PendingIntent> getTasklist() {
        return null;
    }
    
    public final void setTasklist(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, android.app.PendingIntent> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Integer, java.lang.Long> getTimeList() {
        return null;
    }
    
    public final void setTimeList(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Integer, java.lang.Long> p0) {
    }
    
    @android.annotation.SuppressLint(value = {"UnspecifiedImmutableFlag"})
    public final void addAlarm(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask) {
    }
    
    public final void cancelAlarm(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask) {
    }
}