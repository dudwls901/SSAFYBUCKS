package com.ssafy.admin_final_gumi0607_09.data.local.respositroy

import android.content.Context
import android.util.Log
import com.ssafy.admin_final_gumi0607_09.data.local.entity.Noti
import com.ssafy.admin_final_gumi0607_09.data.local.entity.TempNoti
import com.ssafy.smartstore.data.local.database.StoreDatabase


private const val TAG = " NotiRespository_sss"

class NotiRepository(context: Context) {
    private val db = StoreDatabase.getInstance(context)!!

    private val nDao = db.notiDao()

    suspend fun insert(noti: Noti): Int {
        nDao.insert(noti)
        return 0
    }


    suspend fun select(): List<Noti> {
        return nDao.select()
    }

    suspend fun insertTemp(tempNoti: TempNoti): Int {
        nDao.insertTemp(tempNoti)
        return 0
    }


    suspend fun selectTemp(): List<TempNoti> {
        return nDao.selectTemp()
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