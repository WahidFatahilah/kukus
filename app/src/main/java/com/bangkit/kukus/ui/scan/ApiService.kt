package com.bangkit.kukus.ui.scan

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("/predict/image")
    fun uploadImage(
        @Part file: MultipartBody.Part,
    ): Call<FoodImageDataClass>

}