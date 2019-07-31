package com.rizkyfadilah.sehatq.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.domain.usecase.InsertProductUseCase
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.ui.detail
 * Created by rizkyfadilah on 2019-07-31.
 */

class DetailViewModel
@Inject constructor(
    private val insertProductUseCase: InsertProductUseCase
) : ViewModel() {
    val status: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    fun insert(product: Product) {
        insertProductUseCase.product = product
        insertProductUseCase.execute {
            onComplete {
                status.value = true
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        insertProductUseCase.unsubscribe()
    }
}