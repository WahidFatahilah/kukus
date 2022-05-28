package com.bangkit.kukus.data.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.bangkit.kukus.data.remote.response.ApiConfig.getApiServiceExplore
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {
    companion object {
        @Volatile
        private var instance: RemoteRepository? = null

        fun getInstance(): RemoteRepository = instance ?: RemoteRepository().apply {
            instance = this
        }
    }

    fun getExplore(callback: LoadGetExplore) {
        val client = getApiServiceExplore().getUsers()
        client.enqueue(object : Callback<List<ExploreResponseItem>> {
            override fun onResponse(
                call: Call<List<ExploreResponseItem>>,
                response: Response<List<ExploreResponseItem>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onLoadGetUsers(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<ExploreResponseItem>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }

        })

    }

    interface LoadGetExplore {
        fun onLoadGetUsers(listUser: List<ExploreResponseItem>)
    }
}