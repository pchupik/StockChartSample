package com.example.stockchartsample

import com.example.stockchartsample.ui.line.LineChartViewModel.Companion.calculatePerformance
import org.junit.Test

import org.junit.Assert.*

class CalculatePerformanceTest {

    @Test
    fun trivialCase() {
        val reference = 100f
        assertEquals(0f, calculatePerformance(reference, 100f))
        assertEquals(20f, calculatePerformance(reference, 120f))
        assertEquals(10f, calculatePerformance(reference, 110f))
        assertEquals(-10f, calculatePerformance(reference, 90f))
    }

    @Test
    fun referenceNot100(){
        val reference = 200f
        assertEquals(0f, calculatePerformance(reference, 200f))
        assertEquals(20f, calculatePerformance(reference, 240f))
        assertEquals(10f, calculatePerformance(reference, 220f))
        assertEquals(-10f, calculatePerformance(reference, 180f))
    }
}