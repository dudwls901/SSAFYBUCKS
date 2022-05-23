package com.ssafy.admin_final_gumi0607_09.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Product(
    val name: String,
    val type: String,
    val price: Int,
    val img: String
):Parcelable{

    @SerializedName("id")
    var id: Int = -1

    constructor(id: Int, name: String, type: String, price: Int, img: String): this(name, type, price, img){
        this.id =id
    }
}
