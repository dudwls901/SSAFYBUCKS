package com.ssafy.admin_final_gumi0607_09

import android.app.Application

class AdminApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }

    companion object {
        val INSTANCE = AdminApplication()
    }
}