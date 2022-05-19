package com.ssafy.smartstore.remote.dto

import com.google.gson.annotations.SerializedName
import com.ssafy.smartstore.local.dto.Stamp
import java.util.*

class Order {
    var id: Int = -1
    @SerializedName("userId")
    var userId: String
    @SerializedName("orderTable")
    var orderTable: String
    var orderTime: Date = Date()
    var completed: Char = 'N'
    var details: List<OrderDetail> = arrayListOf()
    var stamp: Stamp? = null

    constructor(
        id: Int,
        userId: String,
        orderTable: String,
        orderTime: Date,
        complited: Char
    ) : super() {
        this.id = id
        this.userId = userId
        this.orderTable = orderTable
        this.orderTime = orderTime
        completed = complited
    }

    constructor(userId: String, orderTable: String, orderTime: Date, complited: Char) {
        this.userId = userId
        this.orderTable = orderTable
        this.orderTime = orderTime
        completed = complited
    }

    constructor(userId: String, orderTable: String) {
        this.userId = userId
        this.orderTable = orderTable
    }
}
