package com.ssafy.smartstore.data.local.repository

import android.content.Context
import android.util.Log
import com.ssafy.smartstore.data.local.database.StoreDatabase
import com.ssafy.smartstore.data.local.dto.*


private const val TAG = " NotiRespository_sss"

class NotiRepository(context: Context) {
    private val db = StoreDatabase.getInstance(context)!!

    private val nDao = db.notiDao()

    suspend fun insert(noti: Noti): Int {
        nDao.insert(noti)
        return 0
    }


    suspend fun select(id: String): List<Noti> {
        return nDao.select(id)
    }

    suspend fun delete(id: Int): Int{
        Log.d(TAG, "noti delete: $id")
        nDao.delete(id)
        return 0
    }


    companion object {
        private var INSTANCE: NotiRepository? = null

        fun getInstance(context: Context): NotiRepository {
            if (INSTANCE == null) {
                INSTANCE = NotiRepository(context)
            }
            return INSTANCE ?: throw IllegalStateException("초기화해주세용.")
        }

    }

}