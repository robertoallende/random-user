package com.robertoallende.randomuser.ui.user_detail

import com.robertoallende.randomuser.base.BaseViewModel
import com.robertoallende.randomuser.api.ApiContract

class UserDetailViewModel(
    private val dataRepository: ApiContract
) : BaseViewModel<UserDetailEvent>() {

}