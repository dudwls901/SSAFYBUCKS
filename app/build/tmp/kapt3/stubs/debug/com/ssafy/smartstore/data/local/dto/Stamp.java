package com.ssafy.smartstore.data.local.dto;

import java.lang.System;

@androidx.room.Entity(tableName = "t_stamp", foreignKeys = {@androidx.room.ForeignKey(entity = com.ssafy.smartstore.data.local.dto.User.class, childColumns = {"user_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.ssafy.smartstore.data.local.dto.Order.class, childColumns = {"order_id"}, onDelete = 5, parentColumns = {"o_id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/ssafy/smartstore/data/local/dto/Stamp;", "", "id", "", "user_id", "", "order_id", "quantity", "(ILjava/lang/String;II)V", "(Ljava/lang/String;II)V", "getId", "()I", "setId", "(I)V", "getOrder_id", "getQuantity", "getUser_id", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Stamp {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String user_id = null;
    private final int order_id = 0;
    private final int quantity = 0;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = -1;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.local.dto.Stamp copy(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id, int order_id, int quantity) {
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
    
    public Stamp(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id, int order_id, int quantity) {
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
    
    public final int component2() {
        return 0;
    }
    
    public final int getOrder_id() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public Stamp(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String user_id, int order_id, int quantity) {
        super();
    }
}