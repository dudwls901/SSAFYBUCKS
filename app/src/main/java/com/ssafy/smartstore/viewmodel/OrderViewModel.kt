package com.ssafy.smartstore.viewmodel

import android.os.Build
import android.util.Log
import androidx.lifecycle.*
import com.ssafy.smartstore.StoreApplication
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.data.remote.RetrofitClient
import com.ssafy.smartstore.data.remote.dto.Order
import com.ssafy.smartstore.data.remote.dto.OrderDetail
import com.ssafy.smartstore.model.OrderInfo
import com.ssafy.smartstore.data.remote.dto.OrderInfoResponse
import com.ssafy.smartstore.data.remote.repository.OrderRepository
import com.ssafy.smartstore.data.remote.repository.ShoppingListRepository
import com.ssafy.smartstore.data.remote.repository.UserRepository
import com.ssafy.smartstore.event.Event
import com.ssafy.smartstore.model.OrderProduct
import kotlinx.coroutines.*
import retrofit2.Response

class OrderViewModel : ViewModel() {

    var job: Job? = null

    //코루틴 예외처리 핸들러
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    // 토스트 메시지 내용
    private val _toastMessage = MutableLiveData<Event<String>>()
    val toastMessage: LiveData<Event<String>> = _toastMessage

    // 다이얼로그 메시지 내용
    private val _dialogMessage = MutableLiveData<Event<Map<String, Any>>>()
    val dialogMessage: LiveData<Event<Map<String, Any>>> = _dialogMessage

    private var _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?>
        get() = _errorMessage

    private var _loading = MutableLiveData<Boolean>().apply {
        value = false
    }
    val loading: LiveData<Boolean>
        get() = _loading


    private val _orderInfoList = MutableLiveData<List<OrderInfo>>()
    val orderInfoList: LiveData<List<OrderInfo>>
        get() = _orderInfoList


    //    private val _responseGetProduct = MutableLiveData<Response<List<MutableMap<String,Any>>>>()
    private val _responseUserInfo = MutableLiveData<Response<Map<String, Any>>>()

    // 유저 정보 데이터 - grade 정보
    val responseUserInfo: LiveData<Response<Map<String, Any>>>
        get() = _responseUserInfo

    // 장바구니 데이터
    private val _shoppingList = MutableLiveData<List<OrderProduct>>()
    val shoppingList: LiveData<List<OrderProduct>>
        get() = _shoppingList

    // 장바구니 총 아이템 개수
    private val _orderCount = Transformations.map(_shoppingList) {
        var orderCount = 0
        for (orderProduct in it) {
            orderCount += orderProduct.quantity
        }
        "총 ${orderCount}개"
    }
    val orderCount: LiveData<String>
        get() = _orderCount

    // 장바구니 총 금액
    private val _priceSum = Transformations.map(_shoppingList) {
        var priceSum = 0
        var orderCount = 0

        for (orderProduct in it) {
            orderCount += orderProduct.quantity
            priceSum += orderProduct.quantity * orderProduct.product.price
        }
        "${priceSum}원"
    }
    val priceSum: LiveData<String>
        get() = _priceSum


    //결제창 호출할 수 있는지 여부
    private val _canCallBootPay = MutableLiveData<Event<Boolean>>()
    val canCallBootPay: LiveData<Event<Boolean>>
        get() = _canCallBootPay

    //주문(결제)성공 여부
    private val _orderComplete = MutableLiveData<Event<Boolean>>()
    val orderComplete: LiveData<Event<Boolean>>
        get() = _orderComplete


    init {
        _orderInfoList.value = emptyList()
        _shoppingList.value = emptyList()
    }

    fun getOrderMonth(id: String) = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<OrderInfoResponse>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = OrderRepository.INSTANCE.getOrderMonth(id)
        }
        job?.join()
        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    when (it.code()) {
                        200 -> {
                            _orderInfoList.postValue(changeOrderInfoList(result))
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    fun changeOrderInfoList(orderInfoResponseList: List<OrderInfoResponse>): List<OrderInfo> {
        var orderInfoList = mutableListOf<OrderInfo>()
        val quantityMap = mutableMapOf<Int, MutableMap<Int, Int>>()

        //orderList가져오기
        var orderList = orderInfoResponseList
//        val productMap = mutableMapOf<Int, MutableMap<Int, Product>>()
        val productList = ArrayList<Pair<Int, Product>>()
        for (order in orderList) {
            if (quantityMap[order.o_id].isNullOrEmpty()) {
                quantityMap[order.o_id] = mutableMapOf()
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                quantityMap.getOrDefault(order.o_id, mutableMapOf()).apply {
                    this.put(
                        order.p_id,
                        this.getOrDefault(order.p_id, 0) + order.quantity
                    )
                }
            } else {
                quantityMap[order.o_id] ?: mutableMapOf<Int, Int>().apply {
                    this.put(
                        order.p_id,
                        this[order.p_id] ?: 0 + order.quantity
                    )
                }
            }

            val product = Product(
                order.p_id,
                order.name,
                order.type,
                order.price,
                order.img
            )
            productList.add(Pair(order.o_id, product))

        }
        orderList = orderList.distinctBy { it.o_id }

        for (order in orderList) {
            val orderProductList = ArrayList<OrderProduct>()
            productList.forEach {
                val (id, product) = it
                if (order.o_id == id) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        orderProductList.add(
                            OrderProduct(
                                quantity = quantityMap[order.o_id]!!.getOrDefault(product.id, 0)!!,
                                product = product
                            )
                        )
                    } else {
                        orderProductList.add(
                            OrderProduct(
                                quantity = quantityMap[order.o_id]!![product.id] ?: 0,
                                product = product
                            )
                        )
                    }
                }
            }
            orderInfoList.add(
                OrderInfo(
                    id = order.o_id,
                    date = order.order_time,
                    orderProductList = orderProductList
                )
            )
        }
        return orderInfoList
//        orderInfoList = if (orderInfoList.size > 5) orderInfoList.subList(0, 4) else orderInfoList

    }

    fun getUserInfo(id: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            _loading.postValue(true)
            _responseUserInfo.postValue(UserRepository.INSTANCE.getInfo(id))
        }
        _loading.postValue(false)
    }

//    fun getProduct(productId: Int) = viewModelScope.launch {
//        _responseGetProduct.value = ProductRepository.INSTANCE.getProduct(productId)
//    }

    // 장바구니 정보 얻어오기
    fun getShoppingList(userId: String) = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<OrderProduct>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = ShoppingListRepository.INSTANCE.selectByUser(userId)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    when (it.code()) {
                        200 -> {
                            _shoppingList.postValue(result)
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    // 장바구니에 아이템들 추가
    fun addItem(item: Any, userId: String, type: String) = viewModelScope.launch {
        val map = HashMap<String, Any>()
        map.put("userId", userId)
        if (item is OrderInfo) {
            map.put("type", "list")
            map.put("orderProductList", item.orderProductList)
        } else if (item is OrderProduct) {
            map.put("product", item.product)
            map.put("quantity", item.quantity)
        }

        _loading.postValue(true)
        var response: Response<List<OrderProduct>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = ShoppingListRepository.INSTANCE.addShoppingList(map)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    when (it.code()) {
                        200 -> {
                            _shoppingList.postValue(result)
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    // 장바구니 아이템 하나 삭제
    fun deleteOneItem(map: HashMap<String, Any>) = viewModelScope.launch {
        _loading.postValue(true)
        var response: Response<List<OrderProduct>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = ShoppingListRepository.INSTANCE.deleteOneItem(map)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    when (it.code()) {
                        200 -> {
                            _shoppingList.postValue(result)
                            _loading.postValue(false)
                        }
                        else -> onError(it.message())
                    }
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }
    }

    //주문 완료되면 주문 내역 생성
    fun updateOrderDetails(userId: String) = viewModelScope.launch{

        val data = _shoppingList.value
        val order = Order(userId, StoreApplication.orderTable)
        val orderDetails =
            mutableListOf<OrderDetail>()
        data?.forEach {
            val orderDetail =
                OrderDetail(it.product.id, it.quantity)
            orderDetails.add(orderDetail)
        }
        order.details = orderDetails

        _loading.postValue(true)
        OrderRepository.INSTANCE.makeOrder(order)

        var response: Response<List<OrderProduct>>? = null
        job = launch(Dispatchers.Main + exceptionHandler) {
            response = ShoppingListRepository.INSTANCE.deleteByUser(userId)
        }
        job?.join()

        response?.let {
            if (it.isSuccessful) {
                it.body()?.let { result ->
                    when (it.code()) {
                        200 -> {
                            _shoppingList.postValue(result)
                            _toastMessage.value = Event("주문이 완료되었습니다")
                            Log.d("observer", "updateOrderDetails: ${toastMessage.value}")
                            _loading.postValue(false)
                            _orderComplete.postValue(Event(true))
                        }
                        else -> onError(it.message())
                    }
                }
            } else {
                it.errorBody()?.let { errorBody ->
                    RetrofitClient.getErrorResponse(errorBody)?.let {
                        onError(it.message)
                    }
                }
            }
        }

    }

    // 주문하기
    fun makeOrder(){
        // {orders=[{id=1, name=coffee1, type=coffee, price=1, img=coffee1.png, count=2}, {id=5, name=coffee5, type=coffee, price=5, img=coffee5.png, count=3}], userId=123}
        // orders의 id : prodcutId, count : quantity
        // 결제 불가
        if (!_shoppingList.value?.isEmpty()!!) {
            //결제 불가
            if (StoreApplication.orderTable == "") {
                _dialogMessage.value =
                    Event(hashMapOf(Pair("title", "알림"), Pair("message", "Table NFC를 먼저 찍어주세요")))
            } else { // 결제 가능
                _canCallBootPay.postValue(Event(true))
            }
        } else { //결제 불가
            _toastMessage.value = Event("상품을 담아주세요")

        }
    }

    private fun onError(message: String) {
        _errorMessage.value = message
        _loading.value = false

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}