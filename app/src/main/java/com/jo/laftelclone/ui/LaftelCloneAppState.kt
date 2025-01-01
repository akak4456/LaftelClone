package com.jo.laftelclone.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.DisposableEffectResult
import androidx.compose.runtime.DisposableEffectScope
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberLaftelCloneAppState(
    navController: NavHostController = rememberNavController()
): LaftelCloneAppState {
    return remember {
        LaftelCloneAppState(navController)
    }
}

@Stable
class LaftelCloneAppState(
    val navController: NavHostController
) {
}