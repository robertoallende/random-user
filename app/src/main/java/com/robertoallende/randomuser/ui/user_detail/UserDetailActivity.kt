package com.robertoallende.randomuser.ui.user_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.robertoallende.randomuser.R
import com.robertoallende.randomuser.base.BaseActivity
import com.robertoallende.randomuser.databinding.ActivityUserDetailBinding
import com.robertoallende.randomuser.model.User
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailActivity : BaseActivity<UserDetailEvent, UserDetailViewModel>() {

    private lateinit var binding: ActivityUserDetailBinding
    override val viewModel: UserDetailViewModel by viewModel(parameters = {
        parametersOf(intent.getParcelableExtra(USER_EXTRA))
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {
        const val USER_EXTRA = "UserDetailActivity.USER"

        fun getIntent(context: Context, user: User): Intent =
            Intent(context, UserDetailActivity::class.java).apply {
                putExtra(USER_EXTRA, user)
            }
    }
}
