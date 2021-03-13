package com.example.stockchartsample.ui.line

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stockchartsample.data.DataSource
import com.example.stockchartsample.data.Quotes
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate

class LineChartViewModel : ViewModel() {

    private val _data = MutableLiveData<LineData?>()

    fun getData(source: DataSource) : LiveData<LineData?> {
        if (_data.value == null) {
            _data.value = source.quotes()?.processData()
        }
        return _data
    }

    private fun Quotes.processData() : LineData {
        val sets = content
            .quoteSymbols
            .map { symbol ->
                LineDataSet( symbol
                    .opens // to get results based on Close data - change to closures
                    .calculatePerformance()
                    .mapIndexed { index, value -> Entry(index.toFloat(), value) },
                    symbol.symbol)
            }

        sets.forEachIndexed { index, set ->
            set.color = ColorTemplate.MATERIAL_COLORS[index % ColorTemplate.MATERIAL_COLORS.size]
            set.setDrawCircles(false)
        }

        return LineData(sets)
    }

    private fun List<Float>.calculatePerformance() = map {
        calculatePerformance(first(), it)
    }

    companion object {
        fun calculatePerformance(reference: Float, value: Float): Float =
            (value - reference) / reference * 100f
    }
}