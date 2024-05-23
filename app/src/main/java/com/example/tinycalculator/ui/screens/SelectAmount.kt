package com.example.tinycalculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinycalculator.R

@Composable
fun SelectAmount(
    modifier: Modifier = Modifier,
    descriptionText: String,
    amount: Int,
    onIncreaseButtonClicked: () -> Unit = {},
    onDecreaseButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {

            AmountText(amount = amount, text = descriptionText)
            Row {
                FloatingActionButton(
                    onClick = {
                        onIncreaseButtonClicked()
                    },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(
                        Icons.Rounded.KeyboardArrowUp,
                        contentDescription = "add"
                    )
                }
                FloatingActionButton(
                    onClick = {
                        onDecreaseButtonClicked()
                    },
                    modifier = Modifier.padding(5.dp)

                ) {
                    Icon(
                        Icons.Rounded.KeyboardArrowDown,
                        contentDescription = "add"
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Composable
fun AmountText(modifier: Modifier = Modifier, amount: Int, text: String) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
    Text(
        text = (amount.toString()),
        fontSize = 40.sp,
        textAlign = TextAlign.Center
    )
}