package com.example.tinycalculator

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tinycalculator.data.DataSourceCards
import com.example.tinycalculator.ui.screens.ScoreScreen
import com.example.tinycalculator.ui.screens.SelectCardScreen
import com.example.tinycalculator.ui.screens.StartScreen
import com.example.tinycalculator.ui.viewModels.HomeViewModel
import com.example.tinycalculator.ui.viewModels.ScoreViewModel

enum class TinyCalculatorScreen(@StringRes val title: Int){
    Start(title = R.string.app_name),
    Score(title = R.string.Score),
    RedBuilding(title = R.string.choose_red_building),
    OrangeBuilding(title = R.string.choose_orange_building),
    YellowBuilding(title = R.string.choose_yellow_building),
    GreenBuilding(title = R.string.choose_green_building),
    GreyBuilding(title = R.string.choose_grey_building),
    BlackBuilding(title = R.string.choose_black_building),
    Monument(title = R.string.choose_monument_card)
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
        val scoreUiState by scoreViewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = TinyCalculatorScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = TinyCalculatorScreen.Start.name){
                // Create HomeViewModel here
                val context = LocalContext.current
                StartScreen(
                    homeViewModel = homeViewModel,
                    context = context,
                    onRequestReceived = {
                        scoreViewModel.jsonStringReceived(homeViewModel.grid)
                        homeViewModel.resetHomeViewModel()
                        navController.navigate(TinyCalculatorScreen.RedBuilding.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
            composable(route = TinyCalculatorScreen.Score.name){
                ScoreScreen(
                    scoreUiState = scoreUiState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
            composable(route = TinyCalculatorScreen.RedBuilding.name){
                SelectCardScreen(
                    options = DataSourceCards.redBuildingCards,
                    onClickCard = {
                        scoreViewModel.redBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.OrangeBuilding.name);
                    })
            }
            composable(route=TinyCalculatorScreen.OrangeBuilding.name){
                SelectCardScreen(
                    options = DataSourceCards.orangeBuildingCards,
                    onClickCard = {
                        scoreViewModel.orangeBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.GreenBuilding.name)
                    })
            }
            composable(route=TinyCalculatorScreen.GreenBuilding.name){
                SelectCardScreen(
                    options = DataSourceCards.greenBuildingCards,
                    onClickCard = {
                        scoreViewModel.greenBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.YellowBuilding.name)
                    }
                )
            }
            composable(route=TinyCalculatorScreen.YellowBuilding.name){
                SelectCardScreen(
                    options = DataSourceCards.yellowBuildingCards,
                    onClickCard = {
                        scoreViewModel.yellowBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.GreyBuilding.name)
                    }
                )
            }
            composable(route=TinyCalculatorScreen.GreyBuilding.name){
                SelectCardScreen(
                    options = DataSourceCards.greyBuildingCards,
                    onClickCard = {
                        scoreViewModel.greyBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.BlackBuilding.name)
                    })
            }
            composable(route=TinyCalculatorScreen.BlackBuilding.name){
                SelectCardScreen(
                    options = DataSourceCards.blackBuildingCards,
                    onClickCard = {
                        scoreViewModel.blackBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.Monument.name)
                    })
            }
            composable(route = TinyCalculatorScreen.Monument.name){
                SelectCardScreen(
                    options = DataSourceCards.monumentCards,
                    onClickCard = {
                        scoreViewModel.monumentCardSelected(it)
                        scoreViewModel.calculateScore()
                        navController.navigate(TinyCalculatorScreen.Score.name)
                    }
                )
            }
        }
    }
}

