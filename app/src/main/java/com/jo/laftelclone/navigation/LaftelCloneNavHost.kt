package com.jo.laftelclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.jo.feature.box.navigation.boxScreen
import com.jo.feature.home.navigation.HomeRoute
import com.jo.feature.home.navigation.homeScreen
import com.jo.feature.my.navigation.myScreen
import com.jo.feature.tagsearch.navigation.tagSearchScreen
import com.jo.laftelclone.ui.LaftelCloneAppState

@Composable
fun LaftelCloneNavHost(
    appState: LaftelCloneAppState,
    modifier: Modifier = Modifier
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier,
    ) {
        homeScreen() // 홈 화면
        tagSearchScreen() // 태그검색 화면
        boxScreen() // 보관함 화면
        myScreen() // my 화면
    }
}