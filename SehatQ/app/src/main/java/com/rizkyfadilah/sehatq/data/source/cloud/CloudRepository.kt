package com.rizkyfadilah.sehatq.data.source.cloud

import com.rizkyfadilah.sehatq.data.restful.ApiService
import com.rizkyfadilah.sehatq.domain.model.HomeEntity

class CloudRepository(private val apIs: ApiService) : BaseCloudRepository {

    override suspend fun getHomes(): HomeEntity {
        return apIs.getHomes().await()
    }
}
