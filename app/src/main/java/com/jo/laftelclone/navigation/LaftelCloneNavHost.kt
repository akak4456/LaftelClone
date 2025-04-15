package com.jo.laftelclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.jo.laftelclone.feature.splash.navigation.SplashRoute
import com.jo.laftelclone.feature.splash.navigation.splashSection
import com.jo.laftelclone.ui.LaftelCloneAppState

@Composable
fun LaftelCloneNavHost(
    appState: LaftelCloneAppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    NavHost(navController = appState.navController, startDestination = SplashRoute) {
        splashSection(goToMain = {
            
        })
    }
}