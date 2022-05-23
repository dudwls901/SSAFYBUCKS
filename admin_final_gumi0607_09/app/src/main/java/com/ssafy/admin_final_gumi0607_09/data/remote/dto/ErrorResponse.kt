package com.ssafy.smartstore.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String)