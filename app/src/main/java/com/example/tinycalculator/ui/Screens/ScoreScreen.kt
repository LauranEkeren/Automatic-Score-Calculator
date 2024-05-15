package com.example.tinycalculator.ui.Screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinycalculator.Domain.Board
import com.example.tinycalculator.R
import com.example.tinycalculator.data.ScoreUiState
import com.example.tinycalculator.ui.ViewModels.ScoreViewModel


@Composable
fun ScoreScreen(
    scoreUiState: ScoreUiState,
    modifier: Modifier = Modifier,
){
    val resources = LocalContext.current.resources
    val items = listOf(
        Pair(stringResource(R.string.points_chapels), scoreUiState.scoreChapels),
        Pair(stringResource(R.string.points_cottages), scoreUiState.scoreCottages),
        Pair(stringResource(R.string.points_taverns), scoreUiState.scoreTaverns),
        Pair(stringResource(R.string.points_theaters), scoreUiState.scoreTheaters),
        Pair(stringResource(R.string.points_wells), scoreUiState.scoreWells),
        Pair(stringResource(R.string.penalty_empty_squares), scoreUiState.penaltyEmptySquare)
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        TotalScoreText(score = scoreUiState.totalScore)
        Divider(thickness = 1.dp)
        items.forEach { item ->
            Text(text = item.first)
            Text(text = item.second.toString())
            Divider(thickness = 1.dp)
        }
    }


}

@Composable
fun TotalScoreText( score: Int, modifier: Modifier = Modifier){
    Text(
        text = (stringResource(R.string.Score) + ": " + score),
        fontSize = 40.sp,
        textAlign = TextAlign.Center
    )

}



