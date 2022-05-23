package com.ssafy.smartstore;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/ssafy/smartstore/StoreApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class StoreApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.StoreApplication.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.ssafy.smartstore.StoreApplication INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String orderTable = "";
    private static boolean alertedBeaconDialog = false;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<com.google.android.libraries.places.api.model.Place> places;
    
    public StoreApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/ssafy/smartstore/StoreApplication$Companion;", "", "()V", "INSTANCE", "Lcom/ssafy/smartstore/StoreApplication;", "getINSTANCE", "()Lcom/ssafy/smartstore/StoreApplication;", "alertedBeaconDialog", "", "getAlertedBeaconDialog", "()Z", "setAlertedBeaconDialog", "(Z)V", "orderTable", "", "getOrderTable", "()Ljava/lang/String;", "setOrderTable", "(Ljava/lang/String;)V", "places", "Ljava/util/ArrayList;", "Lcom/google/android/libraries/places/api/model/Place;", "getPlaces", "()Ljava/util/ArrayList;", "setPlaces", "(Ljava/util/ArrayList;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ssafy.smartstore.StoreApplication getINSTANCE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getOrderTable() {
            return null;
        }
        
        public final void setOrderTable(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean getAlertedBeaconDialog() {
            return false;
        }
        
        public final void setAlertedBeaconDialog(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.google.android.libraries.places.api.model.Place> getPlaces() {
            return null;
        }
        
        public final void setPlaces(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.google.android.libraries.places.api.model.Place> p0) {
        }
    }
}