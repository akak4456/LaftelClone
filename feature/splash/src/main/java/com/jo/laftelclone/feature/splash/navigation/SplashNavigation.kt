package com.jo.laftelclone.feature.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.laftelclone.feature.splash.SplashScreen
import kotlinx.serialization.Serializable

@Serializable data object SplashRoute

fun NavController.navigateToSplash(navOptions: NavOptions? = null) = navigate(route = SplashRoute, navOptions)

fun NavGraphBuilder.splashSection(goToMain: () -> Unit) {
    composable<SplashRoute> {
        SplashScreen(goToMain)
    }
}