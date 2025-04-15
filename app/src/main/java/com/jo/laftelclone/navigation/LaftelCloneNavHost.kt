package com.jo.laftelclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.jo.laftelclone.feature.main.navigation.mainSection
import com.jo.laftelclone.feature.main.navigation.navigateToMain
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
            navController.navigateToMain(navOptions {
                popUpTo(SplashRoute) {
                    inclusive = true // Splash 화면도 같이 스택에서 제거
                }
                launchSingleTop = true // 중복 방지 (선택)
            })
        })
        mainSection()
    }
}