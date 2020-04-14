package com.robertoallende.randomuser.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<E : BaseEvent, VM: BaseViewModel<E>> : AppCompatActivity() {

    abstract val viewModel: VM

}