package com.ssafy.smartstore.local.dto

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "t_order_detail",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Order::class,
            parentColumns = ["o_id"],
            childColumns = ["order_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]

)
data class OrderDetail(
    var order_id: Int,
    var product_id: Int,
    var quantity: Int = 1
) {
    @PrimaryKey(autoGenerate = true)
    var d_id: Int = -1

    constructor(id:Int, order_id: Int, product_id: Int, quantity: Int): this(order_id, product_id, quantity){
        d_id =id
    }
}
