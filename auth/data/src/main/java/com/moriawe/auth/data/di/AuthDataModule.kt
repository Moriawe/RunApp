package com.moriawe.auth.data.di

import com.moriawe.auth.data.EmailPatternValidator
import com.moriawe.auth.domain.AuthRepository
import com.moriawe.auth.domain.PatternValidator
import com.moriawe.auth.domain.UserDataValidator
import com.moriawe.auth.data.AuthRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> { EmailPatternValidator }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}