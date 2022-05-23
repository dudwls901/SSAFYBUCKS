package com.ssafy.smartstore.data.local.dto;

import java.lang.System;

@androidx.room.Entity(tableName = "t_order_detail", foreignKeys = {@androidx.room.ForeignKey(entity = com.ssafy.smartstore.data.local.dto.Product.class, childColumns = {"product_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.ssafy.smartstore.data.local.dto.Order.class, childColumns = {"order_id"}, onDelete = 5, parentColumns = {"o_id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/ssafy/smartstore/data/local/dto/OrderDetail;", "", "id", "", "order_id", "product_id", "quantity", "(IIII)V", "(III)V", "d_id", "getD_id", "()I", "setD_id", "(I)V", "getOrder_id", "setOrder_id", "getProduct_id", "setProduct_id", "getQuantity", "setQuantity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class OrderDetail {
    private int order_id;
    private int product_id;
    private int quantity;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int d_id = -1;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.local.dto.OrderDetail copy(int order_id, int product_id, int quantity) {
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
    
    public OrderDetail(int order_id, int product_id, int quantity) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getOrder_id() {
        return 0;
    }
    
    public final void setOrder_id(int p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getProduct_id() {
        return 0;
    }
    
    public final void setProduct_id(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final void setQuantity(int p0) {
    }
    
    public final int getD_id() {
        return 0;
    }
    
    public final void setD_id(int p0) {
    }
    
    public OrderDetail(int id, int order_id, int product_id, int quantity) {
        super();
    }
}