package com.ssafy.smartstore

import android.app.Application
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.data.local.database.StoreDatabase

class StoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val db = StoreDatabase.getInstance(this)
    }

    companion object {
        var orderTable: String = ""

        var shoppingList = ArrayList<OrderProduct>()

        fun ArrayList<OrderProduct>.customAdd(newList: Any) {
            val originList = this
            if (newList is OrderProduct) {
                for (originOrderProduct in originList) {
                    //기존 장바구니에 상품이 있을 시
                    if (newList.product.id == originOrderProduct.product.id) {
                        originOrderProduct.quantity += newList.quantity
                        return
                    }
                }
                originList.add(newList)
            } else {
                loop@ for (newOrderProduct in newList as List<OrderProduct>) {
                    for (originOrderProduct in originList) {
                        //기존 장바구니에 상품이 있을 시
                        if (newOrderProduct.product.id == originOrderProduct.product.id) {
                            originOrderProduct.quantity += newOrderProduct.quantity
                            continue@loop
                        }
                    }
                    originList.add(newOrderProduct)
                }
            }
        }
    }
}