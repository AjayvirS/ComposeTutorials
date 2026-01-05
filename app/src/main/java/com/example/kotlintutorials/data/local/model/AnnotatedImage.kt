package com.example.kotlintutorials.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "annotated_images")
data class AnnotatedImage(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val imagePath: String,
    val timestamp: Long = System.currentTimeMillis()
)