package com.robertoallende.randomuser.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.robertoallende.randomuser.common.SingleLiveEvent
import org.koin.core.KoinComponent

abstract class BaseViewModel<T : BaseEvent> : ViewModel(), KoinComponent {

    private val _events = SingleLiveEvent<T>()
    val events: LiveData<T>
        get() = _events

}
