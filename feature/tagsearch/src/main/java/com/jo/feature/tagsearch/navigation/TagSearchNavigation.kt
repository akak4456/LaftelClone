package com.jo.feature.tagsearch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.feature.tagsearch.TagSearchScreen

const val TagSearchRoute = "TagSearchRoute"

fun NavController.navigateToTagSearch(navOptions: NavOptions) = navigate(route = TagSearchRoute, navOptions)

fun NavGraphBuilder.tagSearchScreen () {
    composable(TagSearchRoute) {
        TagSearchScreen("Android")
    }
}