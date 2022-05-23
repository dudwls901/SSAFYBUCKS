package com.ssafy.smartstore.view.intro

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.ssafy.smartstore.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToJoinFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_joinFragment)
  }
}
