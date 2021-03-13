package com.example.stockchartsample.ui.candle

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stockchartsample.data.DataSource
import com.example.stockchartsample.data.Quotes
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry

class CandleViewModel : ViewModel() {

    private val _data = MutableLiveData<CandleData?>()

    fun getData(source: DataSource) : LiveData<CandleData?> {
        if (_data.value == null) {
            _data.value = source.quotes()?.processData()
        }
        return _data
    }

    private fun Quotes.processData(): CandleData =
        CandleData(
            listOf(content
                .quoteSymbols
                .first()
                .run {
                    CandleDataSet(timestamps.mapIndexed { index, time ->
                        CandleEntry(
                            index.toFloat(),
                            highs[index],
                            lows[index],
                            opens[index],
                            closures[index]
                        )
                    }, symbol).apply {
                        setDrawIcons(false)
                        shadowColor = Color.DKGRAY
                        shadowWidth = 0.7f

                        decreasingColor = Color.RED
                        increasingColor = Color.GREEN
                        neutralColor = Color.BLUE
                    }
                })
        )

}


