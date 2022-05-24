package com.ssafy.smartstore.data.local.database



import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ssafy.admin_final_gumi0607_09.AdminApplication
import com.ssafy.admin_final_gumi0607_09.data.local.dao.NotiDao
import com.ssafy.admin_final_gumi0607_09.data.local.entity.Noti
import com.ssafy.admin_final_gumi0607_09.data.local.entity.TempNoti

@Database(entities = arrayOf(
    Noti::class,
    TempNoti::class
),
    version = 2
)
abstract class StoreDatabase: RoomDatabase() {

    abstract fun notiDao(): NotiDao

    companion object{
        var INSTANCE: StoreDatabase? = null

        fun getInstance(vararg context: Context): StoreDatabase?{
            if(INSTANCE ==null){
                synchronized(StoreDatabase::class){
                    if(context.isNullOrEmpty()) {
                        INSTANCE = Room.databaseBuilder(
                            AdminApplication.INSTANCE.applicationContext,
                            StoreDatabase::class.java,
                            "ssafy_mobile_cafe"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                    else{
                        INSTANCE = Room.databaseBuilder(
                            context[0],
                            StoreDatabase::class.java,
                            "ssafy_mobile_cafe"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}