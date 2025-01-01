package com.jo.laftelclone.navigation

import androidx.annotation.StringRes
import com.jo.feature.box.navigation.BoxRoute
import com.jo.feature.home.navigation.HomeRoute
import com.jo.feature.my.navigation.MyRoute
import com.jo.feature.tagsearch.navigation.TagSearchRoute

enum class TopLevelDestination(
    @StringRes val iconTextId: Int,
    val route: String
) {
    HOME(
        iconTextId = com.jo.feature.home.R.string.home_title,
        HomeRoute
    ),
    BOX(
        iconTextId = com.jo.feature.box.R.string.box_title,
        BoxRoute
    ),
    TAG_SEARCH(
      iconTextId = com.jo.feature.tagsearch.R.string.tagsearch_title,
        TagSearchRoute
    ),
    MY(
        iconTextId = com.jo.feature.my.R.string.my_title,
        MyRoute
    )
}