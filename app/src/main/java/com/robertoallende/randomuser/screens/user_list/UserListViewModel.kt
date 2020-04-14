package com.robertoallende.randomuser.screens.user_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robertoallende.randomuser.base.BaseViewModel
import com.robertoallende.randomuser.data.ApiContract
import androidx.lifecycle.viewModelScope
import com.robertoallende.randomuser.common.map
import com.robertoallende.randomuser.data.models.RandomUserResponse
import kotlinx.coroutines.launch

class UserListViewModel(
    private val dataRepository: ApiContract
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
            _randomUsers.postValue(dataRepository.getUsers())
        }
    }


}