package com.ssafy.smartstore.remote.dto

import com.google.gson.annotations.SerializedName

class OrderDetail {
    private var id: Int? = null
    private var orderId: Int? = null
    @SerializedName("productId")
    private var productId: Int
    private var quantity: Int

    constructor(id: Int?, orderId: Int?, productId: Int, quantity: Int) : super() {
        this.id = id
        this.orderId = orderId
        this.productId = productId
        this.quantity = quantity
    }

    constructor(productId: Int, quantity: Int) {
        this.productId = productId
        this.quantity = quantity
    }

    constructor(orderId: Int?, productId: Int, quantity: Int) {
        this.orderId = orderId
        this.productId = productId
        this.quantity = quantity
    }
}
