package com.kardelencetin.moviekmm.domain.repository

import com.kardelencetin.moviekmm.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}