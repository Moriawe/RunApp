package com.moriawe.core.data.di

import com.moriawe.core.data.network.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}