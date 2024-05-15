package com.example.tinycalculator.data

import com.example.tinycalculator.network.CalculatorApiService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class DefaultAppContainer : AppContainer {
    private val baseUrl =
        "http://localhost:5000/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    private val retrofitService : CalculatorApiService by lazy {
        retrofit.create(CalculatorApiService::class.java)
    }

    override val objectRecognitionRepository: ObjectRecognitionRepository by lazy {
        ApiObjectRecognitionRepository(retrofitService)
    }

}