package com.ssafy.smartstore.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)J\u000e\u0010\u0013\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020)J\u0006\u0010$\u001a\u00020\u001aJ\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0006J\b\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\bH\u0002J\u000e\u00101\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\fJ\u000e\u00102\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0014R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0014R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u000f8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0014R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0014\u00a8\u00063"}, d2 = {"Lcom/ssafy/smartstore/viewmodel/ProductViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_commentList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ssafy/smartstore/data/remote/dto/Comment;", "_errorMessage", "", "_loading", "", "_product", "Lcom/ssafy/smartstore/data/local/dto/Product;", "_productList", "_ratingAvg", "Landroidx/lifecycle/LiveData;", "", "kotlin.jvm.PlatformType", "commentList", "getCommentList", "()Landroidx/lifecycle/LiveData;", "errorMessage", "getErrorMessage", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "loading", "getLoading", "product", "getProduct", "productList", "getProductList", "ratingAvg", "getRatingAvg", "deleteComment", "id", "", "productId", "insertComment", "comment", "onCleared", "", "onError", "message", "setProduct", "updateComment", "app_debug"})
public final class ProductViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job job;
    private final kotlinx.coroutines.CoroutineExceptionHandler exceptionHandler = null;
    private androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage;
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loading;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.ssafy.smartstore.data.local.dto.Product>> _productList = null;
    private final androidx.lifecycle.MutableLiveData<com.ssafy.smartstore.data.local.dto.Product> _product = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>> _commentList = null;
    private final androidx.lifecycle.LiveData<java.lang.Float> _ratingAvg = null;
    
    public ProductViewModel() {
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
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ssafy.smartstore.data.local.dto.Product>> getProductList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.ssafy.smartstore.data.local.dto.Product> getProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ssafy.smartstore.data.remote.dto.Comment>> getCommentList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Float> getRatingAvg() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getProductList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setProduct(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.local.dto.Product product) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getCommentList(int productId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertComment(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.remote.dto.Comment comment) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateComment(@org.jetbrains.annotations.NotNull()
    com.ssafy.smartstore.data.remote.dto.Comment comment) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteComment(int id) {
        return null;
    }
    
    private final void onError(java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}