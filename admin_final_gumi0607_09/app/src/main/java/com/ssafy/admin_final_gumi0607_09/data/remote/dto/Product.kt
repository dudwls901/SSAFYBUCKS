package com.ssafy.admin_final_gumi0607_09.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Product(
    val name: String,
    val type: String,
    val price: Int,
    val img: String
):Parcelable
