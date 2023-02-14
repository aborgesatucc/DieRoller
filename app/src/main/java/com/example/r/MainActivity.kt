package com.example.r

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.r.ui.theme.RTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DieRollerApp()
        }
    }
}

@Composable
fun DieRollerApp() {
    DieImageWithButton()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DieRollerApp()
}

@Composable
fun DieImageWithButton() {
    var roll by remember { mutableStateOf(1) }
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

        Button(onClick = { roll = (1..6).random() }) {
            Text("Roll")
        }
    }
}
