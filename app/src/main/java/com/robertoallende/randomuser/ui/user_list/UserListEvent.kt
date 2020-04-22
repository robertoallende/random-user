package com.robertoallende.randomuser.ui.user_list

import com.robertoallende.randomuser.base.BaseEvent
import com.robertoallende.randomuser.model.User

sealed class UserListEvent : BaseEvent {
    class GoToUserDetail(val user: User, val position: Int) : UserListEvent()
    class DisplayError(val message: String) : UserListEvent()
}