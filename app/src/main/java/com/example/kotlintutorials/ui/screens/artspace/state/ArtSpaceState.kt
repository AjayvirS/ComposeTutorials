package com.example.kotlintutorials.ui.screens.artspace.state

data class ArtSpaceState(val currentDrawableId: Int = 0,
                         val generatedTitle: String = "",
                         val isSaved: Boolean = false)
