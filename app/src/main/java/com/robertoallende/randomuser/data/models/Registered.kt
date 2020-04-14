package com.robertoallende.randomuser.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Registered(
    @Json(name = "age")
    val age: Int?,
    @Json(name = "date")
    val date: String?
)