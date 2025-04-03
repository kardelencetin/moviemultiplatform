package com.kardelencetin.moviekmm.data.util

import com.kardelencetin.moviekmm.data.remote.MovieRemote
import com.kardelencetin.moviekmm.domain.model.Movie

internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(image: String) = "https://image.tmdb.org/t/p/w500/$image"