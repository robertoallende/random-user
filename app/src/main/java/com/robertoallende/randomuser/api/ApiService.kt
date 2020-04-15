package com.robertoallende.randomuser.api

import com.robertoallende.randomuser.model.RandomUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(RandomUserApiEndPoints.GET_USERS)
    suspend fun getNewsFeed(@Query("seed") seed: String): RandomUserResponse

}