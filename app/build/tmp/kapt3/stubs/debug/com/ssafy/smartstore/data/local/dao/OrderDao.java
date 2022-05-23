package com.ssafy.smartstore.data.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/ssafy/smartstore/data/local/dao/OrderDao;", "", "delete", "", "orderId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "order", "Lcom/ssafy/smartstore/data/local/dto/Order;", "(Lcom/ssafy/smartstore/data/local/dto/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "select", "selectAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectByUser", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectWithDetail", "id", "update", "app_debug"})
public abstract interface OrderDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.local.dto.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.local.dto.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM t_order WHERE o_id = :orderId")
    public abstract java.lang.Object delete(int orderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM t_order WHERE o_id = :orderId")
    public abstract java.lang.Object select(int orderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ssafy.smartstore.data.local.dto.Order> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM t_order")
    public abstract java.lang.Object selectAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM t_order WHERE o_id = (SELECT o_id FROM t_order_detail WHERE d_id = :id )")
    public abstract java.lang.Object selectWithDetail(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ssafy.smartstore.data.local.dto.Order> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from t_order WHERE user_id = :userId ORDER BY order_time desc")
    public abstract java.lang.Object selectByUser(@org.jetbrains.annotations.Nullable()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.Order>> continuation);
}