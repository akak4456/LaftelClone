package com.jo.laftelclone.feature.storage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.jo.laftelclone.feature.storage.StorageScreen
import kotlinx.serialization.Serializable

@Serializable
data object StorageRoute

fun NavController.navigateToStorage(navOptions: NavOptions? = null) = navigate(route = StorageRoute, navOptions)

fun NavGraphBuilder.storageSection() {
    composable<StorageRoute> {
        StorageScreen()
    }
}