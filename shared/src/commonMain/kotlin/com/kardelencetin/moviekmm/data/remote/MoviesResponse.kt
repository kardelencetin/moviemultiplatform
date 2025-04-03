package com.kardelencetin.moviekmm.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    val results: List<MovieRemote>
)