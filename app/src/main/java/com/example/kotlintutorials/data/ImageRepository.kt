package com.example.kotlintutorials.data

import com.example.kotlintutorials.data.local.ImageDao
import com.example.kotlintutorials.data.local.LocalFileManager
import com.example.kotlintutorials.data.local.model.AnnotatedImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepository(
    private val localFileManager: LocalFileManager,
    private val imageDao: ImageDao
) {

    suspend fun saveImage(drawableId: Int, title: String) {
        withContext(Dispatchers.IO) {
            val path = localFileManager.storeImage(
                drawableId = drawableId,
                filename = title
            )

            if (path != null) {
                val record = AnnotatedImage(title = title, imagePath = path)
                imageDao.insertImage(record)
            }

        }

        fun getSavedImages() = imageDao.getAllImages()
    }


}