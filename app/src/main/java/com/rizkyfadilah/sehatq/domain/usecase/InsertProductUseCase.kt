package com.rizkyfadilah.sehatq.domain.usecase

import com.rizkyfadilah.sehatq.data.mapper.CloudErrorMapper
import com.rizkyfadilah.sehatq.domain.model.Product
import com.rizkyfadilah.sehatq.domain.repository.AppRepository
import com.rizkyfadilah.sehatq.domain.usecase.base.UseCase
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.domain.usecase
 * Created by rizkyfadilah on 2019-07-31.
 */

class InsertProductUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val appRepository: AppRepository
) : UseCase<Long>(errorUtil) {
    lateinit var product: Product
    override suspend fun executeOnBackground(): Long {
        return appRepository.saveProduct(product)
    }

}