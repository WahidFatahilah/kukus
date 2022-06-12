package com.bangkit.kukus.data

import androidx.lifecycle.LiveData
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseFinalItem
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseItem


interface DataSource {

    fun getUsers(): LiveData<List<ExploreResponseFinalItem>>
}