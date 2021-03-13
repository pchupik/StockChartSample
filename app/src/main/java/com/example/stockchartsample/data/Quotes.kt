package com.example.stockchartsample.data

class Quotes(
    val content : Content,
    val status : String,
)

class Content(
    val quoteSymbols : List<Symbol>
)

class Symbol(
    val symbol: String,
    val timestamps: List<Long>,
    val opens: List<Float>,
    val closures: List<Float>,
    val highs: List<Float>,
    val lows: List<Float>,
    val volumes: List<Long>,
)