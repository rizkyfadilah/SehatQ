package com.rizkyfadilah.sehatq.data.restful

import com.rizkyfadilah.sehatq.domain.model.HomeEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("home")
    fun getHomes(): Deferred<HomeEntity>

}