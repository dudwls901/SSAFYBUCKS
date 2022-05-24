package com.ssafy.admin_final_gumi0607_09.util

import java.text.DecimalFormat

object DecimalConverter {
    fun Int.priceConvert(): String{
        val myFormat = DecimalFormat("###,###")
        return myFormat.format(this)
    }
}