package com.example.kotlintutorials.model

data class Artwork(
    val id: Int? = null,
    val imagePath: String,
    val title: String = "",
    val artist: String = "")