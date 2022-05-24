package com.ssafy.admin_final_gumi0607_09.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.core.cartesian.series.Bar
import com.anychart.core.cartesian.series.JumpLine
import com.anychart.data.Set
import com.anychart.enums.HoverMode
import com.anychart.enums.TooltipDisplayMode
import com.anychart.enums.TooltipPositionMode
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentChartVerticalBinding
import com.ssafy.admin_final_gumi0607_09.viewmodel.SaleViewModel


class ChartVerticalFragment : Fragment() {

    private lateinit var binding: FragmentChartVerticalBinding

    private val salesViewModel: SaleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChartVerticalBinding.inflate(inflater, container, false)

        observeDatas()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        salesViewModel.getProductANDDeatilList()
    }

    private fun observeDatas() {
        salesViewModel.orderDetailList.observe(viewLifecycleOwner) {
            salesViewModel.getProductQuantityANDSales()
        }
        salesViewModel.productSales.observe(viewLifecycleOwner) {
            initViews()
        }
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {
        makeVerticalChart()
    }

    private fun makeVerticalChart() {
        val vertical = AnyChart.vertical()

        vertical.animation(true)

        val data: MutableList<DataEntry> = ArrayList()
        salesViewModel.productSales.value!!.forEach { map ->
            val name = salesViewModel.productList.value!!.find { it.id == map.key.toInt() }!!.name
            val quantity = salesViewModel.productQuantity.value!!.filter {
                it.key == map.key
            }.map { it.value }.get(0)
            Log.d("quantity", "initViews: $quantity")
            data.add(CustomDataEntry("${name}", map.value, quantity))
        }

        val set = Set.instantiate()
        set.data(data)
        val barData = set.mapAs("{ x: 'x', value: 'value' }")
        val jumpLineData = set.mapAs("{ x: 'x', value: 'jumpLine' }")

        val bar: Bar = vertical.bar(barData)
        bar.labels().format("{%Value}")
        val jumpLine: JumpLine = vertical.jumpLine(jumpLineData)
        jumpLine.labels().enabled(false)

        vertical.yScale().minimum(0.0)
        vertical.labels(true)

        vertical.tooltip()
            .displayMode(TooltipDisplayMode.UNION)
            .positionMode(TooltipPositionMode.POINT)
            .unionFormat(
                """function() {
                  return '판매량: '+ this.points[1].value + ' 개' +
                    '\n' + '매출: ' + this.points[0].value + ' 원';
                }"""
            )

        vertical.interactivity().hoverMode(HoverMode.BY_X)

        vertical.xAxis(true)
        vertical.yAxis(true)
        vertical.yAxis(0).labels().format("{%Value}{groupsSeparator:\\,} 원")

        binding.chart.setChart(vertical)
    }

    inner class CustomDataEntry(x: String?, value: Number?, jumpLine: Number?) :
        ValueDataEntry(x, value) {
        init {
            setValue("jumpLine", jumpLine)
        }
    }
}