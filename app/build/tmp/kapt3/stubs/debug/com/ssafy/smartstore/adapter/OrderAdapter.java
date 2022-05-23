package com.ssafy.smartstore.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0014\u0015\u0016B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/ssafy/smartstore/adapter/OrderAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ssafy/smartstore/data/local/dto/Product;", "Lcom/ssafy/smartstore/adapter/OrderAdapter$ItemViewHolder;", "()V", "itemOnClickListener", "Lcom/ssafy/smartstore/adapter/OrderAdapter$ItemOnClickListener;", "getItemOnClickListener", "()Lcom/ssafy/smartstore/adapter/OrderAdapter$ItemOnClickListener;", "setItemOnClickListener", "(Lcom/ssafy/smartstore/adapter/OrderAdapter$ItemOnClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemOnClickListener", "ItemViewHolder", "app_debug"})
public final class OrderAdapter extends androidx.recyclerview.widget.ListAdapter<com.ssafy.smartstore.data.local.dto.Product, com.ssafy.smartstore.adapter.OrderAdapter.ItemViewHolder> {
    public com.ssafy.smartstore.adapter.OrderAdapter.ItemOnClickListener itemOnClickListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.adapter.OrderAdapter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.data.local.dto.Product> diffUtil = null;
    
    public OrderAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.adapter.OrderAdapter.ItemOnClickListener getItemOnClickListener() {
        return null;
    }
    
    public final void setItemOnClickListener(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.adapter.OrderAdapter.ItemOnClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ssafy.smartstore.adapter.OrderAdapter.ItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.adapter.OrderAdapter.ItemViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/ssafy/smartstore/adapter/OrderAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ssafy/smartstore/databinding/RvMenuItemBinding;", "(Lcom/ssafy/smartstore/adapter/OrderAdapter;Lcom/ssafy/smartstore/databinding/RvMenuItemBinding;)V", "bind", "", "product", "Lcom/ssafy/smartstore/data/local/dto/Product;", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.ssafy.smartstore.databinding.RvMenuItemBinding binding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.databinding.RvMenuItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.data.local.dto.Product product) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/ssafy/smartstore/adapter/OrderAdapter$ItemOnClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "position", "", "app_debug"})
    public static abstract interface ItemOnClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/ssafy/smartstore/adapter/OrderAdapter$Companion;", "", "()V", "diffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/ssafy/smartstore/data/local/dto/Product;", "getDiffUtil", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.data.local.dto.Product> getDiffUtil() {
            return null;
        }
    }
}