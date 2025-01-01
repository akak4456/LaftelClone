package com.jo.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.feature.home.HomeScreen

const val HomeRoute = "HomeRoute"

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(route = HomeRoute, navOptions)

fun NavGraphBuilder.homeScreen () {
    composable(HomeRoute) {
        HomeScreen("Android")
    }
}