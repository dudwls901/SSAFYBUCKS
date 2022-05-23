// Generated by view binder compiler. Do not edit!
package com.ssafy.smartstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ssafy.smartstore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentJoinBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnCheck;

  @NonNull
  public final AppCompatButton btnJoin;

  @NonNull
  public final LinearLayout containerLogo;

  @NonNull
  public final TextInputEditText etID;

  @NonNull
  public final TextInputEditText etNickName;

  @NonNull
  public final TextInputEditText etPW;

  @NonNull
  public final AppCompatImageView ivLogo;

  @NonNull
  public final TextInputLayout tlID;

  @NonNull
  public final TextInputLayout tlNickName;

  @NonNull
  public final TextInputLayout tlPW;

  private FragmentJoinBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton btnCheck,
      @NonNull AppCompatButton btnJoin, @NonNull LinearLayout containerLogo,
      @NonNull TextInputEditText etID, @NonNull TextInputEditText etNickName,
      @NonNull TextInputEditText etPW, @NonNull AppCompatImageView ivLogo,
      @NonNull TextInputLayout tlID, @NonNull TextInputLayout tlNickName,
      @NonNull TextInputLayout tlPW) {
    this.rootView = rootView;
    this.btnCheck = btnCheck;
    this.btnJoin = btnJoin;
    this.containerLogo = containerLogo;
    this.etID = etID;
    this.etNickName = etNickName;
    this.etPW = etPW;
    this.ivLogo = ivLogo;
    this.tlID = tlID;
    this.tlNickName = tlNickName;
    this.tlPW = tlPW;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentJoinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentJoinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_join, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentJoinBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_check;
      ImageButton btnCheck = ViewBindings.findChildViewById(rootView, id);
      if (btnCheck == null) {
        break missingId;
      }

      id = R.id.btn_join;
      AppCompatButton btnJoin = ViewBindings.findChildViewById(rootView, id);
      if (btnJoin == null) {
        break missingId;
      }

      id = R.id.container_logo;
      LinearLayout containerLogo = ViewBindings.findChildViewById(rootView, id);
      if (containerLogo == null) {
        break missingId;
      }

      id = R.id.et_ID;
      TextInputEditText etID = ViewBindings.findChildViewById(rootView, id);
      if (etID == null) {
        break missingId;
      }

      id = R.id.et_nickName;
      TextInputEditText etNickName = ViewBindings.findChildViewById(rootView, id);
      if (etNickName == null) {
        break missingId;
      }

      id = R.id.et_PW;
      TextInputEditText etPW = ViewBindings.findChildViewById(rootView, id);
      if (etPW == null) {
        break missingId;
      }

      id = R.id.iv_logo;
      AppCompatImageView ivLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivLogo == null) {
        break missingId;
      }

      id = R.id.tl_ID;
      TextInputLayout tlID = ViewBindings.findChildViewById(rootView, id);
      if (tlID == null) {
        break missingId;
      }

      id = R.id.tl_nickName;
      TextInputLayout tlNickName = ViewBindings.findChildViewById(rootView, id);
      if (tlNickName == null) {
        break missingId;
      }

      id = R.id.tl_PW;
      TextInputLayout tlPW = ViewBindings.findChildViewById(rootView, id);
      if (tlPW == null) {
        break missingId;
      }

      return new FragmentJoinBinding((ConstraintLayout) rootView, btnCheck, btnJoin, containerLogo,
          etID, etNickName, etPW, ivLogo, tlID, tlNickName, tlPW);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
