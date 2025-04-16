package com.jo.laftelclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.jo.laftelclone.core.designsystem.component.ClickHandlers
import com.jo.laftelclone.core.designsystem.component.LocalClickHandlers
import com.jo.laftelclone.feature.login.navigation.loginSection
import com.jo.laftelclone.feature.login.navigation.navigateToLogin
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

    val clickHandlers = ClickHandlers(
        onNavigateToMain = {
            navController.navigateToMain(navOptions {
                popUpTo(SplashRoute) {
                    inclusive = true // Splash 화면도 같이 스택에서 제거
                }
                launchSingleTop = true // 중복 방지 (선택)
            })
        },
        onNavigateToLogin = {
            navController.navigateToLogin()
        }
    )
    CompositionLocalProvider(LocalClickHandlers provides clickHandlers) {
        NavHost(navController = appState.navController, startDestination = SplashRoute) {
            splashSection()
            mainSection()
            loginSection()
        }
    }
}