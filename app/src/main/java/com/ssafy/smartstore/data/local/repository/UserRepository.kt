package com.ssafy.smartstore.data.local.repository

import android.content.Context
import android.util.Log
import com.ssafy.smartstore.data.local.database.StoreDatabase
import com.ssafy.smartstore.data.local.dto.Order
import com.ssafy.smartstore.data.local.dto.OrderDetail
import com.ssafy.smartstore.data.local.dto.Stamp
import com.ssafy.smartstore.data.local.dto.User


private const val TAG = " UserRepository_sss"

class UserRepository() {
    private val db = StoreDatabase.getInstance()!!

    private val uDao = db.userDao()
    private val oDao = db.orderDao()
    private val odDao = db.orderDetailDao()
    private val sDao = db.stampDao()

    suspend fun join(user: User): Int {
        if (!isUsedId(user.id)) {
            uDao.insert(user)
            return 1
        }
        return 0
    }

    suspend fun login(id: String, pass: String): User?  {
        val user: User = uDao.select(id)
        if (user != null && user.pass == pass) {
            // t_stamp 에 있는 정보와 user가 가지고 있는 stamp정보 동기화
            val stamps: List<Stamp> = sDao.selectByUserId(id)
            if (!stamps.isEmpty()) {
                uDao.updateStamp(user.id)
                user.stampList = stamps
            }
            return user
        }
        return null
    }

    suspend fun leave(id: String) {
        uDao.delete(id)
    }

    suspend fun isUsedId(id: String): Boolean {
        val user: User = uDao.select(id)
        return if (user != null && user.id == id) {
            true
        } else false
    }

    suspend fun select(id: String): User? {
        return uDao.select(id)
    }

    suspend fun insert(user: User): Long {
        return uDao.insert(user)
    }

    suspend fun update(user: User): Int {
        return uDao.update(user)
    }

    suspend fun getInfo(userId: String): Map<String, Any>? {
        val user = uDao.select(userId)
        Log.d(TAG, "getInfo:${user}")

        // 해당 유적의 주문 리스트를 받아온다
        val orders: List<Order> = oDao.selectByUser(userId)

        // 각각 주문에 주문 상세를 넣는다
        for (order in orders) {
            val orderDetails: List<OrderDetail> = odDao.selectByOrderId(order.o_id)
            order.details = orderDetails
        }
//        val stamp = user.stamps

        // 보내는 데이터 예시
        // {stamp=3, orders=[Order [id=1, userId=id 01, orderTable=order_table 01, orderTime=Sun Mar 27 00:05:33 KST 2022, completed=N, details=[OrderDetail [id=1, orderId=1, productId=1, quantity=1], OrderDetail [id=2, orderId=1, productId=2, quantity=3]]],
        // 					 Order [id=2, userId=id 01, orderTable=order_table 02, orderTime=Sun Mar 27 00:05:33 KST 2022, completed=N, details=[]]]}
        // orders : 주문 목록, stamp : 유저 스탬프 총 개수
        val map: MutableMap<String, Any> = HashMap()
//        map["orders"] = orders
//        map["stamp"] = stamp
        return map
    }

    suspend fun selectAll() = db.userDao().selectAll()

    suspend fun delete(userId: String) = db.userDao().delete(userId)


    companion object {
        private var INSTANCE: UserRepository? = null

        fun getInstance(): UserRepository {
            if (INSTANCE == null) {
                INSTANCE = UserRepository()
            }
            return INSTANCE ?: throw IllegalStateException("초기화해주세용.")
        }

    }

}