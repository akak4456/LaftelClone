package com.jo.laftelclone.feature.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.laftelclone.feature.my.MyScreen
import kotlinx.serialization.Serializable

@Serializable
data object MyRoute

fun NavController.navigateToMy(navOptions: NavOptions? = null) = navigate(route = MyRoute, navOptions)

fun NavGraphBuilder.mySection() {
    composable<MyRoute> {
        MyScreen()
    }
}