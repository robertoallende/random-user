package com.robertoallende.randomuser.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.robertoallende.randomuser.RadomUserIdlingResource
import com.robertoallende.randomuser.api.RandomUserService
import com.robertoallende.randomuser.db.RandomUserLocalCache
import com.robertoallende.randomuser.model.User
import com.robertoallende.randomuser.model.UserSearchResult
import kotlinx.coroutines.CoroutineScope

class RandomUserRepository(
    private val service: RandomUserService,
    private val cache: RandomUserLocalCache,
    private val idlingResource: RadomUserIdlingResource
) {

    /**
     * Get all Users
     */
    fun getUsers(viewModelScope: CoroutineScope): UserSearchResult {
        // Get data source factory from the local cache
        val dataSourceFactory = cache.allUsers()

        // every new query creates a new BoundaryCallback
        // The BoundaryCallback will observe when the user reaches to the edges of
        // the list and update the database with extra data
        val boundaryCallback = UsersBoundaryCallback("", service, cache, viewModelScope, idlingResource)

        val networkErrors = boundaryCallback.networkErrors

        // Get the paged list
        return UserSearchResult(
            LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
                .setBoundaryCallback(boundaryCallback)
                .build(), networkErrors
        )
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}