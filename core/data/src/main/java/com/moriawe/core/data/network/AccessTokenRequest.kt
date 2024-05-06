package com.moriawe.core.data.network

import kotlinx.serialization.Serializable

@Serializable
class AccessTokenRequest(
    val refreshToken: String,
    val userId: String
) {
}