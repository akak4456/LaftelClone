package com.jo.laftelclone.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.jo.laftelclone.feature.splash.navigation.SplashRoute
import com.jo.laftelclone.feature.splash.navigation.splashSection
import com.jo.laftelclone.navigation.LaftelCloneNavHost

@Composable
fun LaftelCloneApp (
    appState: LaftelCloneAppState,
    modifier: Modifier = Modifier
) {
    LaftelCloneNavHost(appState, modifier)
}