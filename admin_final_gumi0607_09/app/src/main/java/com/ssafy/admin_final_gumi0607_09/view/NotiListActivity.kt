package com.ssafy.admin_final_gumi0607_09.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.ssafy.admin_final_gumi0607_09.data.local.entity.Noti
import com.ssafy.admin_final_gumi0607_09.databinding.ActivityNotiListBinding
import com.ssafy.admin_final_gumi0607_09.viewmodel.OrderViewModel

class NotiListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotiListBinding

    private lateinit var adapter: NotiAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotiListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NotiAdapter()
        binding.rvNoti.adapter = adapter
        binding.rvNoti.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val bundle = intent.getBundleExtra("notiList")
        val list = bundle?.getParcelableArray("notiList")
//        Log.d("aaaa", "onCreate: ${list?.javaClass?.simpleName}")

        var notiList = mutableListOf<Noti>()
        list?.let {
            it.forEach {
                Log.d("aaaa", "onCreate: $it")
                notiList.add(it as Noti)

            }
        }
//        Log.d("aaaa", "onCreate: $notiList")
        adapter.submitList(notiList)

    }
}
