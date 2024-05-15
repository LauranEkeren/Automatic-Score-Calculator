package com.example.tinycalculator.ui.Screens

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.view.Surface
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.ImageCapture
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.content.FileProvider.getUriForFile
import com.example.tinycalculator.R
import com.example.tinycalculator.ui.ViewModels.HomeUiState
import com.example.tinycalculator.ui.ViewModels.HomeViewModel
import java.io.File




@Composable
fun StartScreen(
    homeViewModel: HomeViewModel,
    context: Context,
    file: File,
    uri: Uri,
    onRequestReceived: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Log.d("Debug", "StartScreen")
    var errorText = ""


    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            homeViewModel.getGrid(file)
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }








    when (homeViewModel.homeUiState) {
        is HomeUiState.Success -> onRequestReceived(homeViewModel.grid)
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
            Text(text = errorText)
            WelcomeText()
            WelcomeImage()
            LargeFloatingActionButton(
                onClick = {
                    val permissionCheckResult =
                        ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                        cameraLauncher.launch(uri)
                    } else {
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.calculate),
                    contentDescription = "Test",
                    modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize)
                )
            }
//
//        if (capturedImageUri.path?.isNotEmpty() == true){
//            Image(
//                modifier = Modifier
//                    .padding(16.dp, 8.dp),
//                painter = rememberAsyncImagePainter(capturedImageUri),
//                contentDescription = null
//            )
//        }
        }
    }
}

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.welcome),
        fontSize = 40.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun WelcomeImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.placeholder)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.width(300.dp)
    )
}
