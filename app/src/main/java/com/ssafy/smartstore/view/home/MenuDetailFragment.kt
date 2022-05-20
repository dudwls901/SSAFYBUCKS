package com.ssafy.smartstore.view.home

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.R
import com.ssafy.smartstore.StoreApplication
import com.ssafy.smartstore.StoreApplication.Companion.customAdd
import com.ssafy.smartstore.adapter.CommentAdapter
import com.ssafy.smartstore.data.local.dto.Product
import com.ssafy.smartstore.data.remote.dto.Comment
import com.ssafy.smartstore.databinding.FragmentMenuDetailBinding
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.util.ImageConverter
import com.ssafy.smartstore.viewmodel.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val TAG = "MenuDetailFragment_싸피"

class MenuDetailFragment : Fragment(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var binding: FragmentMenuDetailBinding

    private lateinit var commentAdapter: CommentAdapter

    private lateinit var product: Product
    private var commentList: List<Comment> = arrayListOf()

    private var user_id = ""

    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = requireActivity().getSharedPreferences("data", AppCompatActivity.MODE_PRIVATE)
        user_id = prefs.getString("id", "") ?: ""
        observeDatas()

    }
    override fun onStart() {
        super.onStart()
//        val productId = intent.getIntExtra("productId", -1)

        // 2가지방법 - 1. by navArgs()
        val safeArgs: MenuDetailFragmentArgs by navArgs()
        val productId = safeArgs.productId

// 2가지방법 - 2. fromBundle
//        arguments?.let {
//            val arguments = MenuDetailFragmentArgs.fromBundle(it)
//            val productId = arguments.productId
//        }

        Log.d(TAG, "onCreate: $productId")
        if(productId>=0){
            productViewModel.getProduct(productId)
            productViewModel.getCommentList(productId)
        }
    }

    private fun observeDatas(){
        productViewModel.responseGetProduct.observe(viewLifecycleOwner){
            //통신 성공
            if(it.isSuccessful){
                val response = it.body()
                response?.let{
                    product = it
                    Log.d(TAG, "observeDatas: ${product.id}")
                    // 제품 정보 세팅
                    binding.tvName.text = product.name
                    binding.tvPrice.text = product.price.toString()
                    ImageConverter.imageMap[product.img]?.let {
                        binding.ivItem.setImageResource(
                            it
                        )
                    }
                }
            }
            //통신 실패
            else{
                val errerResponse = it.errorBody()
            }
        }

        productViewModel.responseGetCommentList.observe(viewLifecycleOwner){
            if(it.isSuccessful){
                val response = it.body()
                response?.let{
                    commentList = it
                    commentAdapter.submitList(commentList)
                    commentAdapter.notifyDataSetChanged()
                    setRatingAvg()
                }
            }
            //통신 실패
            else{
                val errerResponse = it.errorBody()
            }
        }
        initViews()

    }


//    private suspend fun initData(productId: Int) {
//        withContext(Dispatchers.IO) {
//            commentList = commentRepo.selectByProduct(productId)
//        }
//        initViews()
//    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        // 코멘트 리사이클러뷰 연결
        commentAdapter = CommentAdapter(user_id).apply {
            submitList(commentList)
            onItemClickListener = object : CommentAdapter.OnItemClickListener {
                // 코멘트 수정 버튼
                override fun onUpdate(comment: Comment, position: Int) {
                    val builder = AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
                    builder.setTitle("코멘트 수정")
                    builder.setIcon(R.mipmap.ic_launcher)

                    val view = layoutInflater.inflate(R.layout.dialog_update_comment, null)
                    builder.setView(view)
                    val ratingBar = view.findViewById<RatingBar>(R.id.rating_bar)
                    val et: EditText = view.findViewById(R.id.et_comment)

                    et.setText(comment.comment)
                    ratingBar.rating = comment.rating

                    // findViewById를 통해 view를 가져와서 사용
                    val listener = DialogInterface.OnClickListener { dialog, which ->
                        val alert = dialog as AlertDialog
                        if (et.text.isNotEmpty()) {
                            launch {
                                productViewModel.updateComment(
                                    Comment(
                                        comment.id,
                                        user_id,
                                        product.id,
                                        ratingBar.rating * 2,
                                        et.text.toString()
                                    )
                                )
                                setRatingAvg()
                            }

                            Toast.makeText(requireContext(), "코멘트가 수정되었습니다", Toast.LENGTH_SHORT)
                                .show()
                        }
                        Toast.makeText(requireContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT)
                            .show()
                    }
                    builder.setPositiveButton("확인", listener)
                    builder.setNegativeButton("취소", null)
                    builder.show()
                }

                //코멘트 삭제버튼
                override fun onDelete(comment: Comment, position: Int) {
                    val builder = AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
                    builder.setTitle("코멘트 삭제")
                    builder.setMessage("정말 삭제하시겠습니까?")
                    builder.setIcon(R.mipmap.ic_launcher)

                    // 버튼 클릭시에 무슨 작업을 할 것인가!
                    val listener = DialogInterface.OnClickListener { dialog, which ->
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                launch {
                                    productViewModel.deleteComment(comment.id)
                                    setRatingAvg()
                                }
                                Toast.makeText(
                                    requireContext(),
                                    "코멘트가 삭제되었습니다",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            DialogInterface.BUTTON_NEGATIVE -> {
                                Toast.makeText(requireContext(), "취소 되었습니다", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                    builder.setPositiveButton("삭제", listener)
                    builder.setNegativeButton("취소", listener)
                    builder.show()
                }

            }

            rvComment.adapter = this
            rvComment.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            // 등록 버튼
            btnRegisterComment.setOnClickListener {
                if (etComment.text!!.isNotEmpty()) {
                    val builder = AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
                    builder.setTitle("코멘트 등록")
                    builder.setMessage("평점을 입력해주세요")
                    builder.setIcon(R.mipmap.ic_launcher)

                    val view = layoutInflater.inflate(R.layout.dialog_add_comment, null)
                    builder.setView(view)
                    val ratingBar = view.findViewById<RatingBar>(R.id.rating_bar)

                    // 버튼 클릭시에 무슨 작업을 할 것인가!
                    val listener = DialogInterface.OnClickListener { dialog, which ->
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                launch {
                                    productViewModel.insertComment(
                                        Comment(
                                            user_id,
                                            product.id,
                                            ratingBar.rating * 2,
                                            etComment.text.toString()
                                        )
                                    )
                                    setRatingAvg()
                                }

                                Toast.makeText(
                                    requireContext(),
                                    "코멘트가 등록되었습니다",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            DialogInterface.BUTTON_NEGATIVE -> {
                                Toast.makeText(requireContext(), "취소 되었습니다", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                    builder.setPositiveButton("등록", listener)
                    builder.setNegativeButton("취소", listener)
                    builder.show()
                } else {
                    Toast.makeText(
                        requireContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        setRatingAvg()

        // 수량 버튼 선택
        ivPlus.setOnClickListener {
            tvQuantity.text = (binding.tvQuantity.text.toString().toInt() + 1).toString()
        }

        ivMinus.setOnClickListener {
            if (tvQuantity.text.toString().toInt() > 0) {
                tvQuantity.text =
                    (tvQuantity.text.toString().toInt() - 1).toString()
            }
        }

        // 담기 버튼
        btnPut.setOnClickListener {
            val quantity = tvQuantity.text.toString().toInt()
            if (quantity > 0) {
                val orderProduct = OrderProduct(quantity, product)
                StoreApplication.shoppingList.customAdd(orderProduct)
//                finish()
            } else {
                Toast.makeText(requireContext(), "상품을 담아주세요", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    // 평점 평균
    fun setRatingAvg() {
        var total = 0.0F
        commentList.forEach {
            total += it.rating
        }
        total = Math.round((total / commentList.size) * 10) / 10F

        if (total.isNaN()) {
            binding.tvRating.text = "없음"
        } else {
            binding.tvRating.text = "${total}점"
            binding.ratingBar.rating = total / 2
        }
    }
}