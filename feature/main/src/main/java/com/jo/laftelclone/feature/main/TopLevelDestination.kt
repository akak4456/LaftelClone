package com.jo.laftelclone.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.jo.laftelclone.feature.home.navigation.HomeRoute
import com.jo.laftelclone.feature.my.navigation.MyRoute
import com.jo.laftelclone.feature.storage.navigation.StorageRoute
import com.jo.laftelclone.feature.tagsearch.navigation.TagSearchRoute
import kotlin.reflect.KClass

/**
 * main bottom navigation 에 대한 top level destination 정의다
 * @param selectedIcon 선택되었을 때 icon
 * @param unselectedIcon 선택되지 않았을 때 icon
 * @param titleTextId 표시될 title string
 * @param route navigating 할 때 필요한 route
 * @param isMy My 탭인지 아닌지 여부
 */
enum class TopLevelDestination(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>,
    val isMy: Boolean = false
) {
    HOME(
        selectedIcon = R.drawable.ic_home_on,
        unselectedIcon = R.drawable.ic_home_off,
        titleTextId = R.string.main_home_title,
        route = HomeRoute::class
    ),
    TAG_SEARCH(
        selectedIcon = R.drawable.ic_tagsearch_on,
        unselectedIcon = R.drawable.ic_tagsearch_off,
        titleTextId = R.string.main_tagsearch_title,
        route = TagSearchRoute::class
    ),
    STORAGE(
        selectedIcon = R.drawable.ic_storage_on,
        unselectedIcon = R.drawable.ic_storage_off,
        titleTextId = R.string.main_storage_title,
        route = StorageRoute::class
    ),
    MY(
        selectedIcon = 0,
        unselectedIcon = 0,
        titleTextId = 0,
        route = MyRoute::class,
        isMy = true
    )
}