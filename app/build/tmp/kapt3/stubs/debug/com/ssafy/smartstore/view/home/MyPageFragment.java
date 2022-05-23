package com.ssafy.smartstore.view.home;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010\'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0013H\u0016J\u0010\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0013H\u0016J\u001a\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/ssafy/smartstore/view/home/MyPageFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/ssafy/smartstore/listener/OrderListClickListener;", "()V", "adapter", "Lcom/ssafy/smartstore/adapter/OrderListAdapter;", "binding", "Lcom/ssafy/smartstore/databinding/FragmentMyPageBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "editor", "Landroid/content/SharedPreferences$Editor;", "job", "Lkotlinx/coroutines/CompletableJob;", "orderInfoList", "", "Lcom/ssafy/smartstore/model/OrderInfo;", "orderViewModel", "Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "getOrderViewModel", "()Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "orderViewModel$delegate", "Lkotlin/Lazy;", "prefs", "Landroid/content/SharedPreferences;", "userInfo", "", "", "", "user_id", "getOrderInfoList", "", "getUserInfo", "initListView", "initOrderList", "initViews", "logout", "observeDatas", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOrderListCartClickListener", "orderInfo", "onOrderListClickListener", "onViewCreated", "view", "app_debug"})
public final class MyPageFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, com.ssafy.smartstore.listener.OrderListClickListener {
    private final kotlinx.coroutines.CompletableJob job = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    private com.ssafy.smartstore.databinding.FragmentMyPageBinding binding;
    private com.ssafy.smartstore.adapter.OrderListAdapter adapter;
    private java.util.Map<java.lang.String, ? extends java.lang.Object> userInfo;
    private android.content.SharedPreferences prefs;
    private android.content.SharedPreferences.Editor editor;
    private java.util.List<com.ssafy.smartstore.model.OrderInfo> orderInfoList;
    private java.lang.String user_id = "";
    private final kotlin.Lazy orderViewModel$delegate = null;
    
    public MyPageFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    private final com.ssafy.smartstore.viewmodel.OrderViewModel getOrderViewModel() {
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
    
    private final void observeDatas() {
    }
    
    private final void logout() {
    }
    
    private final void initViews() {
    }
    
    private final void getOrderInfoList() {
    }
    
    private final void initOrderList() {
    }
    
    private final void getUserInfo() {
    }
    
    private final void initListView() {
    }
    
    @java.lang.Override()
    public void onOrderListClickListener(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.model.OrderInfo orderInfo) {
    }
    
    @java.lang.Override()
    public void onOrderListCartClickListener(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.model.OrderInfo orderInfo) {
    }
}