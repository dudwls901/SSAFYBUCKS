package com.ssafy.smartstore.util

import java.text.DecimalFormat

object DecimalConverter {

    @JvmStatic
    fun Int.priceConvert(): String{
        val myFormat = DecimalFormat("###,###")
        return myFormat.format(this)
    }
}


