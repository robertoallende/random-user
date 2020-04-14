package com.robertoallende.randomuser.data

import com.robertoallende.randomuser.data.models.RandomUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(RandomUserApiEndPoints.GET_USERS)
    suspend fun getNewsFeed(@Query("seed") seed: String): RandomUserResponse

}