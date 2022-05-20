package com.ssafy.smartstore

import android.app.Application
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.OpeningHours
import com.google.android.libraries.places.api.model.Place
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.data.local.database.StoreDatabase

class StoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }

    companion object {
        val INSTANCE = StoreApplication()

        var orderTable: String = ""

        var places = arrayListOf<Place>(
            Place.builder()
                .setLatLng(LatLng(37.41, 126.66))
                .setName("싸피벅스")
                .setPhoneNumber("010-1234-5678")
                .setIconUrl("logo.png")
                .setOpeningHours(
                    OpeningHours.builder()
                        .setWeekdayText(arrayListOf("주중 : 07:00~20:30", "주말 : 09:00~22:00")).build()
                )
                .build()
        )
    }
}