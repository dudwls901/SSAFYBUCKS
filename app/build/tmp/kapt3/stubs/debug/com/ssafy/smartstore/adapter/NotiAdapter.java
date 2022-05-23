package com.ssafy.smartstore.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/ssafy/smartstore/adapter/NotiAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ssafy/smartstore/data/local/dto/Noti;", "Lcom/ssafy/smartstore/adapter/NotiAdapter$ItemViewHolder;", "notiDeleteClickListener", "Lcom/ssafy/smartstore/listener/NotiDeleteClickListener;", "(Lcom/ssafy/smartstore/listener/NotiDeleteClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemViewHolder", "app_debug"})
public final class NotiAdapter extends androidx.recyclerview.widget.ListAdapter<com.ssafy.smartstore.data.local.dto.Noti, com.ssafy.smartstore.adapter.NotiAdapter.ItemViewHolder> {
    private final com.ssafy.smartstore.listener.NotiDeleteClickListener notiDeleteClickListener = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.adapter.NotiAdapter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.data.local.dto.Noti> diffUtil = null;
    
    public NotiAdapter(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.listener.NotiDeleteClickListener notiDeleteClickListener) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ssafy.smartstore.adapter.NotiAdapter.ItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.adapter.NotiAdapter.ItemViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/ssafy/smartstore/adapter/NotiAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ssafy/smartstore/databinding/RvNotiBinding;", "(Lcom/ssafy/smartstore/adapter/NotiAdapter;Lcom/ssafy/smartstore/databinding/RvNotiBinding;)V", "bind", "", "item", "Lcom/ssafy/smartstore/data/local/dto/Noti;", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.ssafy.smartstore.databinding.RvNotiBinding binding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.databinding.RvNotiBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.data.local.dto.Noti item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/ssafy/smartstore/adapter/NotiAdapter$Companion;", "", "()V", "diffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/ssafy/smartstore/data/local/dto/Noti;", "getDiffUtil", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.data.local.dto.Noti> getDiffUtil() {
            return null;
        }
    }
}