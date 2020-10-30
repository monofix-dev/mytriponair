package com.monofix.mytriponair.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u009d\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r\u001aU\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r\u001a\u0086\u0001\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r\u00a8\u0006\u001e"}, d2 = {"openNewTabWindow", "", "context", "Landroid/content/Context;", "url", "", "showEventPopup", "Landroidx/appcompat/app/AlertDialog;", "imageURL", "imgWidth", "", "imgHeight", "actionEvent", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "Lkotlin/ParameterName;", "name", "dialog", "actionClose", "actionCloseToday", "showOneButtonDialog", "title", "desc", "confirm", "isCancellable", "", "confirmListener", "showTwoButtonDialog", "cancel", "cancelListener", "app_debug"})
public final class DialogExtensionKt {
    
    public static final void showOneButtonDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String confirm, boolean isCancellable, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.content.DialogInterface, kotlin.Unit> confirmListener) {
    }
    
    public static final void showTwoButtonDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String confirm, @org.jetbrains.annotations.NotNull()
    java.lang.String cancel, boolean isCancellable, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.content.DialogInterface, kotlin.Unit> confirmListener, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.content.DialogInterface, kotlin.Unit> cancelListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.appcompat.app.AlertDialog showEventPopup(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String imageURL, int imgWidth, int imgHeight, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.content.DialogInterface, kotlin.Unit> actionEvent, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.content.DialogInterface, kotlin.Unit> actionClose, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.content.DialogInterface, kotlin.Unit> actionCloseToday) {
        return null;
    }
    
    public static final void openNewTabWindow(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
}