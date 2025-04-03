package com.kardelencetin.moviekmm.android

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kardelencetin.moviekmm.android.common.Detail
import com.kardelencetin.moviekmm.android.common.Home
import com.kardelencetin.moviekmm.android.common.MovieAppBar
import com.kardelencetin.moviekmm.android.common.movieDestinations
import com.kardelencetin.moviekmm.android.detail.DetailScreen
import com.kardelencetin.moviekmm.android.detail.DetailViewModel
import com.kardelencetin.moviekmm.android.home.HomeScreen
import com.kardelencetin.moviekmm.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieApp() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val backStackEntry by  navController.currentBackStackEntryAsState()
    val currentScreen = movieDestinations.find {
        backStackEntry?.destination?.route == it.route ||
                backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen) {
                navController.navigateUp()
            }
        }
    ) {
        paddingValues -> NavHost(
                            navController = navController,
                            modifier = Modifier.padding(paddingValues),
                            startDestination = Home.route) {
            composable(Home.routeWithArgs) {
                val homeViewModel : HomeViewModel = koinViewModel()
                HomeScreen(uiState = homeViewModel.uiState,
                    loadNextMovies = {
                        homeViewModel.loadMovies(forceReload = it)
                    },
                    navigateToDetail = {
                        navController.navigate(
                            "${Detail.route}/${it.id}"
                        )
                    }
                )
            }

            composable(Detail.routeWithArgs, arguments = Detail.arguments) {
                val movieId = it.arguments?.getInt("movieId")
                val detailViewModel: DetailViewModel = koinViewModel(
                    parameters = { parametersOf(movieId) }
                )
                DetailScreen(uiState = detailViewModel.uiState)
            }
        }
    }
}