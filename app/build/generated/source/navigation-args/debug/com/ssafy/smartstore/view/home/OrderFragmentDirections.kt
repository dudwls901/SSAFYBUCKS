package com.ssafy.smartstore.view.home

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.ssafy.smartstore.R
import com.ssafy.smartstore.`data`.local.dto.Product
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class OrderFragmentDirections private constructor() {
  private data class ActionOrderFragmentToMenuDetailFragment(
    public val product: Product
  ) : NavDirections {
    public override val actionId: Int = R.id.action_orderFragment_to_menuDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionOrderFragmentToShoppingListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_orderFragment_to_shoppingListFragment)

    public fun actionOrderFragmentToMenuDetailFragment(product: Product): NavDirections =
        ActionOrderFragmentToMenuDetailFragment(product)
  }
}
