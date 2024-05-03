package com.moriawe.auth.domain

import com.moriawe.core.domain.util.DataError
import com.moriawe.core.domain.util.EmptyResult

interface AuthRepository {

    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>

}