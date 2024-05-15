package com.example.tinycalculator.network

import okhttp3.MultipartBody
import retrofit2.http.POST
import retrofit2.http.Multipart
import retrofit2.http.Part

interface CalculatorApiService {
    @Multipart
    @POST("success")
    suspend fun getGrid(
        @Part file: MultipartBody.Part) : String


}
