package com.ssafy.smartstore.util

import java.text.DecimalFormat

object DecimalConverter {
    fun Int.priceConvert(): String{
        val myFormat = DecimalFormat("###,###")
        return myFormat.format(this)
    }
}