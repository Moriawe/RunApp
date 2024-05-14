package com.moriawe.myrunique

import android.app.Application
import com.moriawe.auth.data.di.authDataModule
import com.moriawe.auth.presentation.di.authViewModelModule
import com.moriawe.core.data.di.coreDataModule
import com.moriawe.core.database.di.databaseModule
import com.moriawe.myrunique.di.appModule
import com.moriawe.run.location.di.locationModule
import com.moriawe.run.presentation.di.runPresentationModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyRuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        //if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        //}

        startKoin {
            androidLogger()
            androidContext(this@MyRuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule
            )
        }
    }
}