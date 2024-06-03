package com.example.tinycalculator.composables

import android.content.Context
import android.util.Log
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.core.TorchState
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.tinycalculator.R
import com.example.tinycalculator.ui.viewModels.HomeViewModel
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Composable
fun CameraPreviewScreen(homeViewModel: HomeViewModel) {
    val lensFacing = CameraSelector.LENS_FACING_BACK
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val preview = Preview.Builder().build()
    val previewView = remember {
        PreviewView(context)
    }
    val cameraxSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
    val imageCapture = remember {
        ImageCapture.Builder().build()
    }
    var switchFlash = {

    }
    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        val camera = cameraProvider.bindToLifecycle(lifecycleOwner, cameraxSelector, preview, imageCapture)
        preview.setSurfaceProvider(previewView.surfaceProvider)
        switchFlash = {
            switchTorch(camera = camera)
        }
    }

    AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(R.drawable.third_option),
        contentDescription = stringResource(R.string.Loading)
    )
    Box(contentAlignment = Alignment.TopStart,modifier = Modifier.fillMaxSize()){
        FloatingActionButton(
            onClick = {
                switchFlash()
            },
            modifier = Modifier.padding(20.dp)
        ) {
            Icon(
                painterResource(R.drawable.flash32),
                contentDescription = "add"
            )
        }
    }
    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                captureImage(imageCapture, context, homeViewModel)
            },
            modifier = Modifier.padding(5.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.android_camera64),
                contentDescription = "take picture",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
private fun captureImage(imageCapture: ImageCapture, context: Context, homeViewModel: HomeViewModel) {
    val imageFile = createTempFile("anImage", ".jpg")
    val outputFileOptions = ImageCapture.OutputFileOptions
        .Builder(imageFile).build()
    imageCapture.takePicture(
        outputFileOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                homeViewModel.showCamera = false
                homeViewModel.photoTaken(imageFile)
                Log.d("Log", outputFileResults.savedUri.toString())
            }
            override fun onError(exception: ImageCaptureException) {
                throw exception
            }

        })
}

private fun switchTorch(camera: Camera){
    val torchState = camera.cameraInfo.torchState.value
    if(torchState == TorchState.OFF){
        camera.cameraControl.enableTorch(true)
    } else {
        camera.cameraControl.enableTorch(false)
    }

}


private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                continuation.resume(cameraProvider.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }