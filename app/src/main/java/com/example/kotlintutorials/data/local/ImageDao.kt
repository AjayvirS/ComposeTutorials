package com.example.kotlintutorials.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlintutorials.data.model.AnnotatedImage
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Insert
    suspend fun insertImage(image: AnnotatedImage)

    @Query("SELECT * FROM annotated_images ORDER BY timestamp DESC")
    fun getAllImages(): Flow<List<AnnotatedImage>>
}