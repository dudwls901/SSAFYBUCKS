package com.ssafy.smartstore.data.remote.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/ssafy/smartstore/data/remote/api/ProductService;", "", "getProduct", "Lretrofit2/Response;", "Lcom/ssafy/smartstore/data/local/dto/Product;", "productId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ProductService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "product")
    public abstract java.lang.Object getProductList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.data.local.dto.Product>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "product/{productId}")
    public abstract java.lang.Object getProduct(@retrofit2.http.Path(value = "productId")
    int productId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.ssafy.smartstore.data.local.dto.Product>> continuation);
}