package com.robertoallende.randomuser.screens.user_detail

import com.robertoallende.randomuser.base.BaseViewModel
import com.robertoallende.randomuser.data.ApiContract

class UserDetailViewModel(
    private val dataRepository: ApiContract
) : BaseViewModel<UserDetailEvent>() {

}