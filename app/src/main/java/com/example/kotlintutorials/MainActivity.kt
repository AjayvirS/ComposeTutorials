package com.example.kotlintutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kotlintutorials.data.ImageRepository
import com.example.kotlintutorials.data.local.AppDatabase
import com.example.kotlintutorials.data.local.LocalFileManager
import com.example.kotlintutorials.ui.components.ImageViewModel
import com.example.kotlintutorials.ui.theme.KotlinTutorialsTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContext = applicationContext
        val fileManager = LocalFileManager(appContext)
        val db = AppDatabase.getDatabase(appContext)
        val repo = ImageRepository(fileManager, appContext)
        val viewModel = ImageViewModel(fileManager = fileManager, repo)
        setContent {
            KotlinTutorialsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KotlinTutorialsApp()
                }
            }
        }
    }
}
