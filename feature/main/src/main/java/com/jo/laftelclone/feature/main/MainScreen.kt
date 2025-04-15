package com.jo.laftelclone.feature.main

import android.util.Log
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.jo.laftelclone.core.designsystem.theme.Primary
import com.jo.laftelclone.core.designsystem.theme.PrimaryDark
import com.jo.laftelclone.feature.home.navigation.HomeRoute
import com.jo.laftelclone.feature.home.navigation.homeSection
import com.jo.laftelclone.feature.home.navigation.navigateToHome
import com.jo.laftelclone.feature.my.navigation.mySection
import com.jo.laftelclone.feature.my.navigation.navigateToMy
import com.jo.laftelclone.feature.storage.navigation.navigateToStorage
import com.jo.laftelclone.feature.storage.navigation.storageSection
import com.jo.laftelclone.feature.tagsearch.navigation.navigateToTagSearch
import com.jo.laftelclone.feature.tagsearch.navigation.tagSearchSection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlin.reflect.KClass

@Composable
internal fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomBar(navController)
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            homeSection()
            tagSearchSection()
            storageSection()
            mySection()
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    NavigationBar(containerColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        TopLevelDestination.entries.forEach { destination ->
            val selected = currentDestination
                .isRouteInHierarchy(destination.route)
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (destination.isMy) {
                                // TODO 적절한 my icon 설정하기
                                R.drawable.ic_my_empty
                            } else {
                                if (selected) {
                                    destination.selectedIcon
                                } else {
                                    destination.unselectedIcon
                                }
                            }
                        ),
                        contentDescription = if (destination.isMy) {
                            // TODO 적절한 my text 설정하기
                            "akak4456"
                        } else {
                            stringResource(id = destination.titleTextId)
                        },
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                },
                label = {
                    Text(
                        text =
                            if (destination.isMy) {
                                // TODO 적절한 my text 설정하기
                                "akak4456"
                            } else {
                                stringResource(id = destination.titleTextId)
                            }
                    )
                },
                selected = selected,
                onClick = {
                    if (!selected) {
                        navigateToTopLevelDestination(navController, destination)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = Primary,
                    unselectedTextColor = PrimaryDark,
                    indicatorColor = Color.Transparent // 선택시 배경 제거
                ),
                interactionSource = NoRippleInteractionSource,
                modifier = Modifier.testTag(destination.name)
            )
        }
    }
}

private fun navigateToTopLevelDestination(navController: NavHostController, topLevelDestination: TopLevelDestination) {
    val topLevelNavOptions = navOptions {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }

    when (topLevelDestination) {
        TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
        TopLevelDestination.TAG_SEARCH -> navController.navigateToTagSearch(topLevelNavOptions)
        TopLevelDestination.STORAGE -> navController.navigateToStorage(topLevelNavOptions)
        TopLevelDestination.MY -> navController.navigateToMy(topLevelNavOptions)
    }
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false

private object NoRippleInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true
}
