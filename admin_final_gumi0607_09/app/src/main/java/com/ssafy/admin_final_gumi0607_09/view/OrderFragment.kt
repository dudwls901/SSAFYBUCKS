package com.ssafy.admin_final_gumi0607_09.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.admin_final_gumi0607_09.R
import com.ssafy.admin_final_gumi0607_09.data.remote.dto.Product
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentOrderBinding
import com.ssafy.admin_final_gumi0607_09.model.OrderInfo
import com.ssafy.admin_final_gumi0607_09.model.OrderProduct

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OrderAdapter()
        binding.orderRv.adapter = adapter

        initViews()
    }

    private fun initViews() = with(binding){
        updateListView()
    }

    private fun updateListView(){
        val list = listOf(
            OrderInfo(
                0,
                listOf(
                    OrderProduct(
                        2,
                        Product(
                            "아메리카노",
                            "coffe",
                            4000,
                            "coffe1.png"
                        )
                    ),
                    OrderProduct(
                        3,
                        Product(
                            "카페라떼",
                            "coffe",
                            5000,
                            "coffe2.png"
                        )
                    ),
                    OrderProduct(
                        2,
                        Product(
                            "망고쥬스",
                            "coffe",
                            6000,
                            "coffe3.png"
                        )
                    ),
                    OrderProduct(
                        1,
                        Product(
                            "우유",
                            "coffe",
                            4000,
                            "coffe5.png"
                        )
                    ),
                ),
                "날짜T날짜라라",
                "김싸피",
                "Y"
            ),
            OrderInfo(
                0,
                listOf(
                    OrderProduct(
                        2,
                        Product(
                            "아메리카노",
                            "coffe",
                            4000,
                            "coffe1.png"
                        )
                    ),
                    OrderProduct(
                        3,
                        Product(
                            "카페라떼",
                            "coffe",
                            5000,
                            "coffe2.png"
                        )
                    ),
                    OrderProduct(
                        2,
                        Product(
                            "망고쥬스",
                            "coffe",
                            6000,
                            "coffe3.png"
                        )
                    ),
                    OrderProduct(
                        1,
                        Product(
                            "우유",
                            "coffe",
                            4000,
                            "coffe5.png"
                        )
                    ),
                ),
                "날짜T날짜라라",
                "김싸피",
                "Y"
            )
        )
        adapter.submitList(list)
    }

    companion object {

    }
}