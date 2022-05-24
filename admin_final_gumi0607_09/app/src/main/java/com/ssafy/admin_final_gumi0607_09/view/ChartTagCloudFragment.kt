package com.ssafy.admin_final_gumi0607_09.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.CategoryValueDataEntry
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.enums.TooltipDisplayMode
import com.anychart.enums.TooltipPositionMode
import com.anychart.scales.LinearColor
import com.anychart.scales.OrdinalColor
import com.ssafy.admin_final_gumi0607_09.R
import com.ssafy.admin_final_gumi0607_09.databinding.FragmentChartTagCloudBinding
import com.ssafy.admin_final_gumi0607_09.viewmodel.SaleViewModel

class ChartTagCloudFragment : Fragment() {

    private lateinit var binding: FragmentChartTagCloudBinding

    private val salesViewModel: SaleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChartTagCloudBinding.inflate(layoutInflater, container, false)

        observeDatas()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeDatas() {
        salesViewModel.commenttList.observe(viewLifecycleOwner) {
            initViews()
        }
    }

    //뷰들 초기화
    private fun initViews() = with(binding) {
        makeTagCloudChart()
    }

    private fun makeTagCloudChart() {
        val tagCloud = AnyChart.tagCloud()

        tagCloud.animation(true)

//        var customColorScale = LinearColor.instantiate()
//        customColorScale.colors(arrayOf("#ffcc00", "#00ccff"))
//        tagCloud.colorScale(customColorScale)


        val ordinalColor = OrdinalColor.instantiate()
        ordinalColor.colors(
            arrayOf(
                "#BC2221",
                "#EE710B",
                "#FDD600",
                "#BC2221",
                "#007538",
                "#006B70",
                "#0067A3",
                "#292E57",
                "#67307A",
                "#871B4D"
            )
        )
        tagCloud.colorScale(ordinalColor)
        tagCloud.angles(arrayOf(-90.0, 0.0, 90.0))

        tagCloud.colorRange().enabled(true)
        tagCloud.colorRange().colorLineSize(30.0)

        val data: MutableList<DataEntry> = ArrayList()
        val map = mutableMapOf<String, MutableMap<String, Any>>()
        salesViewModel.commenttList.value!!.forEach { comment ->
            var list = comment.comment.split(" ")
            list = list.map { it.replace(".", "") }
            val name = salesViewModel.productList.value!!.find {
                it.id == comment.productId
            }!!.name
            list.forEach {
                if (map.get(it) == null) map.put(
                    it, mutableMapOf(
                        Pair("product", name),
                        Pair("count", 1)
                    )
                )
                else map.get(it)!!.put("count", (map.get(it)!!.get("count") as Int) + 1)
            }
        }

        map.forEach {
            Log.d(
                "TAG",
                "${it.key} ${it.value.get("product") as String} ${it.value.get("count") as Int}"
            )
            data.add(
                CategoryValueDataEntry(
                    it.key,
                    it.value.get("product") as String,
                    it.value.get("count") as Int
                )
            )
        }
        tagCloud.data(data)
        tagCloud.tooltip().format(
            """function() {
            var percentOfTotal = (this.getData("value")*100)/this.getStat("sum");
                return '횟수: ' + this.getData("value") +
                  '\n' + '퍼센트: ' + percentOfTotal.toFixed(1) + '%' ;
        }"""
        )

        binding.chart.setChart(tagCloud)
    }
}