package com.bangkit.kukus.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseFinalItem
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseItem
import com.bangkit.kukus.repository.ExploreRepository

class ExploreViewModel(private val exploreRepository: ExploreRepository) : ViewModel() {
    fun getUsers(): LiveData<List<ExploreResponseFinalItem>> = exploreRepository.getUsers()
}