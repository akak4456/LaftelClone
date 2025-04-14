package com.jo.laftelclone.feature.splash

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.jo.laftelclone.core.designsystem.theme.LaftelCloneTheme
import org.junit.Rule
import org.junit.Test

class SplashScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun logoImage_exist() {
        composeTestRule.setContent {
            LaftelCloneTheme {
                SplashScreen()
            }
        }

        composeTestRule
            .onNodeWithTag("logoImage")
            .assertIsDisplayed()
            .assertExists()
    }
}