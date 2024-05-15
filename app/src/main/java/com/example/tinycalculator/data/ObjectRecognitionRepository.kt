package com.example.tinycalculator.data

import java.io.File

interface ObjectRecognitionRepository {
    suspend fun getGrid(file: File): String
}

