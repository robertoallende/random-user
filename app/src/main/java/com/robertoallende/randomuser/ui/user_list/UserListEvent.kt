package com.robertoallende.randomuser.ui.user_list

import android.widget.ImageView
import android.widget.TextView
import com.robertoallende.randomuser.base.BaseEvent
import com.robertoallende.randomuser.model.User

sealed class UserListEvent : BaseEvent {
    class GoToUserDetail(val user: User, val iv: ImageView) : UserListEvent()
}