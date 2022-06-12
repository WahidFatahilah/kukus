package com.bangkit.kukus.repository

import  androidx.lifecycle.MutableLiveData
import com.bangkit.kukus.data.DataSource
import com.bangkit.kukus.data.remote.RemoteRepository
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseFinalItem
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseItem


class ExploreRepository private constructor(private val remoteRepository: RemoteRepository) :
    DataSource {

    companion object {
        @Volatile
        private var instance: ExploreRepository? = null

        fun getInstance(remoteRepository: RemoteRepository): ExploreRepository =
            instance ?: synchronized(this) {
                instance ?: ExploreRepository(remoteRepository).apply {
                    instance = this
                }
            }
    }

    override fun getUsers(): MutableLiveData<List<ExploreResponseFinalItem>> {
        val getUsers = MutableLiveData<List<ExploreResponseFinalItem>>()
        remoteRepository.getExplore(object : RemoteRepository.LoadGetExplore {
            override fun onLoadGetUsers(listUser: List<ExploreResponseFinalItem>) {
                getUsers.value = listUser
            }
        })
        return getUsers
    }
}