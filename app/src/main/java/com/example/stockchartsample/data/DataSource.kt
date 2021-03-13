package com.example.stockchartsample.data

import com.example.stockchartsample.TheApp
import com.google.gson.Gson

interface DataSource {

    fun quotes() : Quotes?
}

class AssetsDataSource(private val fileName: String) : DataSource {

    override fun quotes(): Quotes? {
        val json = TheApp.context.assets
            .open(fileName)
            .bufferedReader()
            .use { it.readText() }

        return Gson().fromJson(json, Quotes::class.java)
    }

}