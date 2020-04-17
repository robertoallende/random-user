package com.robertoallende.randomuser.api

import com.robertoallende.randomuser.BuildConfig
import com.robertoallende.randomuser.model.User

class RandomUserService(private val service: ApiService) {

    suspend fun searchUsers(
        page: Int,
        itemsPerPage: Int
    ): List<User> {
        val response = service.getUsers(BuildConfig.API_SEED, page, itemsPerPage)
        return response.users ?: listOf()
    }
}