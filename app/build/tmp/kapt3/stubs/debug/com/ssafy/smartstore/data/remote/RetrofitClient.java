package com.ssafy.smartstore.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'J\b\u0010(\u001a\u00020)H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 \u00a8\u0006*"}, d2 = {"Lcom/ssafy/smartstore/data/remote/RetrofitClient;", "", "()V", "commentService", "Lcom/ssafy/smartstore/data/remote/api/CommentService;", "getCommentService", "()Lcom/ssafy/smartstore/data/remote/api/CommentService;", "commentService$delegate", "Lkotlin/Lazy;", "orderService", "Lcom/ssafy/smartstore/data/remote/api/OrderService;", "getOrderService", "()Lcom/ssafy/smartstore/data/remote/api/OrderService;", "orderService$delegate", "productService", "Lcom/ssafy/smartstore/data/remote/api/ProductService;", "getProductService", "()Lcom/ssafy/smartstore/data/remote/api/ProductService;", "productService$delegate", "shoppingListService", "Lcom/ssafy/smartstore/data/remote/api/ShoppingListService;", "getShoppingListService", "()Lcom/ssafy/smartstore/data/remote/api/ShoppingListService;", "shoppingListService$delegate", "tokenService", "Lcom/ssafy/smartstore/data/remote/api/TokenService;", "getTokenService", "()Lcom/ssafy/smartstore/data/remote/api/TokenService;", "tokenService$delegate", "userService", "Lcom/ssafy/smartstore/data/remote/api/UserService;", "getUserService", "()Lcom/ssafy/smartstore/data/remote/api/UserService;", "userService$delegate", "buildOkHttpClient", "Lokhttp3/OkHttpClient;", "getErrorResponse", "Lcom/ssafy/smartstore/data/remote/dto/ErrorResponse;", "errorBody", "Lokhttp3/ResponseBody;", "getRetrofit", "Lretrofit2/Retrofit;", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull()
    public static final com.ssafy.smartstore.data.remote.RetrofitClient INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy productService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy orderService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy userService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy commentService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy tokenService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy shoppingListService$delegate = null;
    
    private RetrofitClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.remote.api.ProductService getProductService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.remote.api.OrderService getOrderService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.remote.api.UserService getUserService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.remote.api.CommentService getCommentService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.remote.api.TokenService getTokenService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ssafy.smartstore.data.remote.api.ShoppingListService getShoppingListService() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    private final okhttp3.OkHttpClient buildOkHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ssafy.smartstore.data.remote.dto.ErrorResponse getErrorResponse(@org.jetbrains.annotations.NotNull()
    okhttp3.ResponseBody errorBody) {
        return null;
    }
}