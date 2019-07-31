package com.rizkyfadilah.sehatq.ui.order

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.domain.usecase.GetAllProductUseCase
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.ui.order
 * Created by rizkyfadilah on 2019-07-31.
 */

class OrderViewModel
@Inject constructor(
    private val getAllProductUseCase: GetAllProductUseCase
) : ViewModel() {
    val productList: MutableLiveData<List<Product>> by lazy { MutableLiveData<List<Product>>() }

    init {
        getAllProductUseCase.execute {
            onComplete {
                productList.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        getAllProductUseCase.unsubscribe()
    }
}