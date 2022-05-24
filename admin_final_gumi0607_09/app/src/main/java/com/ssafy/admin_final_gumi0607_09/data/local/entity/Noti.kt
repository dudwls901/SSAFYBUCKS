package com.ssafy.admin_final_gumi0607_09.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "t_noti")
@Parcelize
data class Noti(
    val u_id: String,
    val data: String
): Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id: Int=0

    constructor(id: Int, u_id: String, data: String): this(
        u_id,
        data
    ){
        this.id = id
    }

}
