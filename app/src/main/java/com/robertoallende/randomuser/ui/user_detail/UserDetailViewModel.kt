package com.robertoallende.randomuser.ui.user_detail

import com.robertoallende.randomuser.base.BaseViewModel
import com.robertoallende.randomuser.data.RandomUserRepository

class UserDetailViewModel(
    private val repository: RandomUserRepository
) : BaseViewModel<UserDetailEvent>() {

}