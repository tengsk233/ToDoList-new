package com.example.todolist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/example/todolist/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "isRefuse", "", "navController", "Landroidx/navigation/NavHostController;", "toDoViewModel", "Lcom/example/todolist/view/viewmodel/ToDoViewModel;", "getToDoViewModel", "()Lcom/example/todolist/view/viewmodel/ToDoViewModel;", "toDoViewModel$delegate", "Lkotlin/Lazy;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.activity.ComponentActivity {
    private androidx.navigation.NavHostController navController;
    private final kotlin.Lazy toDoViewModel$delegate = null;
    private boolean isRefuse = false;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.todolist.view.viewmodel.ToDoViewModel getToDoViewModel() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}