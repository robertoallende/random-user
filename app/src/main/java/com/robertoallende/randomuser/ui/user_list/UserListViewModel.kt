package com.robertoallende.randomuser.ui.user_list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.robertoallende.randomuser.base.BaseViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.robertoallende.randomuser.common.map
import com.robertoallende.randomuser.data.RandomUserRepository
import com.robertoallende.randomuser.model.RandomUserResponse
import com.robertoallende.randomuser.model.User
import com.robertoallende.randomuser.model.UserSearchResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: RandomUserRepository
) : BaseViewModel<UserListEvent>() {

    private val _randomUsers = repository.getUsers(viewModelScope)
    val randomUsers: LiveData<PagedList<User>> = _randomUsers.data
    val networkError: LiveData<String> = _randomUsers.networkErrors

    private val _emptyResultVisibility = MutableLiveData(View.INVISIBLE)
    val emptyResultVisibility: LiveData<Int> = _emptyResultVisibility

    fun onUserClicked(user: User, position: Int) {
        postEvent(UserListEvent.GoToUserDetail(user, position))
    }

    fun onNetworkError(msg: String) {
        postEvent(UserListEvent.DisplayError(msg))
    }

    /**
     * Decides to show Empty List Message.
     * Not using Transformations.map for this becaus it will show the message while fetching results on initial state.
     */
    fun onRandomUsersUpdated() {
        if (randomUsers.value == null || randomUsers.value?.isEmpty() == true) {
            _emptyResultVisibility.postValue(View.VISIBLE)
        } else {
            _emptyResultVisibility.postValue(View.INVISIBLE)
        }
    }
}