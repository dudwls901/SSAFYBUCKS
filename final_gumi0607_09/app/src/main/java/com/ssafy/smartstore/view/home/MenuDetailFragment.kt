package com.ssafy.smartstore.view.home

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.smartstore.R
import com.ssafy.smartstore.adapter.CommentAdapter
import com.ssafy.smartstore.data.remote.dto.Comment
import com.ssafy.smartstore.databinding.FragmentMenuDetailBinding
import com.ssafy.smartstore.model.OrderProduct
import com.ssafy.smartstore.util.ImageConverter
import com.ssafy.smartstore.util.MovableFloatingActionButton
import com.ssafy.smartstore.viewmodel.OrderViewModel
import com.ssafy.smartstore.viewmodel.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


private const val TAG = "MenuDetailFragment_싸피"

class MenuDetailFragment : Fragment(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var userId: String
    private lateinit var binding: FragmentMenuDetailBinding
    private lateinit var commentAdapter: CommentAdapter

    private val orderViewModel: OrderViewModel by activityViewModels()
    private val productViewModel: ProductViewModel by viewModels()

    private lateinit var callback: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.containerInfo.progress == 1.0F) {
                    binding.containerInfo.transitionToStart()
                } else {
                    findNavController().popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuDetailBinding.inflate(inflater, container, false)

        val prefs = requireActivity().getSharedPreferences("data", Context.MODE_PRIVATE)
        userId = prefs.getString("id", "") ?: ""

        observeDatas()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productVM = productViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initViews()
    }

    override fun onStart() {
        super.onStart()

        // 2가지방법 - 1. by navArgs()
        val safeArgs: MenuDetailFragmentArgs by navArgs()
        val product = safeArgs.product
        productViewModel.setProduct(product)
        productViewModel.getCommentList(product.id)
    }

    private fun observeDatas() {
        productViewModel.product.observe(viewLifecycleOwner) {
            ImageConverter.imageMap[it.img]?.let {
                binding.ivItem.setImageResource(
                    it
                )
            }
        }

        productViewModel.commentList.observe(viewLifecycleOwner) {
            Log.d(TAG, "commentList: ${it.size}")
            updateCommentList(it)
        }
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {

        // 코멘트 리사이클러뷰 연결
        commentAdapter = CommentAdapter(userId).apply {
            setHasStableIds(false)

            onItemClickListener = object : CommentAdapter.OnItemClickListener {

                // 코멘트 수정 버튼
                override fun onUpdate(comment: Comment, position: Int) {
                    updateComment(comment)
                }

                //코멘트 삭제버튼
                override fun onDelete(comment: Comment, position: Int) {
                    deleteComment(comment)
                }

            }

            rvComment.adapter = this
            rvComment.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            // 등록 버튼
            btnRegisterComment.setOnClickListener {
                if (etComment.text!!.isNotEmpty()) {
                    val comment = Comment(
                        userId,
                        productViewModel.product.value!!.id,
                        0.0f,
                        etComment.text.toString()
                    )
                    addComment(comment)
                    etComment.setText("")
                    etComment.clearFocus()
                } else {
                    Toast.makeText(
                        requireContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

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
                val orderProduct = OrderProduct(quantity, productViewModel.product.value!!)
                orderViewModel.addItem(orderProduct, userId, "list")
                findNavController().popBackStack()
                Toast.makeText(
                    requireContext(),
                    "${productViewModel.product.value!!.name} ${quantity}개를 장바구니에 담았습니다",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(requireContext(), "상품을 담아주세요", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        etComment.setOnFocusChangeListener { view, b ->
            if (b) {
                containerInfo.transitionToEnd()
            }
        }

        // 모션레이아웃 설정
        containerInfo.addTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                if (p0?.progress == 1.0F) {
                    requireActivity().findViewById<MovableFloatingActionButton>(R.id.fab_cart)
                        .hide()
                    btnPut.visibility = View.GONE
                    ivArrow.tag = "down"
                    ivArrow.setImageResource(R.drawable.ic_baseline_keyboard_double_arrow_down_40)
                    commentAdapter.state = true
                    commentAdapter.submitList(arrayListOf())
                    updateCommentList(productViewModel.commentList.value!!)
                } else if (p0?.progress == 0.0F) {
                    requireActivity().findViewById<MovableFloatingActionButton>(R.id.fab_cart)
                        .show()
                    btnPut.visibility = View.VISIBLE
                    ivArrow.tag = "up"
                    ivArrow.setImageResource(R.drawable.ic_baseline_keyboard_double_arrow_up_40)
                    etComment.apply {
                        clearFocus()
                        downKeyboard(this)
                    }
                    commentAdapter.state = false
                    commentAdapter.submitList(arrayListOf())
                    updateCommentList(productViewModel.commentList.value!!)
                }
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

        })

        // 코멘트 열고 닫기 버튼
        ivArrow.setOnClickListener {
            when (it.tag) {
                "down" -> containerInfo.transitionToStart()
                "up" -> containerInfo.transitionToEnd()
            }
        }
    }

    // 키보드 내리기
    private fun downKeyboard(etText: EditText) {
        val inputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(etText.windowToken, 0)
    }

    // 키보드 올리기
    private fun UpKeyboard(etText: EditText) {
        val inputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(etText, 0)
    }

    private fun updateComment(comment: Comment) {
        val builder = AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
        builder.setTitle("코멘트 수정")
        builder.setIcon(R.mipmap.ic_launcher_logo)

        val view = layoutInflater.inflate(R.layout.dialog_update_comment, null)
        builder.setView(view)
        val ratingBar = view.findViewById<RatingBar>(R.id.rating_bar)
        val et: EditText = view.findViewById(R.id.et_comment)

        et.setText(comment.comment)
        ratingBar.rating = comment.rating * 2

        // findViewById를 통해 view를 가져와서 사용
        val listener = DialogInterface.OnClickListener { dialog, which ->
            val alert = dialog as AlertDialog
            if (et.text.isNotEmpty()) {
                productViewModel.updateComment(
                    Comment(
                        comment.id,
                        userId,
                        productViewModel.product.value!!.id,
                        ratingBar.rating * 2,
                        et.text.toString()
                    )
                )
                Toast.makeText(requireContext(), "코멘트가 수정되었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "내용을 입력해주세요", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        builder.setPositiveButton("확인", listener)
        builder.setNegativeButton("취소", null)
        builder.show()
    }

    private fun deleteComment(comment: Comment) {
        val builder = AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
        builder.setTitle("코멘트 삭제")
        builder.setMessage("정말 삭제하시겠습니까?")
        builder.setIcon(R.mipmap.ic_launcher_logo)

        val listener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    productViewModel.deleteComment(comment.id)

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

    private fun addComment(comment: Comment) {
        val builder = AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
        builder.setTitle("코멘트 등록")
        builder.setMessage("평점을 입력해주세요")
        builder.setIcon(R.mipmap.ic_launcher_logo)

        val view = layoutInflater.inflate(R.layout.dialog_add_comment, null)
        builder.setView(view)
        val ratingBar = view.findViewById<RatingBar>(R.id.rating_bar)

        // 버튼 클릭시에 무슨 작업을 할 것인가!
        val listener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    comment.rating = ratingBar.rating * 2
                    launch {
                        productViewModel.insertComment(
                            comment
                        )
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

    }

    private fun updateCommentList(commentList: List<Comment>) {
        commentAdapter.submitList(commentList)
        binding.rvComment.adapter = commentAdapter
    }
}