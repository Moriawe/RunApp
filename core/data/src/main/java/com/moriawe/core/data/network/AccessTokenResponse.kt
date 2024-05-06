package com.moriawe.core.data.network

import kotlinx.serialization.Serializable

@Serializable
class AccessTokenResponse(
    val accessToken: String,
    val expirationTimeStamp: String
) {
}