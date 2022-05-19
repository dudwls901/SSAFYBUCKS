package com.ssafy.smartstore.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "t_order",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = CASCADE
        )
    ]
)
data class Order(
    var user_id: String,
    val order_table: String,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    val order_time: String,
    @ColumnInfo(defaultValue = "N")
    val completed: Char

) {
    @PrimaryKey(autoGenerate = true)
    var o_id: Int = 0

    @Transient
    var details: List<OrderDetail> = arrayListOf()

    constructor(id:Int, user_id: String, order_table: String, order_time: String, completed: Char): this(user_id, order_table, order_time, completed){
        o_id =id
    }
}
