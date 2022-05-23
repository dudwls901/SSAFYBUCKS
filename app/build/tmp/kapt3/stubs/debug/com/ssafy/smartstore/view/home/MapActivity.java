package com.ssafy.smartstore.view.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000eJ\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0010\u0010&\u001a\u00020#2\u0006\u0010\'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020#H\u0014J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\nJ\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/ssafy/smartstore/view/home/MapActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "FASTEST_UPDATE_INTERVAL", "", "UPDATE_INTERVAL", "binding", "Lcom/ssafy/smartstore/databinding/ActivityMapBinding;", "currentLocation", "Landroid/location/Location;", "currentMarker", "Lcom/google/android/gms/maps/model/Marker;", "currentPosition", "Lcom/google/android/gms/maps/model/LatLng;", "exMarker", "", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "setLocationCallback", "(Lcom/google/android/gms/location/LocationCallback;)V", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "checkPermission", "", "getCurrentAddress", "", "latlng", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "p0", "onStop", "setCurrentLocation", "location", "showPlaceInformation", "startLocationUpdates", "app_debug"})
public final class MapActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback {
    private com.ssafy.smartstore.databinding.ActivityMapBinding binding;
    private final int UPDATE_INTERVAL = 1000;
    private final int FASTEST_UPDATE_INTERVAL = 500;
    private com.google.android.gms.maps.GoogleMap map;
    private com.google.android.gms.maps.model.Marker currentMarker;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private com.google.android.gms.location.LocationRequest locationRequest;
    private android.location.Location currentLocation;
    private com.google.android.gms.maps.model.LatLng currentPosition;
    
    /**
     * places 검색 추가.
     */
    private java.util.Set<com.google.android.gms.maps.model.Marker> exMarker;
    @org.jetbrains.annotations.NotNull()
    private com.google.android.gms.location.LocationCallback locationCallback;
    
    public MapActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap p0) {
    }
    
    public final void setCurrentLocation(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
    }
    
    private final void startLocationUpdates() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.LocationCallback getLocationCallback() {
        return null;
    }
    
    public final void setLocationCallback(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.LocationCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentAddress(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng latlng) {
        return null;
    }
    
    private final void showPlaceInformation() {
    }
    
    private final boolean checkPermission() {
        return false;
    }
}