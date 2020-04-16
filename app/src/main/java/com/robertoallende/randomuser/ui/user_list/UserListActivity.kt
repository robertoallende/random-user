package com.robertoallende.randomuser.ui.user_list

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.robertoallende.randomuser.R
import com.robertoallende.randomuser.base.BaseActivity
import com.robertoallende.randomuser.databinding.ActivityUserListBinding
import com.robertoallende.randomuser.model.User
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class UserListActivity : BaseActivity<UserListEvent, UserListViewModel>() {

    private lateinit var binding: ActivityUserListBinding
    override val viewModel: UserListViewModel by viewModel()
    private val adapter = UserAdapter(::onUserClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.rvUserList.adapter = adapter
        viewModel.randomUsers.observe(this, Observer<PagedList<User>> {
            Timber.d("Activity list: ${it?.size}")
            // showEmptyList(it?.size == 0)
            adapter.submitList(it)
        })
    }

    private fun onUserClicked(user: User) {

    }
}
