package com.ssafy.smartstore.dto

import java.io.Serializable

data class OrderInfo(
    val id: Int,
    val orderProductList: List<OrderProduct>,
    val date: String
):Serializable
