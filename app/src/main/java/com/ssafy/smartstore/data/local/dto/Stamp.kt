package com.ssafy.smartstore.data.local.dto

import androidx.room.ForeignKey
import androidx.room.PrimaryKey

import androidx.room.Entity

@Entity(tableName = "t_stamp",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
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
data class Stamp(
    val user_id: String,
    val order_id: Int,
    val quantity: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = -1

    constructor(id:Int, user_id: String, order_id: Int, quantity: Int): this(user_id, order_id, quantity){
        this.id =id
    }
}
