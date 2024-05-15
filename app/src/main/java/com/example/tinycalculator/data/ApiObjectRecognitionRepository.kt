package com.example.tinycalculator.data

import com.example.tinycalculator.network.CalculatorApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File
import java.io.IOException

class ApiObjectRecognitionRepository(
    private val calculatorApiService: CalculatorApiService
) : ObjectRecognitionRepository{
    override suspend fun getGrid(file: File): String {
        try {
            val response = calculatorApiService.getGrid(
                MultipartBody.Part.createFormData(
                    "file",
                    file.name,
                    file.asRequestBody()
                )
            )
            return response
        } catch (e: HttpException){
            throw e
        } catch (e: IOException){
            throw e;
        }

    }
}