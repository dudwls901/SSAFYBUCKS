package com.ssafy.smartstore.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_user")
data class User(
    @PrimaryKey
    var id: String,
    var pass: String,
) {
    var stamps: Int = 0

    @Transient
    var stampList: List<Stamp> = ArrayList()

    var name: String = ""

    constructor(id: String, name: String, pass: String) : this(id, pass) {
        this.name = name
    }

    constructor(id: String, name: String, pass: String, stamps: Int) : this(id, name, pass) {
        this.stamps = stamps
    }
}
