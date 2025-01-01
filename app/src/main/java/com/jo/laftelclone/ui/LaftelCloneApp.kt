package com.jo.laftelclone.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jo.feature.my.navigation.navigateToMy
import com.jo.laftelclone.navigation.LaftelCloneNavHost
import com.jo.laftelclone.navigation.TopLevelDestination

@Composable
internal fun LaftelCloneApp(
    appState: LaftelCloneAppState
) {
    Scaffold(
        bottomBar = {BottomNavigationBar(navController = appState.navController)}
    ) { innerPadding ->
        LaftelCloneNavHost(appState, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        TopLevelDestination.entries.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                icon = { Icons.Default.Home },
                label = { Text(stringResource(item.iconTextId)) },
                onClick = {
                    if(currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}