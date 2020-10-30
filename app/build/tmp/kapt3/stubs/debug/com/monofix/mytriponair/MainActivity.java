package com.monofix.mytriponair;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0003J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J-\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070!2\u0006\u0010\"\u001a\u00020#H\u0016\u00a2\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/monofix/mytriponair/MainActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "childWebViews", "", "Landroid/webkit/WebView;", "deepLinkUrl", "", "getDeepLinkUrl", "()Ljava/lang/String;", "setDeepLinkUrl", "(Ljava/lang/String;)V", "isLaunchByPushMessage", "", "()Z", "setLaunchByPushMessage", "(Z)V", "parentLayout", "Landroid/view/ViewGroup;", "webViewClient", "Landroid/webkit/WebViewClient;", "configureWebView", "", "webView", "initWebView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "resortToFallbackUrl", "intent", "Landroid/content/Intent;", "setStatusBar", "Companion", "ParentWebChromeClient", "app_debug"})
public final class MainActivity extends androidx.fragment.app.FragmentActivity {
    private java.util.List<android.webkit.WebView> childWebViews;
    private android.view.ViewGroup parentLayout;
    private android.webkit.WebViewClient webViewClient;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deepLinkUrl;
    private boolean isLaunchByPushMessage;
    private static final java.lang.String TAG = "MainActivity";
    public static final com.monofix.mytriponair.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeepLinkUrl() {
        return null;
    }
    
    public final void setDeepLinkUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isLaunchByPushMessage() {
        return false;
    }
    
    public final void setLaunchByPushMessage(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setStatusBar() {
    }
    
    private final void initWebView() {
    }
    
    /**
     * 웹뷰 기본 설정 메소드
     */
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    private final void configureWebView(android.webkit.WebView webView) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    /**
     * 브라우저에서 들어온 intent 에서 browser_fallback_url 을 찾아서 실행시키는 메소드
     * fallback url validation 은 따로하지 않는데, 필요하면 해야함.
     *
     * @return true if webView loaded fallback url, false otherwise
     */
    private final boolean resortToFallbackUrl(android.webkit.WebView webView, android.content.Intent intent) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public MainActivity() {
        super();
    }
    
    /**
     * 팝업 처리를 해주기 위하여 필요한 WebChromeClient 상속체
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J,\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/monofix/mytriponair/MainActivity$ParentWebChromeClient;", "Landroid/webkit/WebChromeClient;", "parent", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Lcom/monofix/mytriponair/MainActivity;Landroid/view/ViewGroup;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getParent", "()Landroid/view/ViewGroup;", "onCreateWindow", "", "view", "Landroid/webkit/WebView;", "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "onGeolocationPermissionsHidePrompt", "", "onGeolocationPermissionsShowPrompt", "origin", "", "callback", "Landroid/webkit/GeolocationPermissions$Callback;", "app_debug"})
    final class ParentWebChromeClient extends android.webkit.WebChromeClient {
        @org.jetbrains.annotations.NotNull()
        private final android.view.ViewGroup parent = null;
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        
        /**
         * Javascript 상에서 window.open() 호출 시 호출되는 메소드. 팝업 용 웹뷰를 만들고 parent view group 에 추가해야 한다.
         * WebViewTransport 를 통하여 parent 웹뷰에 child 웹뷰를 전달해야 함.
         */
        @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
        @java.lang.Override()
        public boolean onCreateWindow(@org.jetbrains.annotations.Nullable()
        android.webkit.WebView view, boolean isDialog, boolean isUserGesture, @org.jetbrains.annotations.Nullable()
        android.os.Message resultMsg) {
            return false;
        }
        
        @java.lang.Override()
        public void onGeolocationPermissionsHidePrompt() {
        }
        
        @java.lang.Override()
        public void onGeolocationPermissionsShowPrompt(@org.jetbrains.annotations.Nullable()
        java.lang.String origin, @org.jetbrains.annotations.Nullable()
        android.webkit.GeolocationPermissions.Callback callback) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.ViewGroup getParent() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        public ParentWebChromeClient(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/monofix/mytriponair/MainActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}