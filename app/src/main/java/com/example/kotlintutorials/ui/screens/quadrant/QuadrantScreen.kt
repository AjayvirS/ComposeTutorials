package com.example.kotlintutorials.ui.screens.quadrant

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintutorials.R

@Composable
fun ComposeArticle(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.compose_bg)
    Box(modifier) {

        Column {
            Image(
                painter = image, contentDescription = null, modifier = modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.jetpack_compose_tutorial),
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = stringResource(R.string.text1), modifier = Modifier.padding(
                    start = 16.dp, end = 16.dp
                ), textAlign = Justify
            )
            Text(
                text = stringResource(R.string.text2),
                modifier = Modifier.padding(16.dp),
                textAlign = Justify
            )
        }

    }

}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Box {


        Column(modifier = modifier.fillMaxWidth()) {
            Row(modifier = Modifier.weight(1f)) {
                InfoCard(
                    title = "Text composable",
                    message = "Displays text and follows recommended Material design guidelines.",
                    bgColor = Color(0xFFD0BCFF),
                    Modifier.weight(1f)
                )
                InfoCard(
                    title = "Image composable",
                    message = "Creates a composable that lays out and draws a given Painter class object.",
                    bgColor = Color(0xFFEADDFF),
                    Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.weight(1f)) {
                InfoCard(
                    title = "Row composable",
                    message = "A layout composable that places its children in a horizontal sequence.",
                    bgColor = Color(0xFFB69DF8),
                    Modifier.weight(1f)
                )
                InfoCard(
                    title = "Column composable",
                    message = "A layout composable that places its children in a vertical sequence.",
                    bgColor = Color(0xFFF6EDFF),
                    Modifier.weight(1f)
                )
            }
        }
    }

}

@Composable
fun InfoCard(title: String, message: String, bgColor: Color, modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(bgColor)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = message, textAlign = Justify)

    }

}
