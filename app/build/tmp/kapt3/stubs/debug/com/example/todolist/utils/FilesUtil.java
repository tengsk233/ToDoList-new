package com.example.todolist.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J \u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/example/todolist/utils/FilesUtil;", "", "()V", "readExternal", "", "context", "Landroid/content/Context;", "filename", "readInternal", "writeExternal", "Landroid/net/Uri;", "content", "writeInternal", "", "app_debug"})
public final class FilesUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.todolist.utils.FilesUtil INSTANCE = null;
    
    private FilesUtil() {
        super();
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final void writeInternal(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filename, @org.jetbrains.annotations.NotNull()
    java.lang.String content) throws java.io.IOException {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final java.lang.String readInternal(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filename) throws java.io.IOException {
        return null;
    }
    
    /**
     * 将内容写入sd卡中
     * @param filename 要写入的文件名
     * @param content  待写入的内容
     * @throws IOException
     */
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final android.net.Uri writeExternal(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filename, @org.jetbrains.annotations.NotNull()
    java.lang.String content) throws java.io.IOException {
        return null;
    }
    
    /**
     * 从sd card文件中读取数据
     * @param filename 待读取的sd card
     * @return
     * @throws IOException
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final java.lang.String readExternal(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String filename) throws java.io.IOException {
        return null;
    }
}