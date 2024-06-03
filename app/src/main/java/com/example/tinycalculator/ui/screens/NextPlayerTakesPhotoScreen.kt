package com.example.tinycalculator.ui.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.tinycalculator.R
import com.example.tinycalculator.composables.CameraPreviewScreen
import com.example.tinycalculator.ui.viewModels.HomeUiState
import com.example.tinycalculator.ui.viewModels.HomeViewModel

@Composable
fun NextPlayerTakesPhotoScreen(
    homeViewModel: HomeViewModel,
    onRequestReceived: (String) -> Unit,
) {
    Log.d("Log", "NextPlayer takesPhoto")
    if(homeViewModel.homeUiState == HomeUiState.Success){
        onRequestReceived(homeViewModel.grid)
    }
    CameraPreviewScreen(homeViewModel)
}



@Composable
private fun ErrorText(homeViewModel: HomeViewModel){
    var errorText = ""
    when (homeViewModel.homeUiState) {

        is HomeUiState.Success -> {
            errorText = ""
        }
        is HomeUiState.IOError -> {
            errorText = stringResource(R.string.io_error_text)
        }
        is HomeUiState.HttpError -> {
            errorText = stringResource(R.string.api_error_text)
        }
        is HomeUiState.Empty -> {
            errorText = ""
        }
        is HomeUiState.Loading -> {
            errorText = ""
        }
    }
    Text(text = errorText)
}
