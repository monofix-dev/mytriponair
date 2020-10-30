package com.monofix.mytriponair.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/monofix/mytriponair/utils/SystemUtils;", "", "()V", "Companion", "app_release"})
public final class SystemUtils {
    public static final com.monofix.mytriponair.utils.SystemUtils.Companion Companion = null;
    
    public SystemUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0006\u00a8\u0006\u001c"}, d2 = {"Lcom/monofix/mytriponair/utils/SystemUtils$Companion;", "", "()V", "displayCount", "", "count", "", "dpToPixels", "c", "Landroid/content/Context;", "dp", "getAppVersionCode", "getAppVersionName", "getCurrentTimezoneOffset", "getDeviceCountryCode", "getDeviceDpi", "getDeviceInch", "", "getDeviceLanguageCode", "getDeviceLocale", "Ljava/util/Locale;", "context", "getRandomCode", "length", "getScreenHeight", "getScreenWidth", "pixelsToDp", "pixel", "app_release"})
    public static final class Companion {
        
        public final int getScreenWidth() {
            return 0;
        }
        
        public final int getScreenHeight() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAppVersionName() {
            return null;
        }
        
        public final int getAppVersionCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDeviceCountryCode() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDeviceLanguageCode() {
            return null;
        }
        
        public final int getDeviceDpi() {
            return 0;
        }
        
        public final int dpToPixels(@org.jetbrains.annotations.NotNull()
        android.content.Context c, int dp) {
            return 0;
        }
        
        public final int pixelsToDp(@org.jetbrains.annotations.NotNull()
        android.content.Context c, int pixel) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCurrentTimezoneOffset() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Locale getDeviceLocale(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRandomCode(int length) {
            return null;
        }
        
        public final double getDeviceInch() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String displayCount(int count) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}