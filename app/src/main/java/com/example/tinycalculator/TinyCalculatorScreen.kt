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
import com.example.tinycalculator.Enums.BlackEnum
import com.example.tinycalculator.Enums.GreenEnum
import com.example.tinycalculator.Enums.PurpleEnum
import com.example.tinycalculator.data.DataSourceCards
import com.example.tinycalculator.ui.screens.NextPlayerTakesPhotoScreen
import com.example.tinycalculator.ui.screens.ScoreScreen
import com.example.tinycalculator.ui.screens.SelectAmount
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
    Monument(title = R.string.choose_monument_card),
    AmountOnWareHouse(title = R.string.select_amount),
    AmountFeastHallNeighbour(title = R.string.select_amount),
    AmountStarloom(title = R.string.select_position),
    AmountTree(title = R.string.select_amount_buildings),
    NextPlayerTakesPhoto(title = R.string.next_player)
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
                        .padding(16.dp),
                    onHomeButtonClicked = {
                        scoreViewModel.resetScore()
                        navController.popBackStack(TinyCalculatorScreen.Start.name, inclusive = false)
                    },
                    onNextPlayerButtonClicked = {
                        navController.navigate(TinyCalculatorScreen.NextPlayerTakesPhoto.name)
                    }
                )
            }
            composable(route = TinyCalculatorScreen.NextPlayerTakesPhoto.name){
                NextPlayerTakesPhotoScreen(
                    homeViewModel = homeViewModel,
                    onRequestReceived = {
                        scoreViewModel.jsonStringReceived(homeViewModel.grid)
                        homeViewModel.resetHomeViewModel()
                        scoreViewModel.calculateScore()
                        navController.navigate(TinyCalculatorScreen.Score.name)
                    })
            }
            composable(route = TinyCalculatorScreen.RedBuilding.name){
                SelectCardScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    options = DataSourceCards.redBuildingCards,
                    onClickCard = {
                        scoreViewModel.redBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.OrangeBuilding.name);
                    })
            }
            composable(route=TinyCalculatorScreen.OrangeBuilding.name){
                SelectCardScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    options = DataSourceCards.orangeBuildingCards,
                    onClickCard = {
                        scoreViewModel.orangeBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.GreenBuilding.name)
                    })
            }
            composable(route=TinyCalculatorScreen.GreenBuilding.name){
                SelectCardScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    options = DataSourceCards.greenBuildingCards,
                    onClickCard = {
                        scoreViewModel.greenBuildingCardSelected(it)
                        if (it == GreenEnum.FeastHall.name){
                            navController.navigate(TinyCalculatorScreen.AmountFeastHallNeighbour.name)
                        } else {
                           navController.navigate(TinyCalculatorScreen.YellowBuilding.name)
                        }
                    }
                )
            }
            composable(route=TinyCalculatorScreen.YellowBuilding.name){
                SelectCardScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    options = DataSourceCards.yellowBuildingCards,
                    onClickCard = {
                        scoreViewModel.yellowBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.GreyBuilding.name)
                    }
                )
            }
            composable(route=TinyCalculatorScreen.GreyBuilding.name){
                SelectCardScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    options = DataSourceCards.greyBuildingCards,
                    onClickCard = {
                        scoreViewModel.greyBuildingCardSelected(it)
                        navController.navigate(TinyCalculatorScreen.BlackBuilding.name)
                    })
            }
            composable(route=TinyCalculatorScreen.BlackBuilding.name){
                SelectCardScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    options = DataSourceCards.blackBuildingCards,
                    onClickCard = {
                        scoreViewModel.blackBuildingCardSelected(it)
                        if (it == BlackEnum.Warehouse.name){
                            navController.navigate(TinyCalculatorScreen.AmountOnWareHouse.name)
                        } else {
                            navController.navigate(TinyCalculatorScreen.Monument.name)
                        }
                    })
            }
            composable(route = TinyCalculatorScreen.Monument.name){
                SelectCardScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    options = DataSourceCards.monumentCards,
                    onClickCard = {
                        scoreViewModel.monumentCardSelected(it)
                        if (it == PurpleEnum.TheStarloom.name){
                            navController.navigate(TinyCalculatorScreen.AmountStarloom.name)
                        } else if (it == PurpleEnum.ShrineOfTheElderTree.name){
                            navController.navigate(TinyCalculatorScreen.AmountTree.name)
                        }
                        else {
                            scoreViewModel.calculateScore()
                            navController.navigate(TinyCalculatorScreen.Score.name)
                        }
                    }
                )
            }
            composable(route = TinyCalculatorScreen.AmountOnWareHouse.name){
                SelectAmount(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    descriptionText = stringResource(R.string.amount_warehouse),
                    amount = scoreUiState.amountOnWarehouse,
                    onIncreaseButtonClicked = {
                        scoreViewModel.amountOnWareHouseIncreased()
                    },
                    onDecreaseButtonClicked = {
                        scoreViewModel.amountOnWareHouseDecreased()
                    },
                    onNextButtonClicked = {
                        navController.navigate(TinyCalculatorScreen.Monument.name)
                    }
                )
            }
            composable(route = TinyCalculatorScreen.AmountFeastHallNeighbour.name){
                SelectAmount(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    descriptionText = stringResource(R.string.amount_feast_hall_neighbour),
                    amount = scoreUiState.amountFeastHallOnNeighboursBoard,
                    onIncreaseButtonClicked = {
                        scoreViewModel.amountOnNeighboursBoardIncreased()
                    },
                    onDecreaseButtonClicked = {
                        scoreViewModel.amountOnNeighboursBoardDecreased()
                    },
                    onNextButtonClicked = {
                        navController.navigate(TinyCalculatorScreen.YellowBuilding.name)
                    }
                )
            }
            composable(route = TinyCalculatorScreen.AmountStarloom.name){
                SelectAmount(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    descriptionText = stringResource(R.string.select_position_city_built),
                    amount = scoreUiState.amountStarloom,
                    onIncreaseButtonClicked = {
                        scoreViewModel.amountStarloomIncreased()
                    },
                    onDecreaseButtonClicked = {
                        scoreViewModel.amountStarloomDecreased()
                    },
                    onNextButtonClicked = {
                        scoreViewModel.calculateScore()
                        navController.navigate(TinyCalculatorScreen.Score.name)
                    }
                )
            }
            composable(route = TinyCalculatorScreen.AmountTree.name){
                SelectAmount(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    descriptionText = stringResource(R.string.select_amount_buildings_on_board_when_built),
                    amount = scoreUiState.amountTree,
                    onIncreaseButtonClicked = {
                        scoreViewModel.amountTreeIncreased()
                    },
                    onDecreaseButtonClicked = {
                        scoreViewModel.amountTreeDecreased()
                    },
                    onNextButtonClicked = {
                        scoreViewModel.calculateScore()
                        navController.navigate(TinyCalculatorScreen.Score.name)
                    }
                )
            }
        }
    }
}


