package com.moriawe.run.data.di

import com.moriawe.core.domain.run.SyncRunScheduler
import com.moriawe.run.data.CreateRunWorker
import com.moriawe.run.data.DeleteRunWorker
import com.moriawe.run.data.FetchRunsWorker
import com.moriawe.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}