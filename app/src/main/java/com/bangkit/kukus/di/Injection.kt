package com.bangkit.kukus.di

import android.content.Context
import com.bangkit.kukus.data.remote.RemoteRepository
import com.bangkit.kukus.repository.ExploreRepository

object Injection {

    fun provideRepository(context: Context): ExploreRepository{
        val remoteDataSource = RemoteRepository.getInstance()
        return ExploreRepository.getInstance(remoteDataSource)
    }

}