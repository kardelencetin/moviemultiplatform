package com.kardelencetin.moviekmm.android.di

import com.kardelencetin.moviekmm.android.detail.DetailViewModel
import com.kardelencetin.moviekmm.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
       parametersHolder ->  DetailViewModel(get(), movieId = parametersHolder.get())
    }
}