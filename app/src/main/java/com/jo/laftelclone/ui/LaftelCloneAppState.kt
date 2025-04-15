package com.jo.laftelclone.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberLaftelCloneAppState(
    navController: NavHostController = rememberNavController()
): LaftelCloneAppState {
    return remember(
        navController
    ) {
        LaftelCloneAppState(
            navController = navController
        )
    }
}

@Stable
class LaftelCloneAppState (
    val navController: NavHostController
) {
}