package com.example.kotlintutorials.ui.components

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintutorials.data.ImageRepository
import com.example.kotlintutorials.ui.screens.artspace.state.ArtSpaceState
import kotlinx.coroutines.launch

class ArtSpaceViewModel(
    private val imgRepo: ImageRepository
) : ViewModel() {
    private val _uiState = mutableStateOf(ArtSpaceState())
    val uiState: State<ArtSpaceState> = _uiState


    fun onSaveRequested(drawableId: Int, title: String) {
        viewModelScope.launch {
            imgRepo.saveImage(drawableId = drawableId, title = title)
            _uiState.value
        }
    }

    fun onNextImage(newDrawableId: Int){
        _uiState.value = _uiState.value.copy(currentDrawableId = newDrawableId,
            isSaved = false,
            generatedTitle = "")
    }
}

val LocalArtSpaceViewModel = staticCompositionLocalOf<ArtSpaceViewModel> {
    error("No ImageViewModel provided")
}