package com.ssafy.smartstore.data.local.database;

import java.lang.System;

@androidx.room.Database(entities = {com.ssafy.smartstore.data.local.dto.User.class, com.ssafy.smartstore.data.local.dto.Order.class, com.ssafy.smartstore.data.local.dto.OrderDetail.class, com.ssafy.smartstore.data.local.dto.Product.class, com.ssafy.smartstore.data.local.dto.Stamp.class, com.ssafy.smartstore.data.local.dto.Comment.class, com.ssafy.smartstore.data.local.dto.Noti.class}, version = 6)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/ssafy/smartstore/data/local/database/StoreDatabase;", "Landroidx/room/RoomDatabase;", "()V", "commentDao", "Lcom/ssafy/smartstore/data/local/dao/CommentDao;", "notiDao", "Lcom/ssafy/smartstore/data/local/dao/NotiDao;", "orderDao", "Lcom/ssafy/smartstore/data/local/dao/OrderDao;", "orderDetailDao", "Lcom/ssafy/smartstore/data/local/dao/OrderDetailDao;", "productDao", "Lcom/ssafy/smartstore/data/local/dao/ProductDao;", "stampDao", "Lcom/ssafy/smartstore/data/local/dao/StampDao;", "userDao", "Lcom/ssafy/smartstore/data/local/dao/UserDao;", "Companion", "app_debug"})
public abstract class StoreDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.data.local.database.StoreDatabase.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.ssafy.smartstore.data.local.database.StoreDatabase INSTANCE;
    
    public StoreDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ssafy.smartstore.data.local.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ssafy.smartstore.data.local.dao.StampDao stampDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ssafy.smartstore.data.local.dao.ProductDao productDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ssafy.smartstore.data.local.dao.OrderDao orderDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ssafy.smartstore.data.local.dao.OrderDetailDao orderDetailDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ssafy.smartstore.data.local.dao.CommentDao commentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ssafy.smartstore.data.local.dao.NotiDao notiDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J!\u0010\t\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f\u00a2\u0006\u0002\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/ssafy/smartstore/data/local/database/StoreDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/ssafy/smartstore/data/local/database/StoreDatabase;", "getINSTANCE", "()Lcom/ssafy/smartstore/data/local/database/StoreDatabase;", "setINSTANCE", "(Lcom/ssafy/smartstore/data/local/database/StoreDatabase;)V", "getInstance", "context", "", "Landroid/content/Context;", "([Landroid/content/Context;)Lcom/ssafy/smartstore/data/local/database/StoreDatabase;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.ssafy.smartstore.data.local.database.StoreDatabase getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable()
        com.ssafy.smartstore.data.local.database.StoreDatabase p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.ssafy.smartstore.data.local.database.StoreDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context... context) {
            return null;
        }
    }
}