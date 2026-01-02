package com.example.kotlintutorials.navigation

import CompletedTasks
import com.example.kotlintutorials.R
import com.example.kotlintutorials.ui.screens.dice.DiceWithButtonAndImage
import com.example.kotlintutorials.ui.screens.greetings.GreetingText
import com.example.kotlintutorials.ui.screens.lemonade.LemonMaker
import com.example.kotlintutorials.ui.screens.quadrant.ComposeArticle
import com.example.kotlintutorials.ui.screens.quadrant.ComposeQuadrant
import com.example.kotlintutorials.ui.screens.tiptime.TipTimeLayout

object DemoRegistry {

    val demos: List<DemoDestination> = listOf(
        DemoDestination("greeting", R.string.title_bday) { GreetingText("Hello World", "Ajay") },
        DemoDestination("article", R.string.title_article) { ComposeArticle() },
        DemoDestination("tasks", R.string.title_tasks) { CompletedTasks() },
        DemoDestination("dice", R.string.title_dice) { DiceWithButtonAndImage() },
        DemoDestination("lemonade", R.string.title_lemonade) { LemonMaker() },
        DemoDestination("tiptime", R.string.title_tip) { TipTimeLayout() }
    )
}
