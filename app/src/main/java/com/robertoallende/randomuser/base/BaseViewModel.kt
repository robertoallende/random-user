package com.robertoallende.randomuser.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertoallende.randomuser.RadomUserIdlingResource
import com.robertoallende.randomuser.common.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.jetbrains.annotations.TestOnly
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<T : BaseEvent> : ViewModel(), KoinComponent {

    private val _events = SingleLiveEvent<T>()
    val events: LiveData<T>
        get() = _events

    protected fun postEvent(event: T?, sync: Boolean = false) {
        if (sync) {
            _events.value = event
        } else {
            _events.postValue(event)
        }
    }

    @TestOnly
    fun getViewModelScope() = viewModelScope
}
