package com.moriawe.run.presentation.run_overview.mapper

import com.moriawe.core.domain.run.Run
import com.moriawe.core.presentation.ui.formatted
import com.moriawe.core.presentation.ui.toFormattedKm
import com.moriawe.core.presentation.ui.toFormattedKmh
import com.moriawe.core.presentation.ui.toFormattedMeters
import com.moriawe.core.presentation.ui.toFormattedPace
import com.moriawe.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyy - hh:mma")
        .format(dateTimeInLocalTime)

    val distanceKm = distanceInMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl
    )
}