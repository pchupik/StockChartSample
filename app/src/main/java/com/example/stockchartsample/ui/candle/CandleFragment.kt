package com.example.stockchartsample.ui.candle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stockchartsample.R
import com.example.stockchartsample.data.AssetsDataSource
import com.github.mikephil.charting.charts.CandleStickChart

class CandleFragment : Fragment() {

    private val fileName = "responseQuotesMonth.json"

    private lateinit var candleViewModel: CandleViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        candleViewModel = ViewModelProvider(this).get(CandleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_candle_chart, container, false)
        val candleStickChart: CandleStickChart = root.findViewById(R.id.candleStickChart)
        candleStickChart.xAxis.setDrawLabels(false)
        candleStickChart.description.text = "data from $fileName"

        candleViewModel.getData(AssetsDataSource(fileName)).observe(viewLifecycleOwner, {
            candleStickChart.data = it
        })
        return root
    }
}