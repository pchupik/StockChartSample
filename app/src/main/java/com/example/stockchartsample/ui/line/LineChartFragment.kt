package com.example.stockchartsample.ui.line

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stockchartsample.R
import com.example.stockchartsample.data.AssetsDataSource
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.formatter.PercentFormatter

abstract class LineChartFragment : Fragment() {

    private lateinit var lineChartViewModel: LineChartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lineChartViewModel = ViewModelProvider(this).get(LineChartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_line_chart, container, false)
        val lineChart: LineChart = root.findViewById(R.id.lineChart)
        lineChart.xAxis.setDrawLabels(false)
        lineChart.axisRight.valueFormatter = PercentFormatter()
        lineChart.axisLeft.valueFormatter = PercentFormatter()
        lineChart.description.isEnabled = false

        lineChartViewModel.getData(AssetsDataSource(fileName())).observe(viewLifecycleOwner, { lineChart.data = it })
        return root
    }

    abstract fun fileName() : String

}