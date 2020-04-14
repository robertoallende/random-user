package com.robertoallende.randomuser.data

interface ApiContract {

    suspend fun getUsers(): Any

}