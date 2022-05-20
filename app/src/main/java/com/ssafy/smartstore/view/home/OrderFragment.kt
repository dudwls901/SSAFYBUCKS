package com.ssafy.smartstore.view.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ssafy.smartstore.adapter.OrderAdapter
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.databinding.FragmentOrderBinding
import com.ssafy.smartstore.viewmodel.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class OrderFragment : Fragment(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderAdapter

    private val productViewModel: ProductViewModel by activityViewModels()

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

        initViews()
    }

    private fun observeDatas(){
        productViewModel.productList.observe(viewLifecycleOwner) {
            updateListView(it)
        }
    }

    private fun updateListView(list: List<Product>){
        adapter.submitList(list)
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        // 메뉴 리사이클러뷰 어댑터 연결
        adapter = OrderAdapter().apply {
            setHasStableIds(true)
            itemOnClickListener = object : OrderAdapter.ItemOnClickListener {
                override fun onClick(view: View, position: Int) {
                    val action =OrderFragmentDirections.actionOrderFragmentToMenuDetailFragment(
                        productViewModel.productList.value!![position])
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

}