package com.robertoallende.randomuser.api

import com.robertoallende.randomuser.BuildConfig
import com.robertoallende.randomuser.api.ApiContract
import com.robertoallende.randomuser.api.ApiService
import com.robertoallende.randomuser.model.RandomUserResponse

class RandomUserApi(
    private val apiService: ApiService
) : ApiContract {

    override suspend fun getUsers(): RandomUserResponse {
        return apiService.getNewsFeed(BuildConfig.API_SEED)
    }
}