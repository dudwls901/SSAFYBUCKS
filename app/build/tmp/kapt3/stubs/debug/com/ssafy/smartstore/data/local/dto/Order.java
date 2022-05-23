package com.ssafy.smartstore.data.local.dto;

import java.lang.System;

@androidx.room.Entity(tableName = "t_order", foreignKeys = {@androidx.room.ForeignKey(entity = com.ssafy.smartstore.data.local.dto.User.class, childColumns = {"user_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J1\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J\t\u0010)\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001b\"\u0004\b\u001e\u0010\u001f\u00a8\u0006*"}, d2 = {"Lcom/ssafy/smartstore/data/local/dto/Order;", "", "id", "", "user_id", "", "order_table", "order_time", "completed", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;C)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;C)V", "getCompleted", "()C", "details", "", "Lcom/ssafy/smartstore/data/local/dto/OrderDetail;", "getDetails", "()Ljava/util/List;", "setDetails", "(Ljava/util/List;)V", "o_id", "getO_id", "()I", "setO_id", "(I)V", "getOrder_table", "()Ljava/lang/String;", "getOrder_time", "getUser_id", "setUser_id", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Order {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String user_id;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String order_table = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    private final java.lang.String order_time = null;
    @androidx.room.ColumnInfo(defaultValue = "N")
    private final char completed = '\u0000';
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int o_id = 0;
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Transient()
    private transient java.util.List<com.ssafy.smartstore.data.local.dto.OrderDetail> details;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.local.dto.Order copy(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    java.lang.String order_table, @org.jetbrains.annotations.NotNull()
    java.lang.String order_time, char completed) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Order(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    java.lang.String order_table, @org.jetbrains.annotations.NotNull()
    java.lang.String order_time, char completed) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUser_id() {
        return null;
    }
    
    public final void setUser_id(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrder_table() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrder_time() {
        return null;
    }
    
    public final char component4() {
        return '\u0000';
    }
    
    public final char getCompleted() {
        return '\u0000';
    }
    
    public final int getO_id() {
        return 0;
    }
    
    public final void setO_id(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ssafy.smartstore.data.local.dto.OrderDetail> getDetails() {
        return null;
    }
    
    public final void setDetails(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ssafy.smartstore.data.local.dto.OrderDetail> p0) {
    }
    
    public Order(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    java.lang.String order_table, @org.jetbrains.annotations.NotNull()
    java.lang.String order_time, char completed) {
        super();
    }
}