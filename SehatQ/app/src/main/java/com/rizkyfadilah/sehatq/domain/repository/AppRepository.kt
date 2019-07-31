package com.rizkyfadilah.sehatq.domain.repository

import com.rizkyfadilah.sehatq.domain.model.HomeEntity
import com.rizkyfadilah.sehatq.domain.model.Product

interface AppRepository{
    suspend fun getHomes(): HomeEntity
    suspend fun saveProduct(product: Product): Long
    suspend fun selectAllProduct() : MutableList<Product>
}