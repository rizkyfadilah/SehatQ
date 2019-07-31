package com.rizkyfadilah.sehatq.data.repository

import com.rizkyfadilah.sehatq.data.source.cloud.BaseCloudRepository
import com.rizkyfadilah.sehatq.data.source.db.ProductDao
import com.rizkyfadilah.sehatq.domain.model.HomeEntity
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.domain.repository.AppRepository
import javax.inject.Inject

class AppRepoImp @Inject constructor(
    private val cloudRepository: BaseCloudRepository,
    private val productDao: ProductDao
) : AppRepository {

    override suspend fun getHomes(): HomeEntity {
        return cloudRepository.getHomes()
    }

    override suspend fun saveProduct(product: Product): Long {
        productDao.insertProduct(product)
        return 0L
    }

    override suspend fun selectAllProduct(): MutableList<Product> {
        return productDao.selectAllProduct()
    }
}