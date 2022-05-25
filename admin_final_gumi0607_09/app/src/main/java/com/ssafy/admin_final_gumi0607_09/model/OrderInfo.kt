package com.ssafy.admin_final_gumi0607_09.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class OrderInfo(
    val id: Int,
    val orderProductList: List<OrderProduct>,
    val date: String,
    val user_name: String,
    val user_id: String,
    val completed: String
) : Parcelable, Comparable<OrderInfo> {
    override fun compareTo(other: OrderInfo): Int {
        if (this.completed.equals(other.completed)) {
            val dt = SimpleDateFormat("yyyyy-mm-dd hh:mm:ss")

            val list1 = this.date.split("T")
            val s1 = list1[0] + " " + list1[1].split(".")[0] //"2022-05-25 09:25:10"
            val date1 = dt.parse(s1)

            val list2 = other.date.split("T")
            val s2 = list2[0] + " " + list2[1].split(".")[0]
            val date2 = dt.parse(s2)

            return (date2.time - date1.time).toInt()
        } else {
            return this.completed.toCharArray()[0] - other.completed.toCharArray()[0]
        }
    }

}
