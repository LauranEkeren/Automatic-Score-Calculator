package com.example.tinycalculator.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tinycalculator.model.BuildingCard

@Composable
fun SelectCardScreen(
    options: List<BuildingCard>,
    onClickCard: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(300.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding,
    ) {
        items(items = options, key = { card -> card.buildingName }) { photo ->
            CardPhoto(
                photo,
                onClick = onClickCard,
            )
        }
    }
}

@Composable
fun CardPhoto(card: BuildingCard, onClick: (String) -> Unit){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable { onClick(card.buildingName) }
    ) {
        Image(
            painter = painterResource(card.imageId),
            contentDescription = card.buildingName,
            contentScale = ContentScale.Crop
        )

    }
}