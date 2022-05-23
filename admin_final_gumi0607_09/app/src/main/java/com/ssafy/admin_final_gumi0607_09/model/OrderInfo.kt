package com.ssafy.admin_final_gumi0607_09.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class OrderInfo(
    val id: Int,
    val orderProductList: List<OrderProduct>,
    val date: String,
    val name: String,
    val completed: String
):Parcelable
