package com.ssafy.smartstore.view.home

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.ssafy.smartstore.`data`.local.dto.Product
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class MenuDetailFragmentArgs(
  public val product: Product
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Product::class.java)) {
      result.putParcelable("product", this.product as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Product::class.java)) {
      result.putSerializable("product", this.product as Serializable)
    } else {
      throw UnsupportedOperationException(Product::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Product::class.java)) {
      result.set("product", this.product as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Product::class.java)) {
      result.set("product", this.product as Serializable)
    } else {
      throw UnsupportedOperationException(Product::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): MenuDetailFragmentArgs {
      bundle.setClassLoader(MenuDetailFragmentArgs::class.java.classLoader)
      val __product : Product?
      if (bundle.containsKey("product")) {
        if (Parcelable::class.java.isAssignableFrom(Product::class.java) ||
            Serializable::class.java.isAssignableFrom(Product::class.java)) {
          __product = bundle.get("product") as Product?
        } else {
          throw UnsupportedOperationException(Product::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__product == null) {
          throw IllegalArgumentException("Argument \"product\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"product\" is missing and does not have an android:defaultValue")
      }
      return MenuDetailFragmentArgs(__product)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MenuDetailFragmentArgs {
      val __product : Product?
      if (savedStateHandle.contains("product")) {
        if (Parcelable::class.java.isAssignableFrom(Product::class.java) ||
            Serializable::class.java.isAssignableFrom(Product::class.java)) {
          __product = savedStateHandle.get<Product?>("product")
        } else {
          throw UnsupportedOperationException(Product::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__product == null) {
          throw IllegalArgumentException("Argument \"product\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"product\" is missing and does not have an android:defaultValue")
      }
      return MenuDetailFragmentArgs(__product)
    }
  }
}
