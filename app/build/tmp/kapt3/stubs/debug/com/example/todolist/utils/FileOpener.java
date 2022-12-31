package com.example.todolist.utils;

import java.lang.System;

/**
 * # FileOpener
 *
 * 打开该 Uri 对应文件类型的所有软件, 通常情况是个底部弹窗
 *
 * Open all the software corresponding to the file type of the Uri, usually it is a pop-up window at the bottom
 *
 * @author javakam
 * @date 2020/8/24 11:20
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0001\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006Jj\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\n2<\b\u0002\u0010\u0016\u001a6\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0007J \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u001e"}, d2 = {"Lcom/example/todolist/utils/FileOpener;", "", "()V", "createChooseIntent", "Landroid/content/Intent;", "mimeType", "", "extraMimeTypes", "", "multiSelect", "", "(Ljava/lang/String;[Ljava/lang/String;Z)Landroid/content/Intent;", "createOpenFileIntent", "uri", "Landroid/net/Uri;", "openBrowser", "", "context", "Landroid/content/Context;", "url", "title", "newTask", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "msg", "openShare", "openUrl", "app_debug"})
public final class FileOpener {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.todolist.utils.FileOpener INSTANCE = null;
    
    private FileOpener() {
        super();
    }
    
    /**
     * ### 直接打开 Url 对应的系统应用 (Open the system application corresponding to the URL directly)
     *
     * eg: 如果url是视频地址,则直接用系统的播放器打开 (If the url is the video address, open it directly with the system player)
     */
    public final void openUrl(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    /**
     * 打开系统分享弹窗 (Open the system sharing popup)
     */
    public final void openShare(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    /**
     * 打开浏览器 (Open browser)
     */
    @android.annotation.SuppressLint(value = {"QueryPermissionsNeeded"})
    public final void openBrowser(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String title, boolean newTask, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> block) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent createOpenFileIntent(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.lang.String mimeType) {
        return null;
    }
    
    /**
     * ### 选择文件【调用系统的文件管理】 (Select file [call system file management])
     *
     * 注:
     *
     * #### 1. Intent.setType 不能为空(Can not be empty) !
     * ```
     * android.content.ActivityNotFoundException: No Activity found to handle Intent { act=android.intent.action.OPEN_DOCUMENT cat=[android.intent.category.OPENABLE] (has extras) }
     * at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:2105)
     * ```
     *
     * #### 2. mimeTypes 会覆盖 mimeType (mimeTypes will override mimeType)
     * ```
     * eg:
     *     Intent.setType("image / *")
     *     Intent.putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("audio / *"))
     * 🍎 最终可选文件类型变为音频
     * ```
     *
     * #### 3. ACTION_GET_CONTENT, ACTION_OPEN_DOCUMENT 效果相同, Android Q 上使用 `ACTION_GET_CONTENT` 会出现:
     * ```
     *     java.lang.SecurityException: UID 10483 does not have permission to content://com.android.providers.media.documents/document/image%3A16012 [user 0];
     *     you could obtain access using ACTION_OPEN_DOCUMENT or related APIs
     * ```
     *
     * #### 4. 开启多选(Open multiple selection) resultCode = -1
     *
     * #### 5. 无论是`ACTION_OPEN_DOCUMENT`还是`ACTION_GET_CONTENT`都只是负责打开和选择,
     * 具体的文件操作如查看文件内容,删除,分享,复制,重命名等操作需要在`onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)`中的`data:Intent`中提取
     *
     * #### 6. 不使用ACTION_GET_CONTENT的另外一个原因: https://stackoverflow.com/questions/50386916/select-specific-file-types-using-action-get-content-and-settype-or-intent-extra
     *
     * #### 7. 可以使用返回的Intent设置临时权限 Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION
     *
     * #### 8. extraMimeTypes 必须要用 Array 类型的, 否则打开的文件管理器后只显示"最近"一个页面 !
     */
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent createChooseIntent(@org.jetbrains.annotations.Nullable()
    @androidx.annotation.NonNull()
    java.lang.String mimeType, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    java.lang.String[] extraMimeTypes, boolean multiSelect) {
        return null;
    }
}