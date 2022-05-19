package com.ssafy.smartstore.dto

import com.ssafy.smartstore.local.dto.Product
import java.io.Serializable

data class OrderProduct(
    var quantity: Int,
    val product: Product
): Serializable