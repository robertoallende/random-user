package com.robertoallende.randomuser.ui.user_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robertoallende.randomuser.base.BaseViewModel
import androidx.lifecycle.viewModelScope
import com.robertoallende.randomuser.common.map
import com.robertoallende.randomuser.data.RandomUserRepository
import com.robertoallende.randomuser.model.RandomUserResponse
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: RandomUserRepository
) : BaseViewModel<UserListEvent>() {

    private val _randomUsers = MutableLiveData<RandomUserResponse>()
    val randomUsers: LiveData<RandomUserResponse> = _randomUsers

    val tempName: LiveData<String> = _randomUsers.map {
        it.results?.let { results ->
            if (results.isNotEmpty()) results[0].name.toString() else ""
        } ?: ""
    }

    init {
        viewModelScope.launch {
            // TODO: Check for potential excpetions
            _randomUsers.postValue(repository.getUsers())
        }
    }
}