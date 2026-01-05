package com.example.kotlintutorials.data.remote.gemini

import com.example.kotlintutorials.data.remote.dto.AnnotatedImageRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface GeminiFunctionsApi {

    @POST("annotateArtworkFromImage")
    suspend fun annotateArtworkFromImage(@Body body: AnnotatedImageRequest)

}