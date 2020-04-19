package com.robertoallende.randomuser.ui.user_list

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import com.robertoallende.randomuser.R
import com.robertoallende.randomuser.base.BaseActivity
import com.robertoallende.randomuser.databinding.ActivityUserListBinding
import com.robertoallende.randomuser.model.User
import com.robertoallende.randomuser.ui.user_detail.UserDetailActivity
import kotlinx.android.synthetic.main.item_user.view.*
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

        viewModel.randomUsers?.observe(this, Observer<PagedList<User>> {
            adapter.submitList(it)
            viewModel.onRandomUsersUpdated()
        })

        viewModel.networkError?.observe(this, Observer<String> {
            viewModel.onNetworkError(it)
        })

        viewModel.events.observe(this, Observer {
            when (it) {
                is UserListEvent.GoToUserDetail -> openUserDetail(it.user, it.position)
                is UserListEvent.DisplayError -> displayError(it.message)
            }
        })

        enableFadeTransition()
    }

    private fun displayError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    private fun onUserClicked(user: User, position: Int) {
        viewModel.onUserClicked(user, position)
    }

    private fun openUserDetail(user: User, position: Int) {
        val newIntent = UserDetailActivity.getIntent(this, user)
        val view =
            binding.rvUserList.findViewHolderForAdapterPosition(position)?.itemView?.iv_avatar
        view?.let {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair(view, getString(R.string.avatar_transition))
            )
            startActivity(newIntent, options.toBundle())
        } ?: startActivity(newIntent)
    }
}
