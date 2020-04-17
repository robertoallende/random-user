package com.robertoallende.randomuser.ui.user_list

import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robertoallende.randomuser.base.BaseViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.robertoallende.randomuser.common.map
import com.robertoallende.randomuser.data.RandomUserRepository
import com.robertoallende.randomuser.model.RandomUserResponse
import com.robertoallende.randomuser.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: RandomUserRepository
) : BaseViewModel<UserListEvent>() {
    private val _randomUsers = repository.getUsers(viewModelScope)
    val randomUsers: LiveData<PagedList<User>> = _randomUsers

    fun onUserClicked(user: User, iv: ImageView) {
        postEvent(UserListEvent.GoToUserDetail(user, iv))
    }

}