package com.ssafy.smartstore.data.local.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0018\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/ssafy/smartstore/data/local/repository/StampRepository;", "", "()V", "db", "Lcom/ssafy/smartstore/data/local/database/StoreDatabase;", "sDao", "Lcom/ssafy/smartstore/data/local/dao/StampDao;", "insert", "", "stamp", "Lcom/ssafy/smartstore/data/local/dto/Stamp;", "(Lcom/ssafy/smartstore/data/local/dto/Stamp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "select", "stampId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectByUser", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectByUserId", "userId", "Companion", "app_debug"})
public final class StampRepository {
    private final com.ssafy.smartstore.data.local.database.StoreDatabase db = null;
    private final com.ssafy.smartstore.data.local.dao.StampDao sDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.data.local.repository.StampRepository.Companion Companion = null;
    private static com.ssafy.smartstore.data.local.repository.StampRepository INSTANCE;
    
    public StampRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object selectByUser(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.Stamp>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.local.dto.Stamp stamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object select(int stampId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ssafy.smartstore.data.local.dto.Stamp> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object selectAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.Stamp>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object selectByUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ssafy.smartstore.data.local.dto.Stamp>> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/ssafy/smartstore/data/local/repository/StampRepository$Companion;", "", "()V", "INSTANCE", "Lcom/ssafy/smartstore/data/local/repository/StampRepository;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ssafy.smartstore.data.local.repository.StampRepository getInstance() {
            return null;
        }
    }
}