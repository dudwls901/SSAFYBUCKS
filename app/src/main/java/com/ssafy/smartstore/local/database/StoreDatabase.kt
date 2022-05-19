package com.ssafy.smartstore.local.database



import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ssafy.smartstore.local.dao.*
import com.ssafy.smartstore.local.dto.*

@Database(entities = arrayOf(
    User::class,
    Order::class,
    OrderDetail::class,
    Product::class,
    Stamp::class,
    Comment::class,
    Noti::class
),
    version = 6
)
abstract class StoreDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun stampDao(): StampDao
    abstract fun productDao(): ProductDao
    abstract fun orderDao(): OrderDao
    abstract fun orderDetailDao(): OrderDetailDao
    abstract fun commentDao(): CommentDao
    abstract fun notiDao(): NotiDao

    companion object{
        var INSTANCE: StoreDatabase? = null

        fun getInstance(context: Context): StoreDatabase?{
            if(INSTANCE ==null){
                synchronized(StoreDatabase::class){
                    INSTANCE = Room.databaseBuilder(context,
                            StoreDatabase::class.java,
                        "ssafy_mobile_cafe"
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}