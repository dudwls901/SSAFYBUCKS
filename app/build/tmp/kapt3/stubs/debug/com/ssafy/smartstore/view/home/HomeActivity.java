package com.ssafy.smartstore.view.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020$H\u0002J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020AH\u0002J\b\u0010H\u001a\u00020AH\u0016J\b\u0010I\u001a\u00020AH\u0017J\u0012\u0010J\u001a\u00020A2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\b\u0010M\u001a\u00020AH\u0014J\u0012\u0010N\u001a\u00020A2\b\u0010O\u001a\u0004\u0018\u00010;H\u0014J\b\u0010P\u001a\u00020AH\u0014J\b\u0010Q\u001a\u00020AH\u0014J\b\u0010R\u001a\u00020AH\u0014J\u000e\u0010S\u001a\u00020A2\u0006\u0010O\u001a\u00020;J\b\u0010T\u001a\u00020AH\u0002J \u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020-2\u0006\u0010X\u001a\u00020\u0006H\u0003J\b\u0010Y\u001a\u00020AH\u0002J\b\u0010Z\u001a\u00020AH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\"\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020-0\u001aX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010=R\u000e\u0010>\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/ssafy/smartstore/view/home/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/altbeacon/beacon/BeaconConsumer;", "()V", "PERMISSIONS_CODE", "", "STORE_DISTANCE", "STORE_ID", "backButtonTime", "", "beaconManager", "Lorg/altbeacon/beacon/BeaconManager;", "binding", "Lcom/ssafy/smartstore/databinding/ActivityHomeBinding;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dialogView", "Landroid/app/Dialog;", "filters", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "homeViewModel", "Lcom/ssafy/smartstore/viewmodel/HomeViewModel;", "getHomeViewModel", "()Lcom/ssafy/smartstore/viewmodel/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "isOnDialog", "", "job", "Lkotlinx/coroutines/CompletableJob;", "navController", "Landroidx/navigation/NavController;", "needBLERequest", "nfcAdapter", "Landroid/nfc/NfcAdapter;", "notiData", "", "notiRepo", "Lcom/ssafy/smartstore/data/local/repository/NotiRepository;", "orderViewModel", "Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "getOrderViewModel", "()Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "orderViewModel$delegate", "pIent", "Landroid/app/PendingIntent;", "region", "Lorg/altbeacon/beacon/Region;", "requestBLEActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "requiredPermissions", "[Ljava/lang/String;", "userId", "userName", "initNFC", "", "initViews", "isEnableBLEService", "isYourBeacon", "beacon", "Lorg/altbeacon/beacon/Beacon;", "observeDatas", "onBackPressed", "onBeaconServiceConnect", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "processIntent", "requestEnableBLE", "showStoreDialog", "name", "img", "price", "startScan", "unConnectBLE", "app_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity implements kotlinx.coroutines.CoroutineScope, org.altbeacon.beacon.BeaconConsumer {
    private final kotlinx.coroutines.CompletableJob job = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    private android.app.Dialog dialogView;
    private boolean isOnDialog = false;
    private com.ssafy.smartstore.databinding.ActivityHomeBinding binding;
    private com.ssafy.smartstore.data.local.repository.NotiRepository notiRepo;
    private java.lang.String userId;
    private java.lang.String userName;
    private java.lang.String notiData;
    private final kotlin.Lazy homeViewModel$delegate = null;
    private final kotlin.Lazy orderViewModel$delegate = null;
    private androidx.navigation.NavController navController;
    private final int STORE_ID = 1;
    private final int STORE_DISTANCE = 10;
    private org.altbeacon.beacon.BeaconManager beaconManager;
    private final org.altbeacon.beacon.Region region = null;
    private android.bluetooth.BluetoothManager bluetoothManager;
    private android.bluetooth.BluetoothAdapter bluetoothAdapter;
    private boolean needBLERequest = true;
    private final int PERMISSIONS_CODE = 100;
    private final java.lang.String[] requiredPermissions = {"android.permission.ACCESS_FINE_LOCATION"};
    private android.nfc.NfcAdapter nfcAdapter;
    private android.app.PendingIntent pIent;
    private android.content.IntentFilter[] filters;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> requestBLEActivity = null;
    private long backButtonTime = 0L;
    
    public HomeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    private final com.ssafy.smartstore.viewmodel.HomeViewModel getHomeViewModel() {
        return null;
    }
    
    private final com.ssafy.smartstore.viewmodel.OrderViewModel getOrderViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void unConnectBLE() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onBeaconServiceConnect() {
    }
    
    private final boolean isYourBeacon(org.altbeacon.beacon.Beacon beacon) {
        return false;
    }
    
    private final void startScan() {
    }
    
    private final boolean isEnableBLEService() {
        return false;
    }
    
    private final void requestEnableBLE() {
    }
    
    private final void observeDatas() {
    }
    
    private final void initViews() {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    private final void initNFC() {
    }
    
    public final void processIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void showStoreDialog(java.lang.String name, java.lang.String img, int price) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}