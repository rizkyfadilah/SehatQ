package com.rizkyfadilah.sehatq.data.source.cloud

import com.rizkyfadilah.sehatq.domain.model.HomeEntity

interface BaseCloudRepository {
   suspend fun getHomes(): HomeEntity
}