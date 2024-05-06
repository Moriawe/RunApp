package com.moriawe.core.domain

data class AuthInfo(
    //JWT Jason Web Token
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)
