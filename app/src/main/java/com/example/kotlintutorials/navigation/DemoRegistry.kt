package com.example.kotlintutorials.navigation

import com.example.kotlintutorials.*
import com.example.kotlintutorials.R

object DemoRegistry {
    const val HOME = "home"

    val demos: List<DemoDestination> = listOf(
        DemoDestination("article", R.string.title) { ComposeArticle() },
        DemoDestination("tasks", R.string.title) { CompletedTasks() },
        DemoDestination("quadrant", R.string.title) { ComposeQuadrant() },
        DemoDestination("dice", R.string.title) { DiceWithButtonAndImage() },
        DemoDestination("lemonade", R.string.title) { LemonMaker() },
        DemoDestination("tiptime", R.string.title) { TipTimeLayout() }
    )
}
