package com.ssafy.smartstore.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {

    fun String.formatDate(): String {

        val list = this.split("T")
        val s = list[0] + " " + list[1].split(".")[0] //"2022-05-2509:25:10"
        val dt = SimpleDateFormat("yyyyy-mm-dd hh:mm:ss")
        val date = dt.parse(s)

        val format = SimpleDateFormat("yyyy-MM-dd(E) kk:mm:ss", Locale.KOREAN)
        format.timeZone = TimeZone.getTimeZone("Asia/Seoul")

        return format.format(date.time)
    }
}