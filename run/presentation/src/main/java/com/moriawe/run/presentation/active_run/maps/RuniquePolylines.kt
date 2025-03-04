package com.moriawe.run.presentation.active_run.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polyline
import com.moriawe.core.domain.location.LocationTimestamp

@Composable
fun RuniquePolylines(locations: List<List<LocationTimestamp>>) {

    val polylines = remember(locations) {
        locations.map {
            it.zipWithNext { timestamp1, timestamp2 ->
                PolyLineUi(
                    location1 = timestamp1.location.location,
                    location2 = timestamp2.location.location,
                    color = PolylineCalculator.locationsToColor(
                        location1 = timestamp1,
                        location2 = timestamp2
                    )
                )
            }
        }
    }

    polylines.forEach { polyline ->
        polyline.forEach { polylineUi ->
            Polyline(
                points = listOf(
                    LatLng(polylineUi.location1.latitude, polylineUi.location1.longitude),
                    LatLng(polylineUi.location2.latitude, polylineUi.location2.longitude)
                ),
                color = polylineUi.color,
                jointType = JointType.BEVEL
            )
        }
    }

}