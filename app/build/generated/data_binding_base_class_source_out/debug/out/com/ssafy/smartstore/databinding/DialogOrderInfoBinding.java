// Generated by view binder compiler. Do not edit!
package com.ssafy.smartstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ssafy.smartstore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogOrderInfoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnSubmit;

  @NonNull
  public final ImageView ivDialogOrderInfoImage;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final TextView tvDialogOrderInfoName;

  @NonNull
  public final TextView tvDialogOrderInfoPrice;

  @NonNull
  public final TextView tvOpenWeekday;

  private DialogOrderInfoBinding(@NonNull LinearLayout rootView, @NonNull Button btnSubmit,
      @NonNull ImageView ivDialogOrderInfoImage, @NonNull ImageView ivLogo,
      @NonNull TextView tvDialogOrderInfoName, @NonNull TextView tvDialogOrderInfoPrice,
      @NonNull TextView tvOpenWeekday) {
    this.rootView = rootView;
    this.btnSubmit = btnSubmit;
    this.ivDialogOrderInfoImage = ivDialogOrderInfoImage;
    this.ivLogo = ivLogo;
    this.tvDialogOrderInfoName = tvDialogOrderInfoName;
    this.tvDialogOrderInfoPrice = tvDialogOrderInfoPrice;
    this.tvOpenWeekday = tvOpenWeekday;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogOrderInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogOrderInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_order_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogOrderInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_submit;
      Button btnSubmit = ViewBindings.findChildViewById(rootView, id);
      if (btnSubmit == null) {
        break missingId;
      }

      id = R.id.iv_dialog_order_info_image;
      ImageView ivDialogOrderInfoImage = ViewBindings.findChildViewById(rootView, id);
      if (ivDialogOrderInfoImage == null) {
        break missingId;
      }

      id = R.id.iv_logo;
      ImageView ivLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivLogo == null) {
        break missingId;
      }

      id = R.id.tv_dialog_order_info_name;
      TextView tvDialogOrderInfoName = ViewBindings.findChildViewById(rootView, id);
      if (tvDialogOrderInfoName == null) {
        break missingId;
      }

      id = R.id.tv_dialog_order_info_price;
      TextView tvDialogOrderInfoPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvDialogOrderInfoPrice == null) {
        break missingId;
      }

      id = R.id.tv_open_weekday;
      TextView tvOpenWeekday = ViewBindings.findChildViewById(rootView, id);
      if (tvOpenWeekday == null) {
        break missingId;
      }

      return new DialogOrderInfoBinding((LinearLayout) rootView, btnSubmit, ivDialogOrderInfoImage,
          ivLogo, tvDialogOrderInfoName, tvDialogOrderInfoPrice, tvOpenWeekday);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
