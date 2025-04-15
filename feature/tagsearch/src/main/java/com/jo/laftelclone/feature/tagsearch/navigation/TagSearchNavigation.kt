package com.jo.laftelclone.feature.tagsearch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.laftelclone.feature.tagsearch.TagSearch
import kotlinx.serialization.Serializable

@Serializable
data object TagSearchRoute

fun NavController.navigateToTagSearch(navOptions: NavOptions? = null) = navigate(route = TagSearchRoute, navOptions)

fun NavGraphBuilder.tagSearchSection() {
    composable<TagSearchRoute> {
        TagSearch()
    }
}