package com.ssafy.admin_final_gumi0607_09.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentSalesBinding
import com.ssafy.admin_final_gumi0607_09.viewmodel.SaleViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*


class SalesFragment : Fragment(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private lateinit var binding: FragmentSalesBinding

    private val salesViewModel: SaleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSalesBinding.inflate(inflater, container, false)

        observeDatas()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        salesViewModel.getProductList()
        salesViewModel.getOrderDeatilList()

        initViews()
    }

    private fun observeDatas() {
        salesViewModel.productList.observe(viewLifecycleOwner) {

        }
        salesViewModel.orderDetailList.observe(viewLifecycleOwner) {

        }
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {
        configureChartAppearance()
        prepareChartData(createChartData()!!)
    }
    private fun configureChartAppearance() {
        binding.chart.getDescription().setEnabled(false) // chart 밑에 description 표시 유무
        binding.chart.setTouchEnabled(false) // 터치 유무
        binding.chart.getLegend().setEnabled(false) // Legend는 차트의 범례
        binding.chart.setExtraOffsets(10f, 0f, 40f, 0f)

        // XAxis (수평 막대 기준 왼쪽) - 선 유무, 사이즈, 색상, 축 위치 설정
        val xAxis: XAxis = binding.chart.getXAxis()
        xAxis.setDrawAxisLine(false)
        xAxis.granularity = 1f
        xAxis.textSize = 15f
        xAxis.gridLineWidth = 25f
        xAxis.gridColor = Color.parseColor("#80E5E5E5")
        xAxis.position = XAxis.XAxisPosition.BOTTOM // X 축 데이터 표시 위치

        // YAxis(Left) (수평 막대 기준 아래쪽) - 선 유무, 데이터 최솟값/최댓값, label 유무
        val axisLeft: YAxis = binding.chart.getAxisLeft()
        axisLeft.setDrawGridLines(false)
        axisLeft.setDrawAxisLine(false)
        axisLeft.axisMinimum = 0f // 최솟값
        axisLeft.axisMaximum = 50f // 최댓값
        axisLeft.granularity = 1f // 값만큼 라인선 설정
        axisLeft.setDrawLabels(false) // label 삭제

        // YAxis(Right) (수평 막대 기준 위쪽) - 사이즈, 선 유무
        val axisRight: YAxis = binding.chart.getAxisRight()
        axisRight.textSize = 15f
        axisRight.setDrawLabels(false) // label 삭제
        axisRight.setDrawGridLines(false)
        axisRight.setDrawAxisLine(false)

        val products = arrayListOf<String>("아메리카노","카페라떼","카라멜 마끼아도","카푸치노","카푸치노")

        // XAxis에 원하는 String 설정하기 (앱 이름)
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                Log.d("TAG", "getFormattedValue: $value")
                return products[value.toInt()]
            }
        }
    }

    private fun createChartData(): BarData? {
        val MAX_X_VALUE = 5
        val MAX_Y_VALUE = 50
        val MIN_Y_VALUE = 0

        // 1. [BarEntry] BarChart에 표시될 데이터 값 생성
        val values: ArrayList<BarEntry> = ArrayList()
        for (i in 0 until MAX_X_VALUE) {
            val x = i.toFloat()
            val y: Float = Random().nextFloat() * (MAX_Y_VALUE - MIN_Y_VALUE) + MIN_Y_VALUE
            values.add(BarEntry(x, y))
        }

        // 2. [BarDataSet] 단순 데이터를 막대 모양으로 표시, BarChart의 막대 커스텀
        val set2 = BarDataSet(values, "asd")
        set2.setDrawIcons(false)
        set2.setDrawValues(true)
        set2.color = Color.parseColor("#66767676") // 색상 설정
        // 데이터 값 원하는 String 포맷으로 설정하기 (ex. ~회)
        set2.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return (value.toString())+"회"
            }
        }

        // 3. [BarData] 보여질 데이터 구성
        val data = BarData(set2)
        data.barWidth = 0.5f
        data.setValueTextSize(15f)
        return data
    }

    private fun prepareChartData(data: BarData) {
        binding.chart.setData(data) // BarData 전달
        binding.chart.invalidate() // BarChart 갱신해 데이터 표시
    }
}