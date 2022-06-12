package com.bangkit.kukus.data.remote.api

import com.bangkit.kukus.data.remote.response.explore.ExploreResponseFinalItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceExplore {
    @GET("explore")
    fun getUsers(): Call<List<ExploreResponseFinalItem>>
}