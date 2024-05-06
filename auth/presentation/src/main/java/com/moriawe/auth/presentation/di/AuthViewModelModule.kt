package com.moriawe.auth.presentation.di

import com.moriawe.auth.presentation.register.RegisterViewModel
import com.moriawe.auth.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}