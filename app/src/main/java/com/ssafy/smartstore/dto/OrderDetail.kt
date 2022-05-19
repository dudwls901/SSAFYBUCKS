package com.ssafy.smartstore.dto

data class OrderDetail(
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Int
)