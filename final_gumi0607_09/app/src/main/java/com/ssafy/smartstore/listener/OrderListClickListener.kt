package com.ssafy.smartstore.listener

import com.ssafy.smartstore.model.OrderInfo

interface OrderListClickListener {
    fun onOrderListClickListener(orderInfo: OrderInfo)
    fun onOrderListCartClickListener(orderInfo: OrderInfo)
}