package com.example.kotlintutorials.data

import android.content.Context
import com.example.kotlintutorials.data.local.ImageDao
import com.example.kotlintutorials.data.local.LocalFileManager
import com.example.kotlintutorials.data.model.AnnotatedImage

class ImageRepository(private val localFileManager: LocalFileManager, private val imageDao: ImageDao) {

    suspend fun saveImage(drawableId: Int, title: String) {
        val path = localFileManager.storeImage(
            drawableId = drawableId,
            filename = title
        )

        if(path != null){
            val record = AnnotatedImage(title = title, imagePath = path)
            imageDao.insertImage(record)
        }

    }

    fun getSavedImages() = imageDao.getAllImages()

}