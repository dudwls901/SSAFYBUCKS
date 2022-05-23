package com.ssafy.admin_final_gumi0607_09.model
import android.os.Parcelable
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderProduct(
    var quantity: Int,
    val product: Product
): Parcelable


/*
 val bundle = Bundle()
 bundle.putParcelable(”selectedPerson”, person)
 intent.putExtra(”myBundle”,bundle)
 oncreate에서 받아오기
 val bundle = intent.getBundleExtra(”myBundle”)
 var person = bundle.getParcelable<Person>(”selectedPerson”)
 */
