package com.example.tinycalculator.ui.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinycalculator.Domain.Factory
import com.example.tinycalculator.TinyCalculatorApplication
import com.example.tinycalculator.data.ApiObjectRecognitionRepository
import com.example.tinycalculator.data.ObjectRecognitionRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.File
import java.io.IOException

sealed interface  HomeUiState {
    object Success : HomeUiState
    object HttpError: HomeUiState
    object IOError: HomeUiState
    object Loading : HomeUiState
    object Empty: HomeUiState
}

class HomeViewModel(private val objectRecognitionRepository: ObjectRecognitionRepository) : ViewModel() {


    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Empty)
        private set

    var grid: String by mutableStateOf("")
        private set

    fun getGrid(file: File) {
        homeUiState = HomeUiState.Loading
        viewModelScope.launch {
            // This block causes the double call
            homeUiState = try {
                val gridResult = objectRecognitionRepository.getGrid(file)
                grid = gridResult
                HomeUiState.Success
            } catch (e: IOException){
                grid = ""
                HomeUiState.IOError
            }
            catch (e: HttpException){
                grid = ""
                HomeUiState.HttpError
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TinyCalculatorApplication)
                val objectRecognitionRepository = application.container.objectRecognitionRepository
                HomeViewModel(objectRecognitionRepository = objectRecognitionRepository)
            }
        }
    }
}