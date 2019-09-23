package com.rizkyfadilah.sehatq.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rizkyfadilah.sehatq.domain.model.DataEntity
import com.rizkyfadilah.sehatq.domain.model.response.ErrorModel
import com.rizkyfadilah.sehatq.domain.usecase.GetDataUseCase
import javax.inject.Inject

class HomeViewModel
@Inject constructor(
    private val getDataUseCase: GetDataUseCase) : ViewModel() {
    val data: MutableLiveData<DataEntity> by lazy { MutableLiveData<DataEntity>() }
    val error : MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    init {
        getDataUseCase.execute {
            onComplete {
                data.value = it.data
            }
            onError {
                error.value = it
            }
        }
    }

    private fun doReshresh() {

    }

    override fun onCleared() {
        super.onCleared()
        getDataUseCase.unsubscribe()
    }
}