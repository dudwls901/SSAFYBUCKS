package com.ssafy.smartstore.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "t_product")
data class Product(
    val name: String,
    val type: String,
    val price: Int,
    val img: String
):Serializable {
    @PrimaryKey(autoGenerate = true)
//    @SerializedName("id")
    var id: Int = -1

    constructor(id: Int, name: String, type: String, price: Int, img: String): this(name, type, price, img){
        this.id =id
    }
}