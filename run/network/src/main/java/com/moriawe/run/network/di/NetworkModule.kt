package com.moriawe.run.network.di

import com.moriawe.core.domain.run.RemoteRunDataSource
import com.moriawe.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}