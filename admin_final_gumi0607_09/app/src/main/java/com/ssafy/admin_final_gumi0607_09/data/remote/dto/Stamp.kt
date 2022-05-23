package com.ssafy.admin_final_gumi0607_09.data.remote.dto
import com.ssafy.smartstore.data.remote.dto.Order

data class Stamp(
    val user_id: String,
    val order_id: Int,
    val quantity: Int
){
    var id: Int = -1

    constructor(id:Int, user_id: String, order_id: Int, quantity: Int): this(user_id, order_id, quantity){
        this.id =id
    }
}
