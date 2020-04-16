package com.robertoallende.randomuser.ui.user_list

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import com.robertoallende.randomuser.R
import com.robertoallende.randomuser.base.BaseActivity
import com.robertoallende.randomuser.databinding.ActivityUserListBinding
import com.robertoallende.randomuser.model.User
import com.robertoallende.randomuser.ui.user_detail.UserDetailActivity
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
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvUserList.addItemDecoration(decoration)

        viewModel.randomUsers.observe(this, Observer<PagedList<User>> {
            Timber.d("Activity list: ${it?.size}")
            // showEmptyList(it?.size == 0)
            adapter.submitList(it)
        })

        viewModel.events.observe(this, Observer {
            when (it) {
                is UserListEvent.GoToUserDetail -> openUserDetail(it.user)
            }
        })
    }

    private fun onUserClicked(user: User) {
        viewModel.onUserClicked(user)
    }

    private fun openUserDetail(user: User) {
        startActivity(UserDetailActivity.getIntent(this, user))
    }
}
