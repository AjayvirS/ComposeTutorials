package com.example.kotlintutorials.ui.screens.lemonade

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintutorials.R

@Preview(showBackground = true)
@Composable
fun LemonMakerApp() {
    LemonMaker(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .wrapContentSize(Alignment.TopCenter)
    )
}

@Composable
fun LemonMaker(modifier: Modifier = Modifier) {
    var currView by remember {
        mutableStateOf(0)
    }
    var squeezeCount by remember { mutableStateOf(0) }
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .background(color = Color.Yellow)
                .weight(1f)
        ) {
            Text(
                text = "Lemonade",
                fontWeight = Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                textAlign = Center
            )
        }
        Row(modifier = Modifier.weight(10f), verticalAlignment = Alignment.CenterVertically) {
            val executeStep = {
                if (currView == 0) {
                    squeezeCount = (2..4).random()
                }
                currView = (currView + 1) % 4
            }
            val squeezeStep = {
                squeezeCount--
                if (squeezeCount == 0) {
                    currView = (currView + 1) % 4
                }
            }
            when (currView) {
                0 -> LemonadeView(
                    text = stringResource(R.string.lemon1),
                    painterResource = painterResource(R.drawable.lemon_tree), executeStep
                )

                1 -> {
                    LemonadeView(
                        text = stringResource(R.string.lemon2),
                        painterResource = painterResource(R.drawable.lemon_squeeze), squeezeStep
                    )
                }

                2 -> LemonadeView(
                    text = stringResource(R.string.lemon3),
                    painterResource = painterResource(R.drawable.lemon_drink), executeStep
                )

                3 -> LemonadeView(
                    text = stringResource(R.string.lemon4),
                    painterResource = painterResource(R.drawable.lemon_restart), executeStep
                )

            }
        }
    }


}

@Composable
fun LemonadeView(
    text: String,
    painterResource: Painter,
    executeStep: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {

        Button(
            onClick = {
                executeStep()
            },
            shape = RoundedCornerShape(25),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green.copy(alpha = 0.2f)
            ),
        ) {
            Image(
                painter = painterResource, contentDescription = null, Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = text, fontSize = 18.sp)
    }

}