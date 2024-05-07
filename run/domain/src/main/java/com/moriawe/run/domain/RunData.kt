package com.moriawe.run.domain

import com.moriawe.core.domain.location.LocationTimestamp
import kotlin.time.Duration

data class RunData(
    val distanceInMeters: Int = 0,
    val pace: Duration = Duration.ZERO,
    val locations: List<List<LocationTimestamp>> = emptyList(),

    )
