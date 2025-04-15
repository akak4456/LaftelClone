package com.jo.laftelclone.feature.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import com.jo.laftelclone.feature.main.MainScreen

@Serializable data object MainRoute

fun NavController.navigateToMain(navOptions: NavOptions? = null) = navigate(route = MainRoute, navOptions)

fun NavGraphBuilder.mainSection() {
    composable<MainRoute> {
        MainScreen()
    }
}