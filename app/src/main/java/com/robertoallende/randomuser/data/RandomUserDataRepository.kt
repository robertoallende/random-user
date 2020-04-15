package com.robertoallende.randomuser.data

import com.robertoallende.randomuser.api.ApiContract

class RandomUserDataRepository(private val api: ApiContract) : ApiContract by api

