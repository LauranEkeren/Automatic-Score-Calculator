package com.example.tinycalculator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinycalculator.Enums.SquareEnum
import com.example.tinycalculator.R
import com.example.tinycalculator.data.ScoreUiState


@Composable
fun ScoreScreen(
    scoreUiState: ScoreUiState,
    modifier: Modifier = Modifier,
    onHomeButtonClicked: () -> Unit,
    onNextPlayerButtonClicked: () -> Unit
){
    val items = listOf(
        Triple(SquareEnum.OrangeBuilding, scoreUiState.scoreChapels, true),
        Triple(SquareEnum.Cottage, scoreUiState.scoreCottages, true),
        Triple(SquareEnum.GreenBuilding, scoreUiState.scoreTaverns, true),
        Triple(SquareEnum.YellowBuilding, scoreUiState.scoreTheaters, true),
        Triple(SquareEnum.GreyBuilding, scoreUiState.scoreWells, true),
        Triple(SquareEnum.BlackBuilding, scoreUiState.scoreFactories, true),
        Triple(SquareEnum.PurpleBuilding, scoreUiState.scoreMonument, scoreUiState.monumentInGame),
        Triple(SquareEnum.Empty, scoreUiState.penaltyEmptySquare, true)
    )
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            TotalScoreText(score = scoreUiState.totalScore)
            Divider(thickness = 1.dp)
            items.forEach { item ->
                if (item.third){
                    Row(){
                        RightIcon(item = item)
                    }
                    Divider(thickness = 1.dp)
                }
            }
    }
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onHomeButtonClicked() }
                ) {
                    Text(stringResource(R.string.home))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onNextPlayerButtonClicked()}
                ) {
                    Text(stringResource(R.string.next_player))
                }
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

@Composable
fun RightIcon(item: Triple<SquareEnum, Int, Boolean>){
    if (item.first == SquareEnum.Empty){
        Text(text = stringResource(R.string.penalty_empty_squares) + ": " + item.second.toString())
    } else {
        val icon: Painter = when (item.first) {
            SquareEnum.OrangeBuilding -> painterResource(R.drawable.icon_orange)
            SquareEnum.Cottage -> painterResource(R.drawable.icon_blue)
            SquareEnum.RedBuilding -> painterResource(R.drawable.icon_red)
            SquareEnum.GreenBuilding -> painterResource(R.drawable.icon_green)
            SquareEnum.GreyBuilding -> painterResource(R.drawable.icon_grey)
            SquareEnum.YellowBuilding -> painterResource(R.drawable.icon_yellow)
            SquareEnum.BlackBuilding -> painterResource(R.drawable.icon_black)
            SquareEnum.PurpleBuilding -> painterResource(R.drawable.icon_purple)
            else -> painterResource(R.drawable.placeholder)
        }
        Row() {
            Image(painter = icon, contentDescription = "Icon", Modifier.size(40.dp))
            Text(text = ": " + item.second.toString(), fontSize = 20.sp,
                modifier = Modifier
                    .padding(6.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}



