package com.ssafy.smartstore.data.local.dto;

import java.lang.System;

@androidx.room.Entity(tableName = "t_noti")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/ssafy/smartstore/data/local/dto/Noti;", "", "id", "", "u_id", "", "data", "(ILjava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getId", "()I", "setId", "(I)V", "getU_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Noti {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String u_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String data = null;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.local.dto.Noti copy(@org.jetbrains.annotations.NotNull()
    java.lang.String u_id, @org.jetbrains.annotations.NotNull()
    java.lang.String data) {
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
    
    public Noti(@org.jetbrains.annotations.NotNull()
    java.lang.String u_id, @org.jetbrains.annotations.NotNull()
    java.lang.String data) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getU_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getData() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public Noti(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String u_id, @org.jetbrains.annotations.NotNull()
    java.lang.String data) {
        super();
    }
}