package com.example.tinycalculator.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinycalculator.TinyCalculatorApplication
import com.example.tinycalculator.data.ObjectRecognitionRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.File
import java.io.IOException


sealed interface  HomeUiState {
    data object Success : HomeUiState
    data object HttpError: HomeUiState
    data object IOError: HomeUiState
    data object Loading : HomeUiState
    data object Empty: HomeUiState
}

class HomeViewModel(private val objectRecognitionRepository: ObjectRecognitionRepository) : ViewModel() {


    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Empty)
        private set

    var grid: String by mutableStateOf("")
        private set

    var showCamera: Boolean by mutableStateOf(false)

    fun resetHomeViewModel(){
        homeUiState = HomeUiState.Empty
        grid = ""
        showCamera = false
    }

    fun photoTaken(file: File) {
        homeUiState = HomeUiState.Loading
        viewModelScope.launch {
            homeUiState = try {
                val gridResult = objectRecognitionRepository.getGrid(file)
                grid = gridResult
                HomeUiState.Success
            }
            catch (e: IOException){
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