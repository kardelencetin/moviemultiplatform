package com.kardelencetin.moviekmm.util

import com.kardelencetin.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}