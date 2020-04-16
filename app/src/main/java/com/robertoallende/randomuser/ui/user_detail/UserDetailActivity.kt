package com.robertoallende.randomuser.ui.user_detail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.robertoallende.randomuser.R
import com.robertoallende.randomuser.base.BaseActivity
import com.robertoallende.randomuser.databinding.ActivityUserDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailActivity : BaseActivity<UserDetailEvent, UserDetailViewModel>() {

    private lateinit var binding: ActivityUserDetailBinding
    override val viewModel: UserDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

}
