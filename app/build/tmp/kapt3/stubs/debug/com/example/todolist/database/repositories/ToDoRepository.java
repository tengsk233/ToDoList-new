package com.example.todolist.database.repositories;

import java.lang.System;

@dagger.hilt.android.scopes.ViewModelScoped()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010!\u001a\u00020\"J\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010$\u001a\u00020%J\u0019\u0010&\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/example/todolist/database/repositories/ToDoRepository;", "", "toDoDao", "Lcom/example/todolist/database/ToDoDao;", "(Lcom/example/todolist/database/ToDoDao;)V", "getAllTasks", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/todolist/database/model/ToDoTask;", "getGetAllTasks", "()Lkotlinx/coroutines/flow/Flow;", "getDoneTasks", "getGetDoneTasks", "getUndoneTasks", "getGetUndoneTasks", "sortByNewTime", "getSortByNewTime", "sortByOldTime", "getSortByOldTime", "addTask", "", "toDoTask", "(Lcom/example/todolist/database/model/ToDoTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTasks", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllTasks", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "getSelectedTask", "taskId", "", "searchDatabaseByDate", "date", "", "searchDatabaseByName", "searchQuery", "", "updateTask", "app_debug"})
public final class ToDoRepository {
    private final com.example.todolist.database.ToDoDao toDoDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getAllTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> sortByNewTime = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> sortByOldTime = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getDoneTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getUndoneTasks = null;
    
    @javax.inject.Inject()
    public ToDoRepository(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.ToDoDao toDoDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getGetAllTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getSortByNewTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getSortByOldTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getGetDoneTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> getGetUndoneTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> searchDatabaseByDate(long date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.todolist.database.model.ToDoTask> getSelectedTask(int taskId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addTasks(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.todolist.database.model.ToDoTask> list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask toDoTask, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllTasks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todolist.database.model.ToDoTask>> searchDatabaseByName(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery) {
        return null;
    }
}