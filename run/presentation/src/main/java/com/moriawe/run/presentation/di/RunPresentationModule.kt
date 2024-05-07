package com.moriawe.run.presentation.di

import com.moriawe.run.presentation.run_overview.RunOverviewViewModel
import com.moriawe.run.presentation.active_run.ActiveRunViewModel
import com.moriawe.run.domain.RunningTracker
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
    singleOf(::RunningTracker)
}