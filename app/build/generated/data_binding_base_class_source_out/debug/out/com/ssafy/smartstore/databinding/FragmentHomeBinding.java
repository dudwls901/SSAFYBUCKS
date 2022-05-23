// Generated by data binding compiler. Do not edit!
package com.ssafy.smartstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ssafy.smartstore.R;
import com.ssafy.smartstore.viewmodel.HomeViewModel;
import com.ssafy.smartstore.viewmodel.OrderViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout containerNotice;

  @NonNull
  public final ConstraintLayout containerProfile;

  @NonNull
  public final ProgressBar loadingBar;

  @NonNull
  public final RecyclerView rvNoti;

  @NonNull
  public final RecyclerView rvRecentOrder;

  @NonNull
  public final AppCompatTextView tvHeaderName;

  @NonNull
  public final AppCompatTextView tvHeaderNotice;

  @NonNull
  public final AppCompatTextView tvHeaderRecentOrder;

  @NonNull
  public final AppCompatTextView tvHello;

  @Bindable
  protected HomeViewModel mHomeVM;

  @Bindable
  protected OrderViewModel mOrderVM;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout containerNotice, ConstraintLayout containerProfile, ProgressBar loadingBar,
      RecyclerView rvNoti, RecyclerView rvRecentOrder, AppCompatTextView tvHeaderName,
      AppCompatTextView tvHeaderNotice, AppCompatTextView tvHeaderRecentOrder,
      AppCompatTextView tvHello) {
    super(_bindingComponent, _root, _localFieldCount);
    this.containerNotice = containerNotice;
    this.containerProfile = containerProfile;
    this.loadingBar = loadingBar;
    this.rvNoti = rvNoti;
    this.rvRecentOrder = rvRecentOrder;
    this.tvHeaderName = tvHeaderName;
    this.tvHeaderNotice = tvHeaderNotice;
    this.tvHeaderRecentOrder = tvHeaderRecentOrder;
    this.tvHello = tvHello;
  }

  public abstract void setHomeVM(@Nullable HomeViewModel homeVM);

  @Nullable
  public HomeViewModel getHomeVM() {
    return mHomeVM;
  }

  public abstract void setOrderVM(@Nullable OrderViewModel orderVM);

  @Nullable
  public OrderViewModel getOrderVM() {
    return mOrderVM;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, R.layout.fragment_home);
  }
}
