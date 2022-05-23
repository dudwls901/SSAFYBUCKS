package com.ssafy.smartstore.data.remote.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nB\'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/ssafy/smartstore/data/remote/dto/Comment;", "", "id", "", "userId", "", "productId", "rating", "", "comment", "(ILjava/lang/String;IFLjava/lang/String;)V", "(Ljava/lang/String;IFLjava/lang/String;)V", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getProductId", "setProductId", "getRating", "()F", "setRating", "(F)V", "getUserId", "setUserId", "app_debug"})
public final class Comment {
    private int id = -1;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userId")
    private java.lang.String userId;
    @com.google.gson.annotations.SerializedName(value = "productId")
    private int productId;
    private float rating;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String comment;
    
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
    
    public final int getProductId() {
        return 0;
    }
    
    public final void setProductId(int p0) {
    }
    
    public final float getRating() {
        return 0.0F;
    }
    
    public final void setRating(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getComment() {
        return null;
    }
    
    public final void setComment(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Comment(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, int productId, float rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
        super();
    }
    
    public Comment(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, int productId, float rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
        super();
    }
}