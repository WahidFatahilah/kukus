package com.bangkit.kukus.data.remote.api

import com.bangkit.kukus.data.remote.response.explore.ExploreResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceExplore {
    @GET("users")
    fun getUsers(): Call<List<ExploreResponseItem>>
}