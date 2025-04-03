package com.kardelencetin.moviekmm.android.detail

import com.kardelencetin.moviekmm.domain.model.Movie

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)