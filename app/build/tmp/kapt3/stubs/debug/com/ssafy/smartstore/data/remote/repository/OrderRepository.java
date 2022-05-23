package com.ssafy.smartstore.data.remote.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/ssafy/smartstore/data/remote/repository/OrderRepository;", "", "()V", "getOrderMonth", "Lretrofit2/Response;", "", "Lcom/ssafy/smartstore/data/remote/dto/OrderInfoResponse;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeOrder", "", "order", "Lcom/ssafy/smartstore/data/remote/dto/Order;", "(Lcom/ssafy/smartstore/data/remote/dto/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class OrderRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.data.remote.repository.OrderRepository.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.ssafy.smartstore.data.remote.repository.OrderRepository INSTANCE = null;
    
    public OrderRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOrderMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.remote.dto.OrderInfoResponse>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object makeOrder(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.remote.dto.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.Integer>> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ssafy/smartstore/data/remote/repository/OrderRepository$Companion;", "", "()V", "INSTANCE", "Lcom/ssafy/smartstore/data/remote/repository/OrderRepository;", "getINSTANCE", "()Lcom/ssafy/smartstore/data/remote/repository/OrderRepository;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ssafy.smartstore.data.remote.repository.OrderRepository getINSTANCE() {
            return null;
        }
    }
}