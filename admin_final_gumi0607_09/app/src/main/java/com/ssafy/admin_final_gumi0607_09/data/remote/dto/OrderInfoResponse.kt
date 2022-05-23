package com.ssafy.smartstore.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderInfoResponse(
    val completed: String,
    val img: String,
    @SerializedName("name")val p_name: String,
    val o_id: Int,
    val order_time: String,
    val p_id: Int,
    val price: Int,
    val quantity: Int,
    val type: String,
    val user_id: String,
    val user_name: String
): Parcelable