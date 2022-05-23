package com.ssafy.smartstore.view.home

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.ssafy.smartstore.R
import com.ssafy.smartstore.model.OrderInfo
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class MyPageFragmentDirections private constructor() {
  private data class ActionMyPageFragmentToOrderDetailFragment(
    public val orderInfo: OrderInfo
  ) : NavDirections {
    public override val actionId: Int = R.id.action_myPageFragment_to_orderDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(OrderInfo::class.java)) {
          result.putParcelable("orderInfo", this.orderInfo as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(OrderInfo::class.java)) {
          result.putSerializable("orderInfo", this.orderInfo as Serializable)
        } else {
          throw UnsupportedOperationException(OrderInfo::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionMyPageFragmentToOrderDetailFragment(orderInfo: OrderInfo): NavDirections =
        ActionMyPageFragmentToOrderDetailFragment(orderInfo)
  }
}
