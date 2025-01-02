package com.jo.laftelclone.ui

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jo.feature.my.navigation.navigateToMy
import com.jo.laftelclone.R
import com.jo.laftelclone.navigation.LaftelCloneNavHost
import com.jo.laftelclone.navigation.TopLevelDestination
import com.jo.laftelclone.ui.theme.LaftelBaseColor
import com.jo.laftelclone.ui.theme.LaftelBlackColor

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
    NavigationBar(containerColor = Color.White, contentColor = Color.White) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        TopLevelDestination.entries.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                selected = selected,
                icon = { Image(
                    painter = painterResource(
                        if(item.isMyIcon) R.drawable.ic_my_example // TODO my icon glide 등으로 호출하기
                        else if(selected) item.selectedIcon else item.unselectedIcon
                    ),
                    contentDescription = null
                )},
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
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.White,
                    selectedTextColor = LaftelBaseColor,
                    selectedIndicatorColor = Color.White,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = LaftelBlackColor,
                    disabledIconColor = Color.White,
                    disabledTextColor = LaftelBlackColor,
                )
            )
        }
    }
}