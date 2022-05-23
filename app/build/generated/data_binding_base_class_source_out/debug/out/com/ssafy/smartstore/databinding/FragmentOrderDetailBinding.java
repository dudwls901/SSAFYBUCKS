// Generated by view binder compiler. Do not edit!
package com.ssafy.smartstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ssafy.smartstore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentOrderDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout containerOrder;

  @NonNull
  public final AppCompatTextView headerOrderDetail;

  @NonNull
  public final RecyclerView rvOrderList;

  @NonNull
  public final AppCompatTextView tvDate;

  @NonNull
  public final AppCompatTextView tvPrice;

  @NonNull
  public final AppCompatTextView tvStatus;

  private FragmentOrderDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout containerOrder, @NonNull AppCompatTextView headerOrderDetail,
      @NonNull RecyclerView rvOrderList, @NonNull AppCompatTextView tvDate,
      @NonNull AppCompatTextView tvPrice, @NonNull AppCompatTextView tvStatus) {
    this.rootView = rootView;
    this.containerOrder = containerOrder;
    this.headerOrderDetail = headerOrderDetail;
    this.rvOrderList = rvOrderList;
    this.tvDate = tvDate;
    this.tvPrice = tvPrice;
    this.tvStatus = tvStatus;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentOrderDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentOrderDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_order_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentOrderDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.container_order;
      ConstraintLayout containerOrder = ViewBindings.findChildViewById(rootView, id);
      if (containerOrder == null) {
        break missingId;
      }

      id = R.id.header_order_detail;
      AppCompatTextView headerOrderDetail = ViewBindings.findChildViewById(rootView, id);
      if (headerOrderDetail == null) {
        break missingId;
      }

      id = R.id.rv_order_list;
      RecyclerView rvOrderList = ViewBindings.findChildViewById(rootView, id);
      if (rvOrderList == null) {
        break missingId;
      }

      id = R.id.tv_date;
      AppCompatTextView tvDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDate == null) {
        break missingId;
      }

      id = R.id.tv_price;
      AppCompatTextView tvPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvPrice == null) {
        break missingId;
      }

      id = R.id.tv_status;
      AppCompatTextView tvStatus = ViewBindings.findChildViewById(rootView, id);
      if (tvStatus == null) {
        break missingId;
      }

      return new FragmentOrderDetailBinding((ConstraintLayout) rootView, containerOrder,
          headerOrderDetail, rvOrderList, tvDate, tvPrice, tvStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
