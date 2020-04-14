package com.robertoallende.randomuser.screens.user_list

import android.os.Bundle
import com.robertoallende.randomuser.R
import com.robertoallende.randomuser.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListActivity() : BaseActivity<UserListEvent, UserListViewModel>() {

    override val viewModel: UserListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
    }

}
