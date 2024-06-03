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
import com.example.tinycalculator.ui.viewModels.HomeUiState
import com.example.tinycalculator.ui.viewModels.HomeViewModel
import com.example.tinycalculator.composables.CameraPreviewScreen


@Composable
fun StartScreen(
    homeViewModel: HomeViewModel,
    context: Context,
    onRequestReceived: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Log.d("Log", "StartScreen")

    if(homeViewModel.homeUiState == HomeUiState.Success){
        onRequestReceived(homeViewModel.grid)
    }

    if (homeViewModel.showCamera) {
        CameraPreviewScreen(homeViewModel)
    } else {
        if (homeViewModel.homeUiState == HomeUiState.Loading) {
            Image(
                modifier = modifier.size(200.dp),
                painter = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(R.string.Loading)
            )
        } else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                ErrorText(homeViewModel = homeViewModel)
                WelcomeText()
                WelcomeImage()
                LargeFloatingActionButton(
                    onClick = {
                        val permissionCheckResult =
                            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                            homeViewModel.showCamera = true
                        } else {
                            //TODO: ASK FOR PERMISSION
                            // https://google.github.io/accompanist/permissions/
                        }
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.calculate),
                        contentDescription = "Test",
                        modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize)
                    )
                }
            }
        }
    }
}

@Composable
fun WelcomeText() {
    Text(
        text = stringResource(R.string.welcome),
        fontSize = 40.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun WelcomeImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.title)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier.width(300.dp)
    )
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
