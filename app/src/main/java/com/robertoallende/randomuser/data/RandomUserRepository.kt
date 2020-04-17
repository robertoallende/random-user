package com.robertoallende.randomuser.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.robertoallende.randomuser.api.RandomUserService
import com.robertoallende.randomuser.db.RandomUserLocalCache
import com.robertoallende.randomuser.model.User
import kotlinx.coroutines.CoroutineScope

class RandomUserRepository(
    private val service: RandomUserService,
    private val cache: RandomUserLocalCache
) {

//    suspend fun getUsers(): List<User> {
//        val response = service.getNewsFeed(BuildConfig.API_SEED, 1, 100)
//        response.users?.let { cache.insert(it) {} }
//        return response.users ?: listOf()
//    }

    /**
     * Get all Users
     */
    fun getUsers(viewModelScope: CoroutineScope): LiveData<PagedList<User>> {
        // Get data source factory from the local cache
        val dataSourceFactory = cache.allUsers()

        // every new query creates a new BoundaryCallback
        // The BoundaryCallback will observe when the user reaches to the edges of
        // the list and update the database with extra data
        val boundaryCallback = UsersBoundaryCallback("", service, cache, viewModelScope)

        // TODO: Expose network errors and handle them
        val networkErrors = boundaryCallback.networkErrors

        // Get the paged list
        return LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}