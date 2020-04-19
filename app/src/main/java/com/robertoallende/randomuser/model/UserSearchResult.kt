package com.robertoallende.randomuser.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * UserSearchResult from a search, which contains LiveData<List<User>> holding query data,
 * and a LiveData<String> of network error state.
 */
data class UserSearchResult(
    val data: LiveData<PagedList<User>>,
    val networkErrors: LiveData<String>
)