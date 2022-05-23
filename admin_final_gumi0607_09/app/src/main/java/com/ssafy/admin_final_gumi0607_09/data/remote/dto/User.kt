package com.ssafy.admin_final_gumi0607_09.data.remote.dto

data class User(

    var id: String,
    var pass: String,
) {
    var stamps: Int = 0

    var stampList: List<Stamp> = ArrayList()

    var name: String = ""

    constructor(id: String, name: String, pass: String) : this(id, pass) {
        this.name = name
    }

    constructor(id: String, name: String, pass: String, stamps: Int) : this(id, name, pass) {
        this.stamps = stamps
    }
}
