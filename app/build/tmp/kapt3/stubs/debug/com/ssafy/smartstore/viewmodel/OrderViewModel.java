package com.ssafy.smartstore.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tJ\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0012J*\u0010@\u001a\u00020$2\"\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0Bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`CJ\u000e\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\tJ\u000e\u00106\u001a\u00020$2\u0006\u0010;\u001a\u00020\tJ\u000e\u0010F\u001a\u00020$2\u0006\u0010E\u001a\u00020\tJ\u0006\u0010G\u001a\u00020HJ\b\u0010I\u001a\u00020HH\u0014J\u0010\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020\tH\u0002J\u000e\u0010L\u001a\u00020$2\u0006\u0010;\u001a\u00020\tR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\t0\t0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\t0\t0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00160\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR)\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u001cR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u001cR\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000f8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u001cR\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010\u001cR)\u00103\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00160\u000f8F\u00a2\u0006\u0006\u001a\u0004\b4\u0010\u001cR\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00120\u000f8F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u001cR\u001d\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001c\u00a8\u0006M"}, d2 = {"Lcom/ssafy/smartstore/viewmodel/OrderViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_canCallBootPay", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ssafy/smartstore/event/Event;", "", "_dialogMessage", "", "", "", "_errorMessage", "_loading", "_orderComplete", "_orderCount", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "_orderInfoList", "", "Lcom/ssafy/smartstore/model/OrderInfo;", "_priceSum", "_responseUserInfo", "Lretrofit2/Response;", "_shoppingList", "Lcom/ssafy/smartstore/model/OrderProduct;", "_toastMessage", "canCallBootPay", "getCanCallBootPay", "()Landroidx/lifecycle/LiveData;", "dialogMessage", "getDialogMessage", "errorMessage", "getErrorMessage", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "loading", "getLoading", "orderComplete", "getOrderComplete", "orderCount", "getOrderCount", "orderInfoList", "getOrderInfoList", "priceSum", "getPriceSum", "responseUserInfo", "getResponseUserInfo", "shoppingList", "getShoppingList", "toastMessage", "getToastMessage", "addItem", "item", "userId", "type", "changeOrderInfoList", "orderInfoResponseList", "Lcom/ssafy/smartstore/data/remote/dto/OrderInfoResponse;", "deleteOneItem", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getOrderMonth", "id", "getUserInfo", "makeOrder", "", "onCleared", "onError", "message", "updateOrderDetails", "app_debug"})
public final class OrderViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job job;
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private final androidx.lifecycle.MutableLiveData<com.ssafy.smartstore.event.Event<java.lang.String>> _toastMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.ssafy.smartstore.event.Event<java.lang.String>> toastMessage = null;
    private final androidx.lifecycle.MutableLiveData<com.ssafy.smartstore.event.Event<java.util.Map<java.lang.String, java.lang.Object>>> _dialogMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.ssafy.smartstore.event.Event<java.util.Map<java.lang.String, java.lang.Object>>> dialogMessage = null;
    private androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage;
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loading;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.ssafy.smartstore.model.OrderInfo>> _orderInfoList = null;
    private final androidx.lifecycle.MutableLiveData<retrofit2.Response<java.util.Map<java.lang.String, java.lang.Object>>> _responseUserInfo = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.ssafy.smartstore.model.OrderProduct>> _shoppingList = null;
    private final androidx.lifecycle.LiveData<java.lang.String> _orderCount = null;
    private final androidx.lifecycle.LiveData<java.lang.String> _priceSum = null;
    private final androidx.lifecycle.MutableLiveData<com.ssafy.smartstore.event.Event<java.lang.Boolean>> _canCallBootPay = null;
    private final androidx.lifecycle.MutableLiveData<com.ssafy.smartstore.event.Event<java.lang.Boolean>> _orderComplete = null;
    
    public OrderViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.Job p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.ssafy.smartstore.event.Event<java.lang.String>> getToastMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.ssafy.smartstore.event.Event<java.util.Map<java.lang.String, java.lang.Object>>> getDialogMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ssafy.smartstore.model.OrderInfo>> getOrderInfoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<retrofit2.Response<java.util.Map<java.lang.String, java.lang.Object>>> getResponseUserInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ssafy.smartstore.model.OrderProduct>> getShoppingList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getOrderCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getPriceSum() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.ssafy.smartstore.event.Event<java.lang.Boolean>> getCanCallBootPay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.ssafy.smartstore.event.Event<java.lang.Boolean>> getOrderComplete() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getOrderMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ssafy.smartstore.model.OrderInfo> changeOrderInfoList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ssafy.smartstore.data.remote.dto.OrderInfoResponse> orderInfoResponseList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getUserInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getShoppingList(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addItem(@org.jetbrains.annotations.NotNull()
    java.lang.Object item, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteOneItem(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> map) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateOrderDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    public final void makeOrder() {
    }
    
    private final void onError(java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}