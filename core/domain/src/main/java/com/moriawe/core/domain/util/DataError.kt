package com.moriawe.core.domain.util

sealed interface DataError: Error {

    enum class Network: DataError {
        REQUEST_TIMEOUT,
        UNAUTHORIZED,
        CONFLICT,
        TOO_MANY_REQUESTS,
        NO_INTERNET_CONNECTION,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERIALIZATION_ERROR,
        UNKNOWN_ERROR
    }

    enum class Local: DataError {
        DISK_FULL,
        FILE_NOT_FOUND
    }

    enum class PasswordValidationError: Error {
        TOO_SHORT,
        MISSING_DIGIT,
    }
}


// TODO: Just Examples
fun validatePassword(password: String): Result<Unit, DataError.PasswordValidationError> {
    if (password.length < 8) {
        return Result.Error(DataError.PasswordValidationError.TOO_SHORT)
    }

    if (!password.any { it.isDigit() }) {
        return Result.Error(DataError.PasswordValidationError.MISSING_DIGIT)
    }

    return Result.Success(Unit)
}

fun handleError(result: Result<Unit, DataError.PasswordValidationError>) {
    when (result) {
        is Result.Success -> println("Password is valid")
        is Result.Error -> {
            when (result.error) {
                DataError.PasswordValidationError.TOO_SHORT -> println("Password is too short")
                DataError.PasswordValidationError.MISSING_DIGIT -> println("Password is missing a digit")
            }
        }
    }
}