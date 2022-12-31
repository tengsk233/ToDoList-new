package com.example.todolist.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\'J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\'J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u0019\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/todolist/database/ToDoDao;", "", "addTask", "", "toDoTask", "Lcom/example/todolist/database/model/ToDoTask;", "(Lcom/example/todolist/database/model/ToDoTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllTasks", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "getAllTasks", "Lkotlinx/coroutines/flow/Flow;", "", "getDoneTasks", "getSelectedTask", "taskId", "", "getTaskByDay", "date", "", "getUndoneTasks", "searchDatabase", "searchQuery", "", "sortByNewTime", "sortByOldTime", "updateTask", "app_debug"})
public abstract interface ToDoDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table ORDER BY id ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getAllTasks();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table WHERE id = :taskId")
    public abstract kotlinx.coroutines.flow.Flow<com.example.todolist.database.model.ToDoTask> getSelectedTask(int taskId);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object addTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM todo_table")
    public abstract java.lang.Object deleteAllTasks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> searchDatabase(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table ORDER BY  time ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> sortByNewTime();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table ORDER BY time DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> sortByOldTime();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table WHERE status = 1")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getDoneTasks();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table WHERE status = 0")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getUndoneTasks();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM todo_table WHERE date(time/1000,\'unixepoch\')=date(:date/1000)")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getTaskByDay(long date);
}