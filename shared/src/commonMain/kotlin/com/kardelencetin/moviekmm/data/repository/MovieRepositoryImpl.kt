package com.kardelencetin.moviekmm.data.repository

import com.kardelencetin.moviekmm.data.remote.RemoteDataSource
import com.kardelencetin.moviekmm.data.util.toMovie
import com.kardelencetin.moviekmm.domain.model.Movie
import com.kardelencetin.moviekmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}