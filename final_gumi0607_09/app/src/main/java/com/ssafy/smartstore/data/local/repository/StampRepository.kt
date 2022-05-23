package com.ssafy.smartstore.data.local.repository

import android.content.Context
import com.ssafy.smartstore.data.local.database.StoreDatabase
import com.ssafy.smartstore.data.local.dto.Stamp

private const val TAG = " StampRepository_sss"
class StampRepository() {
    private val db = StoreDatabase.getInstance()!!

    private val sDao = db.stampDao()

    suspend fun selectByUser(id: String): List<Stamp?>? {
        return sDao.selectByUserId(id)
    }

    suspend fun insert(stamp: Stamp): Long = sDao.insert(stamp)

    suspend fun select(stampId: Int): Stamp = sDao.select(stampId)

    suspend fun selectAll(): List<Stamp> =sDao.selectAll()

    suspend fun selectByUserId(userId: String): List<Stamp> = sDao.selectByUserId(userId)


    companion object{
        private var INSTANCE: StampRepository? = null

        fun getInstance(): StampRepository{
            if(INSTANCE==null){
                INSTANCE = StampRepository()
            }
            return  INSTANCE?: throw IllegalStateException("초기화해주세용.")
        }

    }

}