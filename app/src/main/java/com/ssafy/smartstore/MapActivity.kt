package com.ssafy.smartstore

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.model.OpeningHours
import com.google.android.libraries.places.api.model.Period
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TimeOfWeek
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.ssafy.smartstore.databinding.ActivityMapBinding
import com.ssafy.smartstore.util.ImageConverter
import java.io.IOException
import java.lang.Exception
import java.util.*

private const val TAG = "MapActivity___"

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapBinding

    // 위치를 업데이트할 시간 간격
    private val UPDATE_INTERVAL = 1000 // 1초

    // 위치를 업데이트할 수 있는 가장 빠른 시간 간격
    private val FASTEST_UPDATE_INTERVAL = 500 // 0.5초

    private var map: GoogleMap? = null
    private var currentMarker: Marker? = null

    // 구글에서 제공하는 현재 위치 정보 업데이트 locationManager라고 보면됨
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var currentLocation: Location
    private lateinit var currentPosition: LatLng

    /** places 검색 추가.**/
    private lateinit var places: MutableList<Place>
    private lateinit var exMarker: MutableSet<Marker>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = UPDATE_INTERVAL.toLong()
            smallestDisplacement = 10.0f
            fastestInterval = FASTEST_UPDATE_INTERVAL.toLong()
        }

        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(locationRequest)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        places = arrayListOf()
        places.add(
            Place.builder()
                .setLatLng(LatLng(37.41, 126.66))
                .setName("싸피벅스")
                .setPhoneNumber("010-1234-5678")
                .setIconUrl("logo.png")
                .setOpeningHours(
                    OpeningHours.builder()
                        .setWeekdayText(arrayListOf("주중 : 07:00~20:30", "주말 : 09:00~22:00")).build()
                )
                .build()
        )
        exMarker = HashSet<Marker>()
    }

    override fun onStop() {
        super.onStop()
        // 위치 찾는 것을 멈춤
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0

        if (checkPermission()) { // 1. 위치 퍼미션을 가지고 있는지 확인
            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식)
            startLocationUpdates() // 3. 위치 업데이트 시작

        } else {  //2. 권한이 없다면
            // 3-1. 사용자가 권한이 없는 경우에는
            val permissionListener = object : PermissionListener {
                // 권한 얻기에 성공했을 때 동작 처리
                override fun onPermissionGranted() {
                    startLocationUpdates()
                }

                // 권한 얻기에 실패했을 때 동작 처리
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(
                        this@MapActivity,
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

    fun setCurrentLocation(location: Location) {
        currentMarker?.remove()

        val currentLatLng = LatLng(location.latitude, location.longitude)

        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f)
        map!!.animateCamera(cameraUpdate)
    }

    // 현재위치 찾아서 마커찍는 함수
    private fun startLocationUpdates() {
        if (checkPermission()) {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.myLooper()!!
            )
            // 현재 위치 찾는 버튼 활성화
            if (map != null) map!!.isMyLocationEnabled = true
            //2. +.- 줌 버튼 활성화
            if (map != null) map!!.uiSettings.isZoomControlsEnabled = true

            // 주변 장소 마커 생성
            showPlaceInformation()
        }
    }

    // 콜백 함수
    var locationCallback: LocationCallback = object : LocationCallback() {
        // 위치가 바뀔때마다, 일정 시간마다 호출됨
        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)
            // 위치 정보들이 리스트에 담김
            val locationList = locationResult.locations
            if (locationList.size > 0) {
                // 리스트에서 가장 최근 위치 가져옴
                val location = locationList[locationList.size - 1]
                currentPosition = LatLng(location.latitude, location.longitude)

                //현재 위치에 마커 생성하고 이동
                setCurrentLocation(location)
                currentLocation = location

            }
        }
    }

    fun getCurrentAddress(latlng: LatLng): String {
        //지오코더: GPS를 주소로 변환
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses: List<Address>?
        try {
            addresses = geocoder.getFromLocation(
                latlng.latitude,
                latlng.longitude,
                1
            )
        } catch (ioException: IOException) {
            //네트워크 문제
            Toast.makeText(this, "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show()
            return "지오코더 사용불가"
        } catch (illegalArgumentException: IllegalArgumentException) {
            Toast.makeText(this, "잘못된 GPS 좌표", Toast.LENGTH_LONG).show()
            return "잘못된 GPS 좌표"
        }

        return if (addresses == null || addresses.isEmpty()) {
            Toast.makeText(this, "주소 발견 불가", Toast.LENGTH_LONG).show()
            "주소 발견 불가"
        } else {
            val address = addresses[0]
            address.getAddressLine(0).toString()
        }
    }

    // 주변 가게 정보
    private fun showPlaceInformation() {
        // 마커 바꾸기
//        val bitmapdraw = ResourcesCompat.getDrawable(
//            resources,
//            R.drawable.ic_place_marker,
//            requireContext().theme
//        )!!.toBitmap(100, 100, null)
//        val marker = Bitmap.createScaledBitmap(bitmapdraw, 480, 480, false)

        for ((index, place) in places!!.withIndex()) {
            val markerSnippet = getCurrentAddress(place.latLng)
            val markerOptions = MarkerOptions()
            markerOptions.position(place.latLng)
            markerOptions.title(place.name)
            markerOptions.snippet(markerSnippet)
//            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(marker))
            val item = map!!.addMarker(markerOptions)
            item!!.tag = index
            exMarker.add(item!!)
        }

        map!!.setOnMarkerClickListener {
            val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
            val view = layoutInflater.inflate(R.layout.dialog_store_info, null)
            builder.setView(view)
            val name = view.findViewById<TextView>(R.id.tv_name)
            val tel = view.findViewById<TextView>(R.id.tv_tel)
            val image = view.findViewById<ImageView>(R.id.iv_logo)
            val weekday = view.findViewById<TextView>(R.id.tv_open_weekday)
            val weekend = view.findViewById<TextView>(R.id.tv_open_weekend)

            val place = places.get(it.tag as Int)
            name.text = place.name
            tel.text = place.phoneNumber
            ImageConverter.imageMap[place.iconUrl]?.let {
                image.setImageResource(
                    it
                )
            }
            weekday.text = place.openingHours.weekdayText[0]
            weekend.text = place.openingHours.weekdayText[1]

            val listener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    // 전화 걸기 버튼
                    DialogInterface.BUTTON_POSITIVE -> {
                        val uri = Uri.parse("tel:${tel.text}")

                        // 전환할 정보 설정 - ACTION_DIAL & 이동
                        startActivity(Intent(Intent.ACTION_DIAL, uri))
                    }
                    // 길 찾기 버튼
                    DialogInterface.BUTTON_NEGATIVE -> {    // 네이버 앱으로 길찾기 실행
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("nmap://route/public?dlat=${place.latLng.latitude}&dlng=${place.latLng.longitude}&dname=${place.name}")
                        ).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            setPackage("com.nhn.android.nmap")
                            try {
                                startActivity(this)
                            } catch (e: Exception) {    // 네이버 지도앱이 없을 경우 스토어로 이동
                                Log.d(TAG, "showPlaceInformation: $e")
                                Toast.makeText(
                                    this@MapActivity,
                                    "네이버 지도 앱이 필요합니다",
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse("market://details?id=com.nhn.android.nmap")
                                    )
                                )
                            }
                        }

                    }
                }
            }
            builder.setPositiveButton("전화 걸기", listener)
            builder.setNegativeButton("길찾기", listener)
            builder.show()
            true
        }
    }

    private fun checkPermission(): Boolean {
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        return hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED
    }
}