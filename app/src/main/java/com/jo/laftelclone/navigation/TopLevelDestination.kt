package com.jo.laftelclone.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jo.feature.box.navigation.BoxRoute
import com.jo.feature.home.navigation.HomeRoute
import com.jo.feature.my.navigation.MyRoute
import com.jo.feature.tagsearch.navigation.TagSearchRoute
import com.jo.laftelclone.R

enum class TopLevelDestination(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val iconTextId: Int,
    val route: String,
    val isMyIcon: Boolean = false
) {
    HOME(
        selectedIcon = R.drawable.ic_home_on,
        unselectedIcon = R.drawable.ic_home_off,
        iconTextId = com.jo.feature.home.R.string.home_title,
        HomeRoute
    ),
    BOX(
        selectedIcon = R.drawable.ic_box_on,
        unselectedIcon = R.drawable.ic_box_off,
        iconTextId = com.jo.feature.box.R.string.box_title,
        BoxRoute
    ),
    TAG_SEARCH(
        selectedIcon = R.drawable.ic_tagsearch_on,
        unselectedIcon = R.drawable.ic_tagsearch_off,
      iconTextId = com.jo.feature.tagsearch.R.string.tagsearch_title,
        TagSearchRoute
    ),
    MY(
        selectedIcon = 0,
        unselectedIcon = 0,
        iconTextId = com.jo.feature.my.R.string.my_title,
        MyRoute,
        isMyIcon = true
    )
}