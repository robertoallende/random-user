package com.robertoallende.randomuser.api

import com.robertoallende.randomuser.model.RandomUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(RandomUserApiEndPoints.GET_USERS)
    suspend fun getUsers(
        @Query("seed") seed: String,
        @Query("page") page: Int,
        @Query("results") results: Int
    ): RandomUserResponse

}