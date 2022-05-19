package com.ssafy.smartstore.model

data class OrderDetail(
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Int
)