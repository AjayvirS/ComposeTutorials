package com.example.kotlintutorials

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kotlintutorials.navigation.AppNavHost
import com.example.kotlintutorials.navigation.DemoRegistry
import com.example.kotlintutorials.ui.screens.DrawerList
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun KotlinTutorialsApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    // if we navigate away (Composable is destroyed) then scope cancels everything after
    val scope = rememberCoroutineScope()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val demos = DemoRegistry.demos
    val currentTitle = demos.firstOrNull() {
        it.route == currentRoute
    }?.titleRes

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        DrawerList(demos = demos, currentRoute = currentRoute, onNavigate = { demo ->
            scope.launch { drawerState.close() }
            navController.navigate(demo.route) {
                launchSingleTop = true
                restoreState = true
                popUpTo("home") { saveState = true }
            }
        })
    }) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(
                    text = currentTitle?.let { stringResource(it) }  ?: "Kotlin Tutorials",
                    style = MaterialTheme.typography.titleLarge
                )
            }, navigationIcon = {
                IconButton(onClick = {
                    scope.launch {drawerState.open()}
                }) {
                    Icon(Icons.Outlined.Menu, contentDescription = "Open menu")
                }
            })
        }) {
            padding ->
            Box(Modifier.padding(padding)) {
                AppNavHost(navController)
            }
        }
    }
}