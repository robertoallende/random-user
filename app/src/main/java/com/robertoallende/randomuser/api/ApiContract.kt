package com.robertoallende.randomuser.api

import com.robertoallende.randomuser.model.RandomUserResponse

interface ApiContract {

    suspend fun getUsers(): RandomUserResponse

}