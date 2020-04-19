package com.robertoallende.randomuser

import androidx.test.espresso.IdlingResource

interface RadomUserIdlingResource {
    fun getResource(): IdlingResource?
    fun increment()
    fun decrement()
}