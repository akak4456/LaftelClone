package com.jo.laftelclone.feature.splash

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.jo.laftelclone.core.designsystem.theme.LaftelCloneTheme
import com.jo.laftelclone.core.screenshot_testing.captureMultiDevice
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.LooperMode
import dagger.hilt.android.testing.HiltTestApplication

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class, sdk = [26])
@LooperMode(LooperMode.Mode.PAUSED)
class SplashScreenScreenshotTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun splashScreenPopulated() {
        composeTestRule.captureMultiDevice("SplashScreenPopulated") {
            LaftelCloneTheme {
                SplashScreen()
            }
        }
    }
}