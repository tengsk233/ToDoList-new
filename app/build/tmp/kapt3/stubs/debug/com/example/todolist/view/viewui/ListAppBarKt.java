package com.example.todolist.view.viewui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a@\u0010\b\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a.\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001aN\u0010\u0010\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001aF\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0015H\u0007\u00a8\u0006\u0017"}, d2 = {"DefaultListAppBar", "", "onSearchClicked", "Lkotlin/Function0;", "onDeleteAllConfirmed", "onExportClick", "onImportClick", "onShareClick", "DeleteAllAction", "ListAppBar", "toDoNotesViewModel", "Lcom/example/todolist/view/viewmodel/ToDoViewModel;", "searchAppBarState", "Lcom/example/todolist/utils/SearchAppBarState;", "searchTextState", "", "ListAppBarActions", "SearchAction", "SearchAppBar", "text", "onTextChange", "Lkotlin/Function1;", "onCloseClicked", "app_debug"})
public final class ListAppBarKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public static final void ListAppBar(@org.jetbrains.annotations.NotNull()
    com.example.todolist.view.viewmodel.ToDoViewModel toDoNotesViewModel, @org.jetbrains.annotations.NotNull()
    com.example.todolist.utils.SearchAppBarState searchAppBarState, @org.jetbrains.annotations.NotNull()
    java.lang.String searchTextState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onImportClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DefaultListAppBar(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearchClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllConfirmed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onExportClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onImportClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onShareClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ListAppBarActions(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearchClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllConfirmed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onExportClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onImportClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onShareClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SearchAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSearchClicked) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
    public static final void DeleteAllAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteAllConfirmed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onExportClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onImportClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onShareClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SearchAppBar(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onCloseClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSearchClicked) {
    }
}