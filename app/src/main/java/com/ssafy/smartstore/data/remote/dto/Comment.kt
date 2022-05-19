package com.ssafy.smartstore.data.remote.dto

import com.google.gson.annotations.SerializedName

class Comment {
    var id: Int = -1
    @SerializedName("userId")
    var userId: String
    @SerializedName("productId")
    var productId: Int
    var rating: Float
    var comment: String

    constructor(
        id: Int,
        userId: String,
        productId: Int,
        rating: Float,
        comment: String
    ) : super() {
        this.id = id
        this.userId = userId
        this.productId = productId
        this.rating = rating
        this.comment = comment
    }

    constructor(userId: String, productId: Int, rating: Float, comment: String) {
        this.userId = userId
        this.productId = productId
        this.rating = rating
        this.comment = comment
    }
}