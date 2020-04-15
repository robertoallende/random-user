package com.robertoallende.randomuser.data

import com.robertoallende.randomuser.BuildConfig
import com.robertoallende.randomuser.api.ApiService
import com.robertoallende.randomuser.db.RandomUserLocalCache
import com.robertoallende.randomuser.model.RandomUserResponse

class RandomUserRepository(
    private val service: ApiService,
    private val cache: RandomUserLocalCache) {

    suspend fun getUsers(): RandomUserResponse {
        val response =  service.getNewsFeed(BuildConfig.API_SEED)
        response.users?.let { cache.insert(it){}}
        return response
    }
}