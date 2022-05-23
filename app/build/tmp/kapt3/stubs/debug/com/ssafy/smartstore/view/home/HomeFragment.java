package com.ssafy.smartstore.view.home;

import java.lang.System;

@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0017J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0016J\u001a\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0016\u00106\u001a\u00020#2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0002J\u0016\u0010:\u001a\u00020#2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020208H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/ssafy/smartstore/view/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/ssafy/smartstore/listener/OrderListClickListener;", "Lcom/ssafy/smartstore/listener/NotiDeleteClickListener;", "()V", "binding", "Lcom/ssafy/smartstore/databinding/FragmentHomeBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "homeViewModel", "Lcom/ssafy/smartstore/viewmodel/HomeViewModel;", "getHomeViewModel", "()Lcom/ssafy/smartstore/viewmodel/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "job", "Lkotlinx/coroutines/CompletableJob;", "notiAdapter", "Lcom/ssafy/smartstore/adapter/NotiAdapter;", "notiRepo", "Lcom/ssafy/smartstore/data/local/repository/NotiRepository;", "orderAdapter", "Lcom/ssafy/smartstore/adapter/OrderListAdapter;", "orderViewModel", "Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "getOrderViewModel", "()Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "orderViewModel$delegate", "userId", "", "userName", "initViews", "", "observeDatas", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNotiDeleteClickListener", "idx", "", "onOrderListCartClickListener", "orderInfo", "Lcom/ssafy/smartstore/model/OrderInfo;", "onOrderListClickListener", "onViewCreated", "view", "updateNotiList", "list", "", "Lcom/ssafy/smartstore/data/local/dto/Noti;", "updateOrderList", "orderInfoList", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, com.ssafy.smartstore.listener.OrderListClickListener, com.ssafy.smartstore.listener.NotiDeleteClickListener {
    private final kotlinx.coroutines.CompletableJob job = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    private java.lang.String userId;
    private java.lang.String userName;
    private com.ssafy.smartstore.databinding.FragmentHomeBinding binding;
    private com.ssafy.smartstore.adapter.OrderListAdapter orderAdapter;
    private com.ssafy.smartstore.adapter.NotiAdapter notiAdapter;
    private com.ssafy.smartstore.data.local.repository.NotiRepository notiRepo;
    private final kotlin.Lazy homeViewModel$delegate = null;
    private final kotlin.Lazy orderViewModel$delegate = null;
    
    public HomeFragment() {
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
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
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
    
    private final void initViews() {
    }
    
    private final void updateOrderList(java.util.List<com.ssafy.smartstore.model.OrderInfo> orderInfoList) {
    }
    
    private final void updateNotiList(java.util.List<com.ssafy.smartstore.data.local.dto.Noti> list) {
    }
    
    @java.lang.Override()
    public void onOrderListClickListener(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.model.OrderInfo orderInfo) {
    }
    
    @java.lang.Override()
    public void onOrderListCartClickListener(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.model.OrderInfo orderInfo) {
    }
    
    @java.lang.Override()
    public void onNotiDeleteClickListener(int idx) {
    }
}