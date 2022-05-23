package com.ssafy.smartstore.data.local.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\u0006\u0010\u001b\u001a\u00020\u0017H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J%\u0010!\u001a\u00020\u00102\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010#H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00142\u0006\u0010*\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010+\u001a\u00020,2\u0006\u0010\u001f\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/ssafy/smartstore/data/local/repository/OrderRepository;", "", "()V", "db", "Lcom/ssafy/smartstore/data/local/database/StoreDatabase;", "oDao", "Lcom/ssafy/smartstore/data/local/dao/OrderDao;", "odDao", "Lcom/ssafy/smartstore/data/local/dao/OrderDetailDao;", "pDao", "Lcom/ssafy/smartstore/data/local/dao/ProductDao;", "sDao", "Lcom/ssafy/smartstore/data/local/dao/StampDao;", "uDao", "Lcom/ssafy/smartstore/data/local/dao/UserDao;", "delete", "", "orderId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderByUser", "", "Lcom/ssafy/smartstore/data/local/dto/Order;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderInfoList", "Lcom/ssafy/smartstore/model/OrderInfo;", "userId", "getOrderWithDetails", "insert", "", "order", "(Lcom/ssafy/smartstore/data/local/dto/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeOrder", "orderInfo", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "select", "selectAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectOrderTotalInfo", "Lcom/ssafy/smartstore/data/local/dto/OrderDetail;", "productId", "updateOrder", "", "Companion", "app_debug"})
public final class OrderRepository {
    private final com.ssafy.smartstore.data.local.database.StoreDatabase db = null;
    private final com.ssafy.smartstore.data.local.dao.OrderDao oDao = null;
    private final com.ssafy.smartstore.data.local.dao.OrderDetailDao odDao = null;
    private final com.ssafy.smartstore.data.local.dao.StampDao sDao = null;
    private final com.ssafy.smartstore.data.local.dao.UserDao uDao = null;
    private final com.ssafy.smartstore.data.local.dao.ProductDao pDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.data.local.repository.OrderRepository.Companion Companion = null;
    private static com.ssafy.smartstore.data.local.repository.OrderRepository INSTANCE;
    
    public OrderRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    public final java.lang.Object getOrderInfoList(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.model.OrderInfo>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object makeOrder(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> orderInfo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOrderWithDetails(int orderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ssafy.smartstore.data.local.dto.Order> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOrderByUser(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.Order>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateOrder(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.local.dto.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object selectOrderTotalInfo(int productId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.OrderDetail>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.local.dto.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(int orderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object select(int orderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ssafy.smartstore.data.local.dto.Order> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object selectAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.Order>> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/ssafy/smartstore/data/local/repository/OrderRepository$Companion;", "", "()V", "INSTANCE", "Lcom/ssafy/smartstore/data/local/repository/OrderRepository;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ssafy.smartstore.data.local.repository.OrderRepository getInstance() {
            return null;
        }
    }
}