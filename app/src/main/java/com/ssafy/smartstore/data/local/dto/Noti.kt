package com.ssafy.smartstore.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_noti")
data class Noti(
    val u_id: String,
    val data: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int=0

    constructor(id: Int, u_id: String, data: String): this(
        u_id,
        data
    ){
        this.id = id
    }

}
