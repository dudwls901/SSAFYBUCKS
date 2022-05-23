package com.ssafy.smartstore.data.remote.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJC\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/ssafy/smartstore/data/remote/api/ShoppingListService;", "", "addShoppingList", "Lretrofit2/Response;", "", "Lcom/ssafy/smartstore/model/OrderProduct;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByUser", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOneItem", "selectByUser", "app_debug"})
public abstract interface ShoppingListService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "shopping_list/add")
    public abstract java.lang.Object addShoppingList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.Object> map, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.model.OrderProduct>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "shopping_list/{userId}")
    public abstract java.lang.Object selectByUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "userId")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.model.OrderProduct>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "shopping_list/delete")
    public abstract java.lang.Object deleteOneItem(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.Object> map, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.model.OrderProduct>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.DELETE(value = "shopping_list/{userId}")
    public abstract java.lang.Object deleteByUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "userId")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ssafy.smartstore.model.OrderProduct>>> continuation);
}