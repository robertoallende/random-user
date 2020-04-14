package com.robertoallende.randomuser.data

class RandomUserApi(
    private val apiService: ApiService
) : ApiContract {

    override suspend fun getUsers(): Any {
        TODO("Not yet implemented")
    }
}