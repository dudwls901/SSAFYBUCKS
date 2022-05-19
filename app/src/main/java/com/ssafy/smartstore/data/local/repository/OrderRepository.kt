package com.ssafy.smartstore.data.local.repository

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.room.withTransaction
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.data.local.database.StoreDatabase
import com.ssafy.smartstore.data.local.dto.*
import com.ssafy.smartstore.model.OrderProduct

private const val TAG = " OrderRepository_sss"

class OrderRepository(context: Context) {
    private val db = StoreDatabase.getInstance(context)!!

    private val oDao = db.orderDao()
    private val odDao = db.orderDetailDao()
    private val sDao = db.stampDao()
    private val uDao = db.userDao()
    private val pDao = db.productDao()


    @RequiresApi(Build.VERSION_CODES.N)
    suspend fun getOrderInfoList(userId: String): List<OrderInfo> {

        val orderInfoList = ArrayList<OrderInfo>()
        val quantityMap = mutableMapOf<Int, Int>()

        Log.d(TAG, "getOrderInfoList: ${userId}")
        //orderList가져오기
        val orderList = getOrderByUser(userId)
        if (orderList.isEmpty()) return listOf()

        for (order in orderList) {
            val productMap = mutableMapOf<Int, Product>()
            //order에 속한 orderDetail가져오기
            odDao.selectByOrderId(order.o_id).forEach {
                //orderDetail에 속한 product 가져오기
                Log.d(TAG, "getOrderInfoList: orderDetail ${it}")
                val product = pDao.select(it.product_id).apply {
                    quantityMap.put(
                        it.product_id,
                        quantityMap.getOrDefault(it.product_id, 0) + it.quantity
                    )
                }
                Log.d(TAG, "getOrderInfoList: $product")
                productMap[it.product_id] = product
            }

            Log.d(TAG, "getOrderInfoList: ${order.order_time}")

            val orderProductList = ArrayList<OrderProduct>()
            productMap.forEach { id, product ->
                orderProductList.add(OrderProduct(
                    quantity = quantityMap[product.id]!!,
                    product= product
                )
                )
            }

            Log.d(TAG, "getOrderInfoList: $orderProductList")

            orderInfoList.add(
                OrderInfo(
                    id = order.o_id,
                    date = order.order_time,
                    orderProductList = orderProductList
                )
            )
        }
        Log.d(TAG, "getLastOrder: orderInfoList ${orderInfoList} ")
        return orderInfoList
    }

    suspend fun makeOrder(orderInfo: Map<String, Any>) = db.withTransaction {
        // 넘어온 데이터 예시
        // {orders=[{id=1, name=coffee1, type=coffee, price=1, img=coffee1.png, count=2}, {id=5, name=coffee5, type=coffee, price=5, img=coffee5.png, count=3}], userId=123}
        // orders의 id : prodcutId, count : quantity

        // 넘어온 데이터를 Order 타입으로 변환
        val userId = orderInfo["userId"] as String
        val orderDetails = orderInfo["orders"] as List<Map<String, Any>>
        val newOrderDetails: MutableList<OrderDetail> = ArrayList()
        for (orderDetail in orderDetails!!) {
            val newOrderDetail = OrderDetail(0, 0, 0, 0)
            newOrderDetail.product_id = (orderDetail["id"] as Int)
            newOrderDetail.quantity = (orderDetail["quantity"] as Int)
            newOrderDetails.add(newOrderDetail)
        }
        val order = Order("", "", "", 'N')
        order.user_id = (userId)
        order.details = (newOrderDetails)

        // 본격적인 주문 시작
        order.o_id = oDao.insert(order).toInt()
        Log.d(TAG, "makeOrder: ${order.o_id}")
        val orderDetailList: List<OrderDetail> = order.details
        var totalQuantity = 0
        for (orderDetail in orderDetailList) {
            orderDetail.order_id = (order.o_id)
            odDao.insert(orderDetail)
            totalQuantity += orderDetail.quantity
        }

        // 스탬프 적립
        val stamp = Stamp(order.user_id, order.o_id, totalQuantity)
        sDao.insert(stamp)

        // 유저의 스탬프양 업데이트
        val user: User = uDao.select(order.user_id)
        user.stamps = (user.stamps + totalQuantity)
        uDao.update(user)
    }

    suspend fun getOrderWithDetails(orderId: Int): Order = db.withTransaction {
        val order: Order = oDao.select(orderId)

        // detail가져와서 order에 추가
        val orderDetailList: List<OrderDetail> = odDao.selectByOrderId(orderId)
        order.details = orderDetailList
        order
    }

    suspend fun getOrderByUser(id: String): List<Order> {
        return oDao.selectByUser(id)
    }

    suspend fun updateOrder(order: Order) {
        oDao.update(order)
    }

    suspend fun selectOrderTotalInfo(productId: Int): List<OrderDetail> {
        return odDao.selectByProductId(productId)
    }

    suspend fun insert(order: Order): Long = db.orderDao().insert(order)

    suspend fun delete(orderId: Int): Int = db.orderDao().delete(orderId)

    suspend fun select(orderId: Int): Order = db.orderDao().select(orderId)

    suspend fun selectAll(): List<Order> = db.orderDao().selectAll()

    companion object {
        private var INSTANCE: OrderRepository? = null

        fun getInstance(context: Context): OrderRepository {
            if (INSTANCE == null) {
                INSTANCE = OrderRepository(context)
            }
            return INSTANCE ?: throw IllegalStateException("초기화해주세용.")
        }

    }

}