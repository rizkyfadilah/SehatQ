package com.rizkyfadilah.sehatq.domain.usecase

import com.rizkyfadilah.sehatq.data.mapper.CloudErrorMapper
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.domain.repository.AppRepository
import com.rizkyfadilah.sehatq.domain.usecase.base.UseCase
import javax.inject.Inject

class GetAllProductUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val appRepository: AppRepository
) : UseCase<MutableList<Product>>(errorUtil) {
    override suspend fun executeOnBackground(): MutableList<Product> {
        return appRepository.selectAllProduct()
    }
}
