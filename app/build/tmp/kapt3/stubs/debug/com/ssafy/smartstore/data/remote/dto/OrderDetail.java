package com.ssafy.smartstore.data.remote.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bB!\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u0005\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/ssafy/smartstore/data/remote/dto/OrderDetail;", "", "id", "", "orderId", "productId", "quantity", "(Ljava/lang/Integer;Ljava/lang/Integer;II)V", "(II)V", "(Ljava/lang/Integer;II)V", "Ljava/lang/Integer;", "app_debug"})
public final class OrderDetail {
    private java.lang.Integer id;
    private java.lang.Integer orderId;
    @com.google.gson.annotations.SerializedName(value = "productId")
    private int productId;
    private int quantity;
    
    public OrderDetail(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.Integer orderId, int productId, int quantity) {
        super();
    }
    
    public OrderDetail(int productId, int quantity) {
        super();
    }
    
    public OrderDetail(@org.jetbrains.annotations.Nullable()
    java.lang.Integer orderId, int productId, int quantity) {
        super();
    }
}