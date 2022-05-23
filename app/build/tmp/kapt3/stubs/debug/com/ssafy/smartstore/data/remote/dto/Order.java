package com.ssafy.smartstore.data.remote.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!\u00a8\u0006."}, d2 = {"Lcom/ssafy/smartstore/data/remote/dto/Order;", "", "id", "", "userId", "", "orderTable", "orderTime", "Ljava/util/Date;", "complited", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;C)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;C)V", "(Ljava/lang/String;Ljava/lang/String;)V", "completed", "getCompleted", "()C", "setCompleted", "(C)V", "details", "", "Lcom/ssafy/smartstore/data/remote/dto/OrderDetail;", "getDetails", "()Ljava/util/List;", "setDetails", "(Ljava/util/List;)V", "getId", "()I", "setId", "(I)V", "getOrderTable", "()Ljava/lang/String;", "setOrderTable", "(Ljava/lang/String;)V", "getOrderTime", "()Ljava/util/Date;", "setOrderTime", "(Ljava/util/Date;)V", "stamp", "Lcom/ssafy/smartstore/data/local/dto/Stamp;", "getStamp", "()Lcom/ssafy/smartstore/data/local/dto/Stamp;", "setStamp", "(Lcom/ssafy/smartstore/data/local/dto/Stamp;)V", "getUserId", "setUserId", "app_debug"})
public final class Order {
    private int id = -1;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userId")
    private java.lang.String userId;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "orderTable")
    private java.lang.String orderTable;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date orderTime;
    private char completed = 'N';
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.ssafy.smartstore.data.remote.dto.OrderDetail> details;
    @org.jetbrains.annotations.Nullable()
    private com.ssafy.smartstore.data.local.dto.Stamp stamp;
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrderTable() {
        return null;
    }
    
    public final void setOrderTable(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getOrderTime() {
        return null;
    }
    
    public final void setOrderTime(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    public final char getCompleted() {
        return '\u0000';
    }
    
    public final void setCompleted(char p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ssafy.smartstore.data.remote.dto.OrderDetail> getDetails() {
        return null;
    }
    
    public final void setDetails(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ssafy.smartstore.data.remote.dto.OrderDetail> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ssafy.smartstore.data.local.dto.Stamp getStamp() {
        return null;
    }
    
    public final void setStamp(@org.jetbrains.annotations.Nullable()
    com.ssafy.smartstore.data.local.dto.Stamp p0) {
    }
    
    public Order(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String orderTable, @org.jetbrains.annotations.NotNull()
    java.util.Date orderTime, char complited) {
        super();
    }
    
    public Order(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String orderTable, @org.jetbrains.annotations.NotNull()
    java.util.Date orderTime, char complited) {
        super();
    }
    
    public Order(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String orderTable) {
        super();
    }
}