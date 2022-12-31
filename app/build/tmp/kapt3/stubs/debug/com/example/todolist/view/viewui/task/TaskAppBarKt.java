package com.example.todolist.view.viewui.task;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u001c\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u001c\u0010\u0007\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0016\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a$\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a$\u0010\u0010\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u001c\u0010\u0011\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a&\u0010\u0012\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u001c\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u00a8\u0006\u0015"}, d2 = {"AddAction", "", "onAddClicked", "Lkotlin/Function1;", "Lcom/example/todolist/utils/Action;", "BackAction", "onBackClicked", "CloseAction", "onCloseClicked", "DeleteAction", "onDeleteClicked", "Lkotlin/Function0;", "ExistingTaskAppBar", "selectedTask", "Lcom/example/todolist/database/model/ToDoTask;", "navigateToListScreen", "ExistingTaskAppBarActions", "NewTaskAppBar", "TaskAppBar", "UpdateAction", "onUpdateClicked", "app_debug"})
public final class TaskAppBarKt {
    
    @androidx.compose.runtime.Composable()
    public static final void TaskAppBar(@org.jetbrains.annotations.Nullable()
    com.example.todolist.database.model.ToDoTask selectedTask, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> navigateToListScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NewTaskAppBar(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> navigateToListScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BackAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> onBackClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AddAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> onAddClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ExistingTaskAppBar(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask selectedTask, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> navigateToListScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CloseAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> onCloseClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ExistingTaskAppBarActions(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.model.ToDoTask selectedTask, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> navigateToListScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DeleteAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void UpdateAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.todolist.utils.Action, kotlin.Unit> onUpdateClicked) {
    }
}