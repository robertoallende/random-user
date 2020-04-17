package com.robertoallende.randomuser.ui.user_detail

import com.robertoallende.randomuser.base.BaseViewModel
import com.robertoallende.randomuser.data.RandomUserRepository
import com.robertoallende.randomuser.model.User

class UserDetailViewModel(
    val user: User,
    private val repository: RandomUserRepository
) : BaseViewModel<UserDetailEvent>() {

}