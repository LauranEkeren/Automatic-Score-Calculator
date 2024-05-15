package com.example.tinycalculator

import android.content.Context
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tinycalculator.ui.Screens.ScoreScreen
import com.example.tinycalculator.ui.Screens.StartScreen
import com.example.tinycalculator.ui.ViewModels.HomeViewModel
import com.example.tinycalculator.ui.ViewModels.ScoreViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

enum class TinyCalculatorScreen(@StringRes val title: Int){
    Start(title = R.string.app_name),
    Score(title = R.string.Score)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TinyCalculatorAppBar(
    currentScreen: TinyCalculatorScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}


@Composable
fun TinyCalculatorApp(
    homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory),
    scoreViewModel: ScoreViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = TinyCalculatorScreen.valueOf(
        backStackEntry?.destination?.route ?: TinyCalculatorScreen.Start.name
    )

    Scaffold(
        topBar = {
            TinyCalculatorAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp()})
        }
    ) { innerPadding ->
        // Can this go somewhere else?
        val scoreUiState by scoreViewModel.uiState.collectAsState()


        NavHost(
            navController = navController,
            startDestination = TinyCalculatorScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = TinyCalculatorScreen.Start.name){
                val context = LocalContext.current
                val file = context.createImageFile()
                val uri = FileProvider.getUriForFile(
                    Objects.requireNonNull(context),
                    BuildConfig.APPLICATION_ID + ".provider", file
                )
                StartScreen(
                    homeViewModel = homeViewModel,
                    context = context,
                    file = file,
                    uri = uri,
                    onRequestReceived = {
                        //TODO: Figure out why this log gets called twice.
                        Log.d("Info", "Does this get called twice?")
                        scoreViewModel.setScore(homeViewModel.grid)
                        navController.navigate(TinyCalculatorScreen.Score.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
            composable(route = TinyCalculatorScreen.Score.name){
                Log.d("Info", "From TinyCalculatorScreen.kt: composable Score.name. line 80")
                ScoreScreen(
                    scoreUiState = scoreUiState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    }
}

fun Context.createImageFile(): File {
    // Create an image file name
    val timeStamp = SimpleDateFormat("yyyyMMdd__HHmmss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )
    return image
}
