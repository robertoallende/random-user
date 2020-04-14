package com.robertoallende.randomuser.data

import com.robertoallende.randomuser.BuildConfig
import com.robertoallende.randomuser.data.models.RandomUserResponse

class RandomUserApi(
    private val apiService: ApiService
) : ApiContract {

    override suspend fun getUsers(): RandomUserResponse {
       return apiService.getNewsFeed(BuildConfig.API_SEED)
    }
}