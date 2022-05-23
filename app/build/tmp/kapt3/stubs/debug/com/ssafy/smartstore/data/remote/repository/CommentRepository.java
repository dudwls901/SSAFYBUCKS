package com.ssafy.smartstore.data.remote.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ%\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/ssafy/smartstore/data/remote/repository/CommentRepository;", "", "()V", "deleteComment", "Lretrofit2/Response;", "", "Lcom/ssafy/smartstore/data/remote/dto/Comment;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertComment", "comment", "(Lcom/ssafy/smartstore/data/remote/dto/Comment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchComments", "updateComment", "Companion", "app_debug"})
public final class CommentRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.data.remote.repository.CommentRepository.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.ssafy.smartstore.data.remote.repository.CommentRepository INSTANCE = null;
    
    public CommentRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchComments(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertComment(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.remote.dto.Comment comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateComment(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.remote.dto.Comment comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteComment(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ssafy/smartstore/data/remote/repository/CommentRepository$Companion;", "", "()V", "INSTANCE", "Lcom/ssafy/smartstore/data/remote/repository/CommentRepository;", "getINSTANCE", "()Lcom/ssafy/smartstore/data/remote/repository/CommentRepository;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ssafy.smartstore.data.remote.repository.CommentRepository getINSTANCE() {
            return null;
        }
    }
}