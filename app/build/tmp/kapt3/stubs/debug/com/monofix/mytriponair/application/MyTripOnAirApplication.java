package com.monofix.mytriponair.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/monofix/mytriponair/application/MyTripOnAirApplication;", "Landroid/app/Application;", "()V", "TAG", "", "onCreate", "", "Companion", "app_debug"})
public final class MyTripOnAirApplication extends android.app.Application {
    private final java.lang.String TAG = "MyTripOnAirApplication";
    @org.jetbrains.annotations.NotNull()
    private static com.monofix.mytriponair.application.MyTripOnAirApplication instance;
    public static final boolean releaseMode = true;
    public static final boolean releaseServer = true;
    public static final boolean isDebug = false;
    public static final boolean isAPIDebug = false;
    public static final com.monofix.mytriponair.application.MyTripOnAirApplication.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public MyTripOnAirApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/monofix/mytriponair/application/MyTripOnAirApplication$Companion;", "", "()V", "<set-?>", "Lcom/monofix/mytriponair/application/MyTripOnAirApplication;", "instance", "getInstance", "()Lcom/monofix/mytriponair/application/MyTripOnAirApplication;", "setInstance", "(Lcom/monofix/mytriponair/application/MyTripOnAirApplication;)V", "isAPIDebug", "", "isDebug", "releaseMode", "releaseServer", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.monofix.mytriponair.application.MyTripOnAirApplication getInstance() {
            return null;
        }
        
        private final void setInstance(com.monofix.mytriponair.application.MyTripOnAirApplication p0) {
        }
        
        private Companion() {
            super();
        }
    }
}