package com.ssafy.smartstore.data.remote.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\'\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/ssafy/smartstore/data/remote/api/CommentService;", "", "deleteComment", "Lretrofit2/Response;", "", "Lcom/ssafy/smartstore/data/remote/dto/Comment;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertComment", "comment", "(Lcom/ssafy/smartstore/data/remote/dto/Comment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchComments", "updateComment", "app_debug"})
public abstract interface CommentService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "comment/{id}")
    public abstract java.lang.Object searchComments(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "comment")
    public abstract java.lang.Object insertComment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.ssafy.smartstore.data.remote.dto.Comment comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PUT(value = "comment")
    public abstract java.lang.Object updateComment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.ssafy.smartstore.data.remote.dto.Comment comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.DELETE(value = "comment/{id}")
    public abstract java.lang.Object deleteComment(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>>> continuation);
}