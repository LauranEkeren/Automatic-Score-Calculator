package com.example.tinycalculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinycalculator.R
import com.example.tinycalculator.data.ScoreUiState


@Composable
fun ScoreScreen(
    scoreUiState: ScoreUiState,
    modifier: Modifier = Modifier,
){
    val items = listOf(
        Triple(stringResource(R.string.points_chapels), scoreUiState.scoreChapels, true),
        Triple(stringResource(R.string.points_cottages), scoreUiState.scoreCottages, true),
        Triple(stringResource(R.string.points_taverns), scoreUiState.scoreTaverns, true),
        Triple(stringResource(R.string.points_theaters), scoreUiState.scoreTheaters, true),
        Triple(stringResource(R.string.points_wells), scoreUiState.scoreWells, true),
        Triple(stringResource(R.string.points_monument), scoreUiState.scoreMonument, scoreUiState.monumentInGame),
        Triple(stringResource(R.string.penalty_empty_squares), scoreUiState.penaltyEmptySquare, true)
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        TotalScoreText(score = scoreUiState.totalScore)
        Divider(thickness = 1.dp)
        items.forEach { item ->
            if (item.third){
                Text(text = item.first)
                Text(text = item.second.toString())
                Divider(thickness = 1.dp)
            }
        }
    }


}

@Composable
fun TotalScoreText( score: Int){
    Text(
        text = (stringResource(R.string.Score) + ": " + score),
        fontSize = 40.sp,
        textAlign = TextAlign.Center
    )

}



