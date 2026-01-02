package com.example.kotlintutorials.ui.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintutorials.data.ImageRepository
import com.example.kotlintutorials.data.local.LocalFileManager
import kotlinx.coroutines.launch

class ImageViewModel(
    private val fileManager: LocalFileManager,
    private val imgRepo: ImageRepository
) : ViewModel() {

    fun onSaveRequested(drawableId: Int, title: String) {
        viewModelScope.launch {
            imgRepo.saveImage(drawableId = drawableId, title = title)
        }
    }
}