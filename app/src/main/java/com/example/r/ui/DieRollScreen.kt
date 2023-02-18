package com.example.r.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.r.R


@Composable
fun DieRollerApp(
    dieRollViewModel:DieRollViewModel = viewModel(),
    modifier: Modifier = Modifier) {

    val dieUiState by dieRollViewModel.uiState.collectAsState()

    DieImageWithButton(
        roll = dieUiState.rollNumber,
        rollCount = dieUiState.rollCount,
        onRollClick = { dieRollViewModel.rollClicked() }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DieRollerApp()
}

@Composable
fun DieImageWithButton(
    roll:Int,
    rollCount:Int,
    onRollClick:() -> Unit,
    modifier:Modifier = Modifier) {

    Column {
        when (roll) {
            1 -> Image(
                painter = painterResource(id = R.drawable.d1),
                contentDescription = stringResource(id = R.string.d1_desc)
            )
            2 -> Image(
                painter = painterResource(id = R.drawable.d2),
                contentDescription = stringResource(id = R.string.d2_desc)
            )
            3 -> Image(
                painter = painterResource(id = R.drawable.d3),
                contentDescription = stringResource(id = R.string.d3_desc)
            )
            4 -> Image(
                painter = painterResource(id = R.drawable.d4),
                contentDescription = stringResource(id = R.string.d4_desc)
            )
            5 -> Image(
                painter = painterResource(id = R.drawable.d5),
                contentDescription = stringResource(id = R.string.d5_desc)
            )
            6 -> Image(
                painter = painterResource(id = R.drawable.d6),
                contentDescription = stringResource(id = R.string.d6_desc)
            )
        }

        Button(onClick = onRollClick) {
            Text("Roll It")
        }

        Text("Roll count: $rollCount")
    }
}