package com.jo.feature.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.feature.my.MyScreen

const val MyRoute = "MyRoute"

fun NavController.navigateToMy(navOptions: NavOptions) = navigate(route = MyRoute, navOptions)

fun NavGraphBuilder.myScreen () {
    composable(MyRoute) {
        MyScreen("Android")
    }
}