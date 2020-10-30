package com.monofix.mytriponair.fcm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/monofix/mytriponair/fcm/FirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "handleNow", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "scheduleJob", "sendNotification", "messageBody", "sendRegistrationToServer", "app_release"})
public final class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    @java.lang.Override()
    public void onNewToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    /**
     * Schedule async work using WorkManager.
     */
    private final void scheduleJob() {
    }
    
    /**
     * Handle time allotted to BroadcastReceivers.
     */
    private final void handleNow() {
    }
    
    /**
     * 디바이스 토큰이 생성되거나 재생성 될 시 동작할 코드 작성
     */
    private final void sendRegistrationToServer(java.lang.String token) {
    }
    
    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private final void sendNotification(java.lang.String messageBody) {
    }
    
    public FirebaseMessagingService() {
        super();
    }
}