package com.bangkit.kukus.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.kukus.di.Injection
import com.bangkit.kukus.repository.ExploreRepository
import com.bangkit.kukus.ui.explore.ExploreViewModel


class ViewModelFactory private constructor(private val homeRepository: ExploreRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(ExploreViewModel::class.java) -> {
                return ExploreViewModel(homeRepository) as T
            }
            else -> throw Throwable("Uknown ViewModel class" + modelClass.name)
        }
    }
}