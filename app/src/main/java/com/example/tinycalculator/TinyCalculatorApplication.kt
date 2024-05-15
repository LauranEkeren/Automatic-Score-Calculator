package com.example.tinycalculator

import android.app.Application
import com.example.tinycalculator.data.AppContainer
import com.example.tinycalculator.data.DefaultAppContainer

class TinyCalculatorApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}