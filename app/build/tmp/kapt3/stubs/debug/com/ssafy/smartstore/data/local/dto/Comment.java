package com.ssafy.smartstore.data.local.dto;

import java.lang.System;

@androidx.room.Entity(tableName = "t_comment", foreignKeys = {@androidx.room.ForeignKey(entity = com.ssafy.smartstore.data.local.dto.User.class, childColumns = {"user_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.ssafy.smartstore.data.local.dto.Product.class, childColumns = {"product_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/ssafy/smartstore/data/local/dto/Comment;", "", "id", "", "user_id", "", "product_id", "rating", "", "comment", "(ILjava/lang/String;IFLjava/lang/String;)V", "(Ljava/lang/String;IFLjava/lang/String;)V", "getComment", "()Ljava/lang/String;", "getId", "()I", "setId", "(I)V", "getProduct_id", "getRating", "()F", "getUser_id", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Comment {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String user_id = null;
    private final int product_id = 0;
    private final float rating = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String comment = null;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.local.dto.Comment copy(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id, int product_id, float rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
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
    
    public Comment(@org.jetbrains.annotations.NotNull()
    java.lang.String user_id, int product_id, float rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
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
    
    public final int getProduct_id() {
        return 0;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float getRating() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getComment() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public Comment(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String user_id, int product_id, float rating, @org.jetbrains.annotations.NotNull()
    java.lang.String comment) {
        super();
    }
}