package com.leskov.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

abstract class BaseViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    // todo Refactor
    protected suspend fun <T> launchSingleRequest(
        liveData: MutableLiveData<T>,
        context: CoroutineScope = viewModelScope,
        block: suspend MutableLiveData<T>.() -> Unit
    ) = context.runCatching {
        isLoading.postValue(true)
        block.invoke(liveData)
    }.onSuccess {
        isLoading.postValue(false)
    }.onFailure { exception ->
        isLoading.postValue(false)
        errorMessage.postValue(exception.localizedMessage)
    }

    override fun onCleared() {
        super.onCleared()
        isLoading.value = null
        errorMessage.value = null
    }
}