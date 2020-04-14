package com.robertoallende.randomuser.data

import com.robertoallende.randomuser.data.models.RandomUserResponse

interface ApiContract {

    suspend fun getUsers(): RandomUserResponse

}