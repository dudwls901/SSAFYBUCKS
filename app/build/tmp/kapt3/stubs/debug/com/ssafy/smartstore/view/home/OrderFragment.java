package com.ssafy.smartstore.view.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0003J\b\u0010\"\u001a\u00020\u001cH\u0003J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020%H\u0003J\b\u0010&\u001a\u00020\u001cH\u0002J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u001cH\u0017J\b\u00100\u001a\u00020\u001cH\u0017J\u001a\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0016\u00103\u001a\u00020\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00067"}, d2 = {"Lcom/ssafy/smartstore/view/home/OrderFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "adapter", "Lcom/ssafy/smartstore/adapter/OrderAdapter;", "binding", "Lcom/ssafy/smartstore/databinding/FragmentOrderBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/CompletableJob;", "listener", "Landroid/location/LocationListener;", "locationManager", "Landroid/location/LocationManager;", "getLocationManager", "()Landroid/location/LocationManager;", "locationManager$delegate", "Lkotlin/Lazy;", "productViewModel", "Lcom/ssafy/smartstore/viewmodel/ProductViewModel;", "getProductViewModel", "()Lcom/ssafy/smartstore/viewmodel/ProductViewModel;", "productViewModel$delegate", "calculateDistance", "", "longitude", "", "latitude", "checkPermission", "getLastLocation", "getProviders", "initViews", "isPermitted", "", "observeDatas", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "updateListView", "list", "", "Lcom/ssafy/smartstore/data/local/dto/Product;", "app_debug"})
public final class OrderFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope {
    private final kotlinx.coroutines.CompletableJob job = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    private com.ssafy.smartstore.databinding.FragmentOrderBinding binding;
    private com.ssafy.smartstore.adapter.OrderAdapter adapter;
    private final kotlin.Lazy productViewModel$delegate = null;
    private final kotlin.Lazy locationManager$delegate = null;
    private final android.location.LocationListener listener = null;
    
    public OrderFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    private final com.ssafy.smartstore.viewmodel.ProductViewModel getProductViewModel() {
        return null;
    }
    
    private final android.location.LocationManager getLocationManager() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    public void onResume() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void observeDatas() {
    }
    
    private final void updateListView(java.util.List<com.ssafy.smartstore.data.local.dto.Product> list) {
    }
    
    private final void initViews() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getLastLocation() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getProviders() {
    }
    
    private final void calculateDistance(double longitude, double latitude) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final boolean isPermitted() {
        return false;
    }
    
    private final void checkPermission() {
    }
}