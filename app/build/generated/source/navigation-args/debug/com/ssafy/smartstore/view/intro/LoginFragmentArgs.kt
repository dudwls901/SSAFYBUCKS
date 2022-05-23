package com.ssafy.smartstore.view.intro

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class LoginFragmentArgs(
  public val notiData: String?
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("notiData", this.notiData)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("notiData", this.notiData)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): LoginFragmentArgs {
      bundle.setClassLoader(LoginFragmentArgs::class.java.classLoader)
      val __notiData : String?
      if (bundle.containsKey("notiData")) {
        __notiData = bundle.getString("notiData")
      } else {
        throw IllegalArgumentException("Required argument \"notiData\" is missing and does not have an android:defaultValue")
      }
      return LoginFragmentArgs(__notiData)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): LoginFragmentArgs {
      val __notiData : String?
      if (savedStateHandle.contains("notiData")) {
        __notiData = savedStateHandle["notiData"]
      } else {
        throw IllegalArgumentException("Required argument \"notiData\" is missing and does not have an android:defaultValue")
      }
      return LoginFragmentArgs(__notiData)
    }
  }
}
