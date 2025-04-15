package com.jo.laftelclone.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.laftelclone.feature.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null) = navigate(route = HomeRoute, navOptions)

fun NavGraphBuilder.homeSection() {
    composable<HomeRoute> {
        HomeScreen()
    }
}