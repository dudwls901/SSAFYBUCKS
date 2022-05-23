package com.ssafy.smartstore.view.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020$0#H\u0002J\u0006\u0010%\u001a\u00020!J\b\u0010&\u001a\u00020!H\u0002J\b\u0010\'\u001a\u00020!H\u0002J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0018H\u0016J\u001a\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0016\u00104\u001a\u00020!2\f\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/ssafy/smartstore/view/home/ShoppingListFragment;", "Landroidx/fragment/app/Fragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/ssafy/smartstore/listener/ShoppingListDeleteClickListener;", "()V", "adapter", "Lcom/ssafy/smartstore/adapter/OrderDetailAdapter;", "application_id", "", "getApplication_id", "()Ljava/lang/String;", "binding", "Lcom/ssafy/smartstore/databinding/FragmentShoppingListBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "items", "", "Lkr/co/bootpay/model/Item;", "job", "Lkotlinx/coroutines/CompletableJob;", "orderName", "orderPrice", "", "orderViewModel", "Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "getOrderViewModel", "()Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "orderViewModel$delegate", "Lkotlin/Lazy;", "userId", "createDialog", "", "message", "", "", "goBootpayRequest", "initViews", "observeDatas", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onShoppingListDeleteClickListener", "productId", "onViewCreated", "view", "updateShoppingList", "shoppingList", "", "Lcom/ssafy/smartstore/model/OrderProduct;", "app_debug"})
public final class ShoppingListFragment extends androidx.fragment.app.Fragment implements kotlinx.coroutines.CoroutineScope, com.ssafy.smartstore.listener.ShoppingListDeleteClickListener {
    private final kotlinx.coroutines.CompletableJob job = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.coroutines.CoroutineContext coroutineContext = null;
    private java.lang.String userId;
    private com.ssafy.smartstore.databinding.FragmentShoppingListBinding binding;
    private com.ssafy.smartstore.adapter.OrderDetailAdapter adapter;
    private java.util.List<kr.co.bootpay.model.Item> items;
    private java.lang.String orderName;
    private int orderPrice = 0;
    private final kotlin.Lazy orderViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String application_id = "628718fbe38c300020ad1c04";
    
    public ShoppingListFragment() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApplication_id() {
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
    
    public final void goBootpayRequest() {
    }
    
    private final void observeDatas() {
    }
    
    private final void createDialog(java.util.Map<java.lang.String, ? extends java.lang.Object> message) {
    }
    
    private final void initViews() {
    }
    
    private final void updateShoppingList(java.util.List<com.ssafy.smartstore.model.OrderProduct> shoppingList) {
    }
    
    @java.lang.Override()
    public void onShoppingListDeleteClickListener(int productId) {
    }
}