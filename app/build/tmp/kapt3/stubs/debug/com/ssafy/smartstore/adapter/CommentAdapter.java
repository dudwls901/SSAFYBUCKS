package com.ssafy.smartstore.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/ssafy/smartstore/adapter/CommentAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ssafy/smartstore/data/remote/dto/Comment;", "Lcom/ssafy/smartstore/adapter/CommentAdapter$ItemViewHolder;", "user_id", "", "(Ljava/lang/String;)V", "onItemClickListener", "Lcom/ssafy/smartstore/adapter/CommentAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/ssafy/smartstore/adapter/CommentAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/ssafy/smartstore/adapter/CommentAdapter$OnItemClickListener;)V", "getUser_id", "()Ljava/lang/String;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemViewHolder", "OnItemClickListener", "app_debug"})
public final class CommentAdapter extends androidx.recyclerview.widget.ListAdapter<com.ssafy.smartstore.data.remote.dto.Comment, com.ssafy.smartstore.adapter.CommentAdapter.ItemViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String user_id = null;
    public com.ssafy.smartstore.adapter.CommentAdapter.OnItemClickListener onItemClickListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.adapter.CommentAdapter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.data.remote.dto.Comment> diffUtil = null;
    
    public CommentAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUser_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.adapter.CommentAdapter.OnItemClickListener getOnItemClickListener() {
        return null;
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.adapter.CommentAdapter.OnItemClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ssafy.smartstore.adapter.CommentAdapter.ItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.adapter.CommentAdapter.ItemViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/ssafy/smartstore/adapter/CommentAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ssafy/smartstore/databinding/RvCommentBinding;", "(Lcom/ssafy/smartstore/adapter/CommentAdapter;Lcom/ssafy/smartstore/databinding/RvCommentBinding;)V", "bind", "", "comment", "Lcom/ssafy/smartstore/data/remote/dto/Comment;", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.ssafy.smartstore.databinding.RvCommentBinding binding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.databinding.RvCommentBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.data.remote.dto.Comment comment) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/ssafy/smartstore/adapter/CommentAdapter$OnItemClickListener;", "", "onDelete", "", "comment", "Lcom/ssafy/smartstore/data/remote/dto/Comment;", "position", "", "onUpdate", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onUpdate(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.data.remote.dto.Comment comment, int position);
        
        public abstract void onDelete(@org.jetbrains.annotations.NotNull()
        com.ssafy.smartstore.data.remote.dto.Comment comment, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/ssafy/smartstore/adapter/CommentAdapter$Companion;", "", "()V", "diffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/ssafy/smartstore/data/remote/dto/Comment;", "getDiffUtil", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ssafy.smartstore.data.remote.dto.Comment> getDiffUtil() {
            return null;
        }
    }
}