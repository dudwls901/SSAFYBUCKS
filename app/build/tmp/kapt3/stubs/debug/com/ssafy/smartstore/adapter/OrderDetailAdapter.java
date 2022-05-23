package com.ssafy.smartstore.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/ssafy/smartstore/adapter/OrderDetailAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ssafy/smartstore/model/OrderProduct;", "Lcom/ssafy/smartstore/adapter/OrderDetailAdapter$ItemViewHolder;", "state", "", "shoppingListDeleteClickListener", "Lcom/ssafy/smartstore/listener/ShoppingListDeleteClickListener;", "(Ljava/lang/String;Lcom/ssafy/smartstore/listener/ShoppingListDeleteClickListener;)V", "getShoppingListDeleteClickListener", "()Lcom/ssafy/smartstore/listener/ShoppingListDeleteClickListener;", "getState", "()Ljava/lang/String;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemViewHolder", "app_debug"})
public final class OrderDetailAdapter extends androidx.recyclerview.widget.ListAdapter<com.ssafy.smartstore.model.OrderProduct, com.ssafy.smartstore.adapter.OrderDetailAdapter.ItemViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String state = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ssafy.smartstore.listener.ShoppingListDeleteClickListener shoppingListDeleteClickListener = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.adapter.OrderDetailAdapter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.model.OrderProduct> diffUtil = null;
    
    public OrderDetailAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.listener.ShoppingListDeleteClickListener shoppingListDeleteClickListener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.listener.ShoppingListDeleteClickListener getShoppingListDeleteClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ssafy.smartstore.adapter.OrderDetailAdapter.ItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.adapter.OrderDetailAdapter.ItemViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/ssafy/smartstore/adapter/OrderDetailAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ssafy/smartstore/databinding/RvOrderDetailBinding;", "(Lcom/ssafy/smartstore/adapter/OrderDetailAdapter;Lcom/ssafy/smartstore/databinding/RvOrderDetailBinding;)V", "bind", "", "orderProduct", "Lcom/ssafy/smartstore/model/OrderProduct;", "position", "", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.ssafy.smartstore.databinding.RvOrderDetailBinding binding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.databinding.RvOrderDetailBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.model.OrderProduct orderProduct, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/ssafy/smartstore/adapter/OrderDetailAdapter$Companion;", "", "()V", "diffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/ssafy/smartstore/model/OrderProduct;", "getDiffUtil", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.model.OrderProduct> getDiffUtil() {
            return null;
        }
    }
}