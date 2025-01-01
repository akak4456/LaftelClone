package com.jo.feature.box.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.feature.box.BoxScreen

const val BoxRoute = "BoxRoute"

fun NavController.navigateToBox(navOptions: NavOptions) = navigate(route = BoxRoute, navOptions)

fun NavGraphBuilder.boxScreen () {
    composable(BoxRoute) {
        BoxScreen("Android")
    }
}