package com.ssafy.smartstore.data.remote.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/ssafy/smartstore/data/remote/api/TokenService;", "", "uploadToken", "Lretrofit2/Response;", "", "userId", "token", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface TokenService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "token")
    public abstract java.lang.Object uploadToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "userId")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "token")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation);
}