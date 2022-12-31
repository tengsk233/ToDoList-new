package com.example.todolist.view.viewmodel;

import java.lang.System;

@kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u00106\u001a\u000207H\u0003J\b\u00108\u001a\u000207H\u0002J\u0010\u00109\u001a\u0002072\u0006\u0010:\u001a\u00020;H\u0002J\u0006\u0010<\u001a\u00020\u0018J\u0006\u0010\u0015\u001a\u000207J0\u0010=\u001a\n\u0012\u0004\u0012\u0002H>\u0018\u00010\b\"\u0004\b\u0000\u0010>2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u0002H>\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010\u001b\u001a\u000207J\u000e\u0010+\u001a\u0002072\u0006\u0010B\u001a\u00020\u001dJ\u0006\u00105\u001a\u000207J\u0018\u0010C\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;H\u0007J\u000e\u0010D\u001a\u0002072\u0006\u0010A\u001a\u00020\u0018J\u0010\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0007J\u000e\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020\u0018J\b\u0010J\u001a\u000207H\u0002J\u0010\u0010K\u001a\u0002072\b\u0010*\u001a\u0004\u0018\u00010\tJ\u0018\u0010K\u001a\u0002072\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020-J\u0010\u0010L\u001a\u0002072\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020\u0018J\u0006\u0010O\u001a\u00020-R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0012\"\u0004\b(\u0010)R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0016R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0012R\u0019\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0012R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0012R#\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0016\u00a8\u0006P"}, d2 = {"Lcom/example/todolist/view/viewmodel/ToDoViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/todolist/database/repositories/ToDoRepository;", "(Lcom/example/todolist/database/repositories/ToDoRepository;)V", "_allTasks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/todolist/utils/RequestState;", "", "Lcom/example/todolist/database/model/ToDoTask;", "_doneTasks", "_searchedTasks", "_selectedTask", "_undoneTasks", "action", "Landroidx/compose/runtime/MutableState;", "Lcom/example/todolist/utils/Action;", "getAction", "()Landroidx/compose/runtime/MutableState;", "allTasks", "Lkotlinx/coroutines/flow/StateFlow;", "getAllTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "description", "", "getDescription", "doneTasks", "getDoneTasks", "id", "", "getId", "searchAppBarState", "Lcom/example/todolist/utils/SearchAppBarState;", "getSearchAppBarState", "searchTextState", "getSearchTextState", "searchedTasks", "getSearchedTasks", "selectDay", "getSelectDay", "setSelectDay", "(Landroidx/compose/runtime/MutableState;)V", "selectedTask", "getSelectedTask", "status", "", "getStatus", "time", "", "getTime", "title", "getTitle", "undoneTasks", "getUndoneTasks", "addTask", "", "deleteAllTasks", "deleteTask", "context", "Landroid/content/Context;", "exportAllTask", "getDataList", "T", "clazz", "Ljava/lang/Class;", "string", "taskId", "handleDatabaseActions", "importTasks", "searchDatabaseByDate", "searchDate", "Ljava/time/LocalDateTime;", "searchDatabaseByString", "searchQuery", "updateTask", "updateTaskField", "updateTaskStatus", "updateTitle", "newTitle", "validateFields", "app_debug"})
public final class ToDoViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.todolist.database.repositories.ToDoRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<com.example.todolist.utils.Action> action = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Integer> id = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.String> title = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.String> description = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Long> time = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> status = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<com.example.todolist.utils.SearchAppBarState> searchAppBarState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.String> searchTextState = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Integer> selectDay;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> _searchedTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> searchedTasks = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> _allTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> allTasks = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.todolist.database.model.ToDoTask> _selectedTask = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.todolist.database.model.ToDoTask> selectedTask = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> _doneTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> doneTasks = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> _undoneTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> undoneTasks = null;
    
    @javax.inject.Inject()
    public ToDoViewModel(@org.jetbrains.annotations.NotNull()
    com.example.todolist.database.repositories.ToDoRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<com.example.todolist.utils.Action> getAction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Integer> getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Long> getTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<com.example.todolist.utils.SearchAppBarState> getSearchAppBarState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getSearchTextState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Integer> getSelectDay() {
        return null;
    }
    
    public final void setSelectDay(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> getSearchedTasks() {
        return null;
    }
    
    public final void searchDatabaseByString(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void searchDatabaseByDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime searchDate) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> getAllTasks() {
        return null;
    }
    
    public final void getAllTasks() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.todolist.database.model.ToDoTask> getSelectedTask() {
        return null;
    }
    
    public final void getSelectedTask(int taskId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> getDoneTasks() {
        return null;
    }
    
    public final void getDoneTasks() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.todolist.utils.RequestState<java.util.List<com.example.todolist.database.model.ToDoTask>>> getUndoneTasks() {
        return null;
    }
    
    public final void getUndoneTasks() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void addTask() {
    }
    
    private final void updateTask() {
    }
    
    private final void updateTaskStatus(boolean status) {
    }
    
    private final void deleteTask(android.content.Context context) {
    }
    
    private final void deleteAllTasks() {
    }
    
    public final void updateTaskField(@org.jetbrains.annotations.Nullable()
    com.example.todolist.database.model.ToDoTask selectedTask) {
    }
    
    public final void updateTaskField(@org.jetbrains.annotations.Nullable()
    com.example.todolist.database.model.ToDoTask selectedTask, boolean status) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void handleDatabaseActions(@org.jetbrains.annotations.NotNull()
    com.example.todolist.utils.Action action, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void updateTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String newTitle) {
    }
    
    public final boolean validateFields() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String exportAllTask() {
        return null;
    }
    
    private final <T extends java.lang.Object>java.util.List<T> getDataList(java.lang.Class<T> clazz, java.lang.String string) {
        return null;
    }
    
    public final void importTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String string) {
    }
}