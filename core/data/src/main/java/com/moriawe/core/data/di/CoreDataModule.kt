package com.moriawe.core.data.di

import com.moriawe.core.data.auth.EncryptedSessionStorage
import com.moriawe.core.data.network.HttpClientFactory
import com.moriawe.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}