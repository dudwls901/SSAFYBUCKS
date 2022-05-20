package com.ssafy.smartstore.view.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.Place
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.ssafy.smartstore.StoreApplication.Companion.places
import com.ssafy.smartstore.adapter.OrderAdapter
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.databinding.FragmentOrderBinding
import com.ssafy.smartstore.viewmodel.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.math.floor
import kotlin.math.round

private const val TAG = "OrderFragment"

class OrderFragment : Fragment(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderAdapter

    private val productViewModel: ProductViewModel by activityViewModels()

    private val locationManager by lazy {
        requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)

        observeDatas()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel.getProductList()

        checkPermission()

        initViews()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    override fun onResume() {
        super.onResume()
        if (isPermitted()) {
            locationManager.also {
                it.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 1000, 10f, listener
                )
                it.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 1000, 10f, listener
                )
            }
        }
    }

    // 배터리 소모를 줄이기 위해 pause되면 멈춤
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onPause() {
        super.onPause()
        if (isPermitted()) {
            locationManager.removeUpdates(listener)
        }
    }

    private fun observeDatas() {
        productViewModel.productList.observe(viewLifecycleOwner) {
            updateListView(it)
        }
    }

    private fun updateListView(list: List<Product>) {
        adapter.submitList(list)
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        // 메뉴 리사이클러뷰 어댑터 연결
        adapter = OrderAdapter().apply {
            setHasStableIds(true)
            itemOnClickListener = object : OrderAdapter.ItemOnClickListener {
                override fun onClick(view: View, position: Int) {
                    val action = OrderFragmentDirections.actionOrderFragmentToMenuDetailFragment(
                        productViewModel.productList.value!![position]
                    )
                    findNavController().navigate(action)
                }

            }

            rvMenu.adapter = this
            rvMenu.layoutManager = GridLayoutManager(requireContext(), 3)
        }

        // 장바구니 버튼
        fabCart.setOnClickListener {
            val action = OrderFragmentDirections.actionOrderFragmentToShoppingListFragment()
            findNavController().navigate(action)
        }

        // 지도 버튼
        ivMap.setOnClickListener {
            Intent(requireContext(), MapActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    @SuppressLint("MissingPermission")
    // getLastKnownLocation을 호출하여 이전에 기록된 위치가 있다면 가져옴
    private fun getLastLocation() {
        locationManager
            .getLastKnownLocation(LocationManager.GPS_PROVIDER)
            .apply {
                if (this != null) {
                    calculateDistance(longitude, latitude)
                } else {
                    locationManager
                        .getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                        .apply {
                            if (this != null) {
                                calculateDistance(longitude, latitude)
                            }
                        }
                }
            }
    }

    // 기기의 Provider들의 정보를 가져온 뒤 각 Provider별 동작 여부를 확인 후 업데이트 진행
    @SuppressLint("MissingPermission")
    private fun getProviders() {
        val providerList = locationManager.allProviders as MutableList<String>
        val isEnable = BooleanArray(3)
        for (provider in providerList) {
            when (provider) {
                LocationManager.GPS_PROVIDER -> {
                    isEnable[0] = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                    locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        1000,
                        10f,
                        listener
                    )
                    Log.d(TAG, provider + '/' + isEnable[0].toString())
                }
                LocationManager.NETWORK_PROVIDER -> {
                    isEnable[1] =
                        locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
                    locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        1000,
                        10f,
                        listener
                    )
                    Log.d(TAG, provider + '/' + isEnable[1].toString())
                }
            }
        }
    }

    // 리스너 구현
    private val listener = object : LocationListener {

        // 위치가 변경될때 호출될 method
        override fun onLocationChanged(location: Location) {
            when (location.provider) {
                LocationManager.GPS_PROVIDER -> {
                    calculateDistance(location.longitude, location.latitude)
                }
                LocationManager.NETWORK_PROVIDER -> {
                    calculateDistance(location.longitude, location.latitude)
                }
            }
        }

        // 상단바 위치 꺼져있을 때
        override fun onProviderDisabled(provider: String) {
            //super.onProviderDisabled(provider)
        }

        // 상단바 위치 켰을때
        @RequiresApi(Build.VERSION_CODES.M)
        @SuppressLint("MissingPermission")
        override fun onProviderEnabled(provider: String) {
            if (isPermitted()) {
                locationManager.also {
                    it.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, 0, 0f, this
                    )
                    it.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER, 0, 0f, this
                    )
                }
            }
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
    }

    private fun calculateDistance(longitude: Double, latitude: Double) {
        Log.d(TAG, "calculateDistance: $longitude $latitude")
        var minLongitude = Double.MAX_VALUE
        var minLatitude = Double.MAX_VALUE
        var min = Double.MAX_VALUE
        for (place in places) {
            var diff1 = Math.abs(place.latLng.longitude.minus(longitude))
            var diff2 = Math.abs(place.latLng.latitude.minus(latitude))

            if (Math.sqrt(diff1 * diff1 + diff2 * diff2) < min) {
                min = Math.sqrt(diff1 * diff1 + diff2 * diff2)
                minLongitude = Math.min(minLongitude, diff1)
                minLatitude = Math.min(minLatitude, diff2)
            }
        }

        var n1 = floor(minLongitude)
        var n2 = floor((minLongitude - n1) * 100)
        var n3 = floor(((minLongitude - n1) * 100 - n2) * 100)

        val result1 = n1 * 88804 + n2 * 1480 + n3 * 24.668

        n1 = floor(minLatitude)
        n2 = floor((minLatitude - n1) * 100)
        n3 = floor(((minLatitude - n1) * 100 - n2) * 100)
        val result2 = n1 * 111195 + n2 * 1853 + n3 * 30.887

        var distance = Math.sqrt(result1 * result1 + result2 * result2)
        Log.d(TAG, "calculateDistance: $distance")

        if (distance > 1000) {
            distance /= 1000
            distance = round((distance * 100)) / 100
            binding.tvDistanceInfo.text = "매장과의 거리가 ${distance}km 입니다"
        } else {
            binding.tvDistanceInfo.text = "매장과의 거리가 ${distance.toInt()}m 입니다"
        }
    }

    // 권한을 획득했는지 확인
    @RequiresApi(Build.VERSION_CODES.M)
    private fun isPermitted(): Boolean {
        return checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PermissionChecker.PERMISSION_GRANTED
    }

    private fun checkPermission() {
        val permissionListener: PermissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
                getLastLocation()
                getProviders()
            }

            override fun onPermissionDenied(deniedPermissions: List<String>) {
                Toast.makeText(
                    requireContext(),
                    "위치 권한이 거부되었습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        TedPermission.create()
            .setPermissionListener(permissionListener)
            .setDeniedMessage("[설정] 에서 위치 접근 권한을 부여해야만 사용이 가능합니다.")
            .setPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .check()
    }

}