package com.moriawe.myrunique

import android.app.Application
import com.moriawe.auth.data.di.authDataModule
import com.moriawe.auth.presentation.di.authViewModelModule
import com.moriawe.myrunique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyRuniqueApp: Application() {

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
                appModule
            )
        }
    }
}