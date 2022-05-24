package com.ssafy.smartstore.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class OrderInfo(
    val id: Int,
    val orderProductList: List<OrderProduct>,
    val date: String
) : Parcelable {
    var completed = "N"

    constructor(
        id: Int,
        orderProductList: List<OrderProduct>,
        date: String,
        completed: String
    ) : this(id, orderProductList, date) {
        this.completed = completed
    }
}
