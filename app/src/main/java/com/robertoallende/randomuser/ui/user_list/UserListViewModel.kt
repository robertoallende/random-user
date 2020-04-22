package com.robertoallende.randomuser.ui.user_list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.robertoallende.randomuser.base.BaseViewModel
import com.robertoallende.randomuser.common.mapWithDefault
import com.robertoallende.randomuser.data.RandomUserRepository
import com.robertoallende.randomuser.model.User

class UserListViewModel(
    private val repository: RandomUserRepository?
) : BaseViewModel<UserListEvent>() {

    private val _randomUsers = repository?.getUsers(viewModelScope)
    val randomUsers: LiveData<PagedList<User>>? = _randomUsers?.data
    val networkError: LiveData<String>? = _randomUsers?.networkErrors

    val emptyResultVisibility =
        _randomUsers?.data?.mapWithDefault(View.GONE) { if (it.isEmpty()) View.VISIBLE else View.GONE }

    fun onUserClicked(user: User, position: Int) {
        postEvent(UserListEvent.GoToUserDetail(user, position))
    }

    fun onNetworkError(msg: String) {
        postEvent(UserListEvent.DisplayError(msg))
    }
}