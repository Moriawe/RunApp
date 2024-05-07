package com.moriawe.run.presentation.di

import com.moriawe.run.presentation.run_overview.RunOverviewViewModel
import com.moriawe.run.presentation.active_run.ActiveRunViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}