package com.rizkyfadilah.sehatq.domain.usecase

import com.rizkyfadilah.sehatq.data.mapper.CloudErrorMapper
import com.rizkyfadilah.sehatq.domain.model.HomeEntity
import com.rizkyfadilah.sehatq.domain.repository.AppRepository
import com.rizkyfadilah.sehatq.domain.usecase.base.UseCase
import javax.inject.Inject

/**
 * com.rizkyfadilah.sehatq.domain.usecase
 * Created by rizkyfadilah on 2019-07-31.
 */

class GetDataUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val appRepository: AppRepository
) : UseCase<HomeEntity>(errorUtil) {
    override suspend fun executeOnBackground(): HomeEntity {
        return appRepository.getHomes()
    }

}