package com.ssafy.smartstore

import android.app.Application
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.data.local.database.StoreDatabase

class StoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }

    companion object {
        val INSTANCE = StoreApplication()

        var orderTable: String = ""
    }
}