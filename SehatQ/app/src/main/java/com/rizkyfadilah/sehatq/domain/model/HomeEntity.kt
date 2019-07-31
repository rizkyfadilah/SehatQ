package com.rizkyfadilah.sehatq.domain.model

import com.google.gson.annotations.SerializedName

/**
 * com.rizkyfadilah.sehatq.domain.model
 * Created by rizkyfadilah on 2019-07-31.
 */

data class HomeEntity(
    @SerializedName("data") var data: DataEntity
)
