package com.rizkyfadilah.sehatq.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.domain.model.response.ErrorModel
import com.rizkyfadilah.sehatq.domain.usecase.GetDataUseCase
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.ui.order
 * Created by rizkyfadilah on 2019-07-31.
 */

class SearchViewModel
@Inject constructor(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {
    private var products: List<Product> = mutableListOf()
    val productList: MutableLiveData<List<Product>> by lazy { MutableLiveData<List<Product>>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }

    init {
        getDataUseCase.execute {
            onComplete {
                products = mutableListOf()
                products = it.data.productList
                productList.value = products
            }
            onError {
                error.value = it
            }
        }
    }

    fun search(text: String) {
        products.filter {
            it.description.toLowerCase().contains(text.toLowerCase())
        }.let {
            productList.value = it
        }
    }

    override fun onCleared() {
        super.onCleared()
        getDataUseCase.unsubscribe()
    }
}