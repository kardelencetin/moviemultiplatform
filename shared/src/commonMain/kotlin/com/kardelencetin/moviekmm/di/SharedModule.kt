package com.kardelencetin.moviekmm.di

import com.kardelencetin.moviekmm.data.remote.MovieService
import com.kardelencetin.moviekmm.data.remote.RemoteDataSource
import com.kardelencetin.moviekmm.data.repository.MovieRepositoryImpl
import com.kardelencetin.moviekmm.domain.repository.MovieRepository
import com.kardelencetin.moviekmm.domain.usecase.GetMovieUseCase
import com.kardelencetin.moviekmm.domain.usecase.GetMoviesUseCase
import com.kardelencetin.moviekmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory {
        RemoteDataSource(get(), get())
    }
    factory {
        MovieService()
    }
}

private val utilModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    factory {
        GetMovieUseCase()
    }
    factory {
        GetMoviesUseCase()
    }
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
}

private val sharedModules = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModules