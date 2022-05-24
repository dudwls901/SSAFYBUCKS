package com.ssafy.admin_final_gumi0607_09.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.BoxDataEntry
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.charts.Cartesian
import com.anychart.core.cartesian.series.Box
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentChartRatingBinding
import com.ssafy.admin_final_gumi0607_09.viewmodel.SaleViewModel


class ChartRatingFragment : Fragment() {

    private lateinit var binding: FragmentChartRatingBinding

    private val salesViewModel: SaleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChartRatingBinding.inflate(inflater, container, false)

        observeDatas()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        salesViewModel.getCommentList()
    }

    private fun observeDatas() {
        salesViewModel.commenttList.observe(viewLifecycleOwner) {
            initViews()
        }
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {
        makeBoxChart()
    }

    private fun makeBoxChart() {
        val boxChart: Cartesian = AnyChart.box()

        boxChart.animation(true)

        boxChart.xAxis(0).staggerMode(true)

        val data: MutableList<DataEntry> = ArrayList()

        val map = salesViewModel.commenttList.value!!.groupBy { it.productId }
        map.forEach {
            val name = salesViewModel.productList.value!!.find { product ->
                product.id == it.key
            }!!.name
            val max = (it.value.maxByOrNull { it.rating }?.rating ?: 0).toFloat() * 10
            val min = (it.value.minByOrNull { it.rating }?.rating ?: 0).toFloat() * 10
            val mid = it.value.map { it.rating }.average() * 10
            val q1 = (max - mid) / 2 + mid
            val q3 = mid - ((mid - min) / 2)
            data.add(
                CustomBoxDataEntry(
                    name,
                    min.toInt(),
                    q1.toInt(),
                    mid.toInt(),
                    q3.toInt(),
                    max.toInt(),
                    null
                )
            )
        }

        val box: Box = boxChart.box(data)

        box.whiskerWidth("20%")

        boxChart.tooltip().format(
            """function() {
            var percentOfTotal = (this.getData("value")*100)/this.getStat("sum");
                return '최고 평점: ' + this.getData("high")/10 +
                  '\n' + '평균 평점: ' + this.getData("median")/10 +
                  '\n' + '최저 평점: ' + this.getData("low")/10 ;
        }"""
        )

        binding.chart.setChart(boxChart)
    }

    private class CustomBoxDataEntry internal constructor(
        x: String?,
        low: Int?,
        q1: Int?,
        median: Int?,
        q3: Int?,
        high: Int?,
        outliers: Array<Int?>?
    ) :
        BoxDataEntry(x, low, q1, median, q3, high) {
        init {
            setValue("outliers", outliers)
        }
    }
}