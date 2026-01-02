package com.example.kotlintutorials.ui.components

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintutorials.data.ImageRepository
import kotlinx.coroutines.launch

class ImageViewModel(
    private val imgRepo: ImageRepository
) : ViewModel() {

    fun onSaveRequested(drawableId: Int, title: String) {
        viewModelScope.launch {
            imgRepo.saveImage(drawableId = drawableId, title = title)
        }
    }
}

val LocalImageViewModel = staticCompositionLocalOf<ImageViewModel> {
    error("No ImageViewModel provided")
}