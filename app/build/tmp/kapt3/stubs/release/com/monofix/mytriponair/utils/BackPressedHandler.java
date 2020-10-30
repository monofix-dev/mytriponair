package com.monofix.mytriponair.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/monofix/mytriponair/utils/BackPressedHandler;", "", "()V", "backKeyPressedTime", "", "toast", "Landroid/widget/Toast;", "onBackPressedKillProcess", "", "activity", "Landroid/app/Activity;", "listener", "Lcom/monofix/mytriponair/utils/BackPressedHandlerListener;", "app_release"})
public final class BackPressedHandler {
    private static long backKeyPressedTime;
    private static android.widget.Toast toast;
    public static final com.monofix.mytriponair.utils.BackPressedHandler INSTANCE = null;
    
    public final void onBackPressedKillProcess(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void onBackPressedKillProcess(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    com.monofix.mytriponair.utils.BackPressedHandlerListener listener) {
    }
    
    private BackPressedHandler() {
        super();
    }
}