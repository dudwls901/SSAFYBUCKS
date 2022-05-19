package com.ssafy.smartstore.data.local.dto

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "t_comment",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Comment(
    val user_id: String,
    val product_id: Int,
    val rating: Float,
    val comment: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    constructor(id: Int, user_id: String, product_id: Int, rating: Float, comment: String) : this(
        user_id,
        product_id,
        rating,
        comment
    ) {
        this.id = id
    }
}