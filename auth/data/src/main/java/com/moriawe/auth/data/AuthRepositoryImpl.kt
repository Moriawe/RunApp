package com.moriawe.auth.data

import com.moriawe.auth.domain.AuthRepository
import com.moriawe.core.data.network.post
import com.moriawe.core.domain.util.DataError
import com.moriawe.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }

}