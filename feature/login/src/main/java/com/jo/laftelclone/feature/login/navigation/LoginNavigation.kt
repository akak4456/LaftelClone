package com.jo.laftelclone.feature.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.laftelclone.feature.login.LoginScreen
import kotlinx.serialization.Serializable

@Serializable
data object LoginRoute

fun NavController.navigateToLogin(navOptions: NavOptions? = null) = navigate(route = LoginRoute, navOptions)

fun NavGraphBuilder.loginSection() {
    composable<LoginRoute> {
        LoginScreen()
    }
}