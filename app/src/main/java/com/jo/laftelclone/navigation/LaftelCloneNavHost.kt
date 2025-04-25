package com.jo.laftelclone.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import com.jo.laftelclone.feature.main.navigation.MainRoute
import com.jo.laftelclone.feature.main.navigation.mainSection
import com.jo.laftelclone.feature.main.navigation.navigateToMain
import com.jo.laftelclone.feature.splash.navigation.SplashRoute
import com.jo.laftelclone.feature.splash.navigation.splashSection
import com.jo.laftelclone.ui.LaftelCloneAppState

@OptIn(ExperimentalAnimationApi::class)
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
                launchSingleTop = true
            })
        },
        onNavigateToLogin = {
            navController.navigateToLogin(navOptions {
                launchSingleTop = true // 중복 클릭 방지
            })
        }
    )
    val animDuration = 700
    CompositionLocalProvider(LocalClickHandlers provides clickHandlers) {
        NavHost(
            navController = appState.navController,
            startDestination = SplashRoute,
            enterTransition = {
                if (initialState.destination.route == SplashRoute::class.qualifiedName && targetState.destination.route == MainRoute::class.qualifiedName) {
                    // splash -> main 은 애니메이션 없음
                    fadeIn(tween(durationMillis = animDuration))
                } else {
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(durationMillis = animDuration)
                    )
                }
            },
            exitTransition = {
                if (initialState.destination.route == SplashRoute::class.qualifiedName && targetState.destination.route == MainRoute::class.qualifiedName) {
                    // splash -> main 은 애니메이션 없음
                    fadeOut(tween(durationMillis = animDuration))
                } else {
                    slideOutHorizontally(
                        targetOffsetX = { -it },
                        animationSpec = tween(durationMillis = animDuration)
                    )
                }
            },
            popEnterTransition = {
                if (initialState.destination.route == SplashRoute::class.qualifiedName && targetState.destination.route == MainRoute::class.qualifiedName) {
                    // splash -> main 은 애니메이션 없음
                    fadeIn(tween(durationMillis = animDuration))
                } else {
                    slideInHorizontally(
                        initialOffsetX = { -it },
                        animationSpec = tween(durationMillis = animDuration)
                    )
                }
            },
            popExitTransition = {
                if (initialState.destination.route == SplashRoute::class.qualifiedName && targetState.destination.route == MainRoute::class.qualifiedName) {
                    // splash -> main 은 애니메이션 없음
                    fadeOut(tween(durationMillis = animDuration))
                } else {
                    slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = tween(durationMillis = animDuration)
                    )
                }
            }
        ) {
            splashSection()
            mainSection()
            loginSection()
        }
    }
}