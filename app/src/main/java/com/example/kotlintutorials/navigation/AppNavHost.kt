package com.example.kotlintutorials.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {

        }
        DemoRegistry.demos.forEach { demo ->
            composable(demo.route) { demo.content() }
        }
    }
}
