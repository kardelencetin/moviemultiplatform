package com.kardelencetin.moviekmm.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io: CoroutineDispatcher
}

internal expect fun provideDispatcher(): Dispatcher

// expect vs actual -> expect yazılan şeylerin iki taraftada uygulanması gerekir