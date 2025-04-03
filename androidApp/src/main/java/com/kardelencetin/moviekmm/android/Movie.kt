package com.kardelencetin.moviekmm.android

import android.app.Application
import com.kardelencetin.moviekmm.android.di.appModule
import com.kardelencetin.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

class Movie : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}