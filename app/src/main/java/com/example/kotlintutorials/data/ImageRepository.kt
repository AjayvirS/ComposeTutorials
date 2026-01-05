package com.example.kotlintutorials.data

import android.content.Context
import com.example.kotlintutorials.R
import com.example.kotlintutorials.data.local.ImageDao
import com.example.kotlintutorials.data.local.LocalFileManager
import com.example.kotlintutorials.data.local.model.AnnotatedImage
import com.example.kotlintutorials.model.Artwork
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ImageRepository @Inject constructor(
    private val localFileManager: LocalFileManager,
    private val imageDao: ImageDao,
    @ApplicationContext private val context: Context
) {

    private val resourceBaseUri: String
        get() = "android.resource://${context.packageName}/"

    suspend fun saveImage(uri: String, title: String) {
        withContext(Dispatchers.IO) {
            val path = localFileManager.storeImage(uriString = uri, filename = title)

            if (path != null) {
                val record = AnnotatedImage(title = title, imagePath = path, imageSource = uri)
                imageDao.insertImage(record)
            }

        }

    }


    fun getSavedImages() = imageDao.getAllImages()


    fun getSampleArtworks(): List<Artwork> {
        return listOf(
            Artwork(imagePath = getResourceUri(R.drawable.india1)),
            Artwork(imagePath = getResourceUri(R.drawable.india2)),
            Artwork(imagePath = getResourceUri(R.drawable.india3)),
            Artwork(imagePath = getResourceUri(R.drawable.india4)),
            Artwork(imagePath = getResourceUri(R.drawable.india5)),
            Artwork(imagePath = getResourceUri(R.drawable.india6)),
            Artwork(imagePath = getResourceUri(R.drawable.india7)),
            Artwork(imagePath = getResourceUri(R.drawable.india8)),
            Artwork(imagePath = getResourceUri(R.drawable.india9)),

            )
    }

    private fun getResourceUri(resId: Int): String {
        return "$resourceBaseUri$resId"
    }


    suspend fun getSavedRecordByUri(sourcePath: String): AnnotatedImage? = withContext(Dispatchers.IO) {
        return@withContext imageDao.findRecordBySource(sourcePath)
    }


}