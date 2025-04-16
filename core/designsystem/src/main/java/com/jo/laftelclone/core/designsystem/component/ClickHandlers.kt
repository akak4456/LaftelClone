package com.jo.laftelclone.core.designsystem.component

import androidx.compose.runtime.compositionLocalOf

data class ClickHandlers(
    val onNavigateToMain: () -> Unit,
    val onNavigateToLogin: () -> Unit
)
val LocalClickHandlers = compositionLocalOf<ClickHandlers> {
    error("No ClickHandlers provided")
}