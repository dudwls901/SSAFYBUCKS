// Generated by view binder compiler. Do not edit!
package com.ssafy.smartstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class DialogStoreInfoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvOpenWeekday;

  @NonNull
  public final TextView tvOpenWeekend;

  @NonNull
  public final TextView tvTel;

  private DialogStoreInfoBinding(@NonNull LinearLayout rootView, @NonNull ImageView ivLogo,
      @NonNull TextView tvName, @NonNull TextView tvOpenWeekday, @NonNull TextView tvOpenWeekend,
      @NonNull TextView tvTel) {
    this.rootView = rootView;
    this.ivLogo = ivLogo;
    this.tvName = tvName;
    this.tvOpenWeekday = tvOpenWeekday;
    this.tvOpenWeekend = tvOpenWeekend;
    this.tvTel = tvTel;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogStoreInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogStoreInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_store_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogStoreInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_logo;
      ImageView ivLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivLogo == null) {
        break missingId;
      }

      id = R.id.tv_name;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tv_open_weekday;
      TextView tvOpenWeekday = ViewBindings.findChildViewById(rootView, id);
      if (tvOpenWeekday == null) {
        break missingId;
      }

      id = R.id.tv_open_weekend;
      TextView tvOpenWeekend = ViewBindings.findChildViewById(rootView, id);
      if (tvOpenWeekend == null) {
        break missingId;
      }

      id = R.id.tv_tel;
      TextView tvTel = ViewBindings.findChildViewById(rootView, id);
      if (tvTel == null) {
        break missingId;
      }

      return new DialogStoreInfoBinding((LinearLayout) rootView, ivLogo, tvName, tvOpenWeekday,
          tvOpenWeekend, tvTel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
