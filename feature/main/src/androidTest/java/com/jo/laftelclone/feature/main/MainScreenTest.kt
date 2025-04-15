package com.jo.laftelclone.feature.main

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jo.laftelclone.core.designsystem.theme.LaftelCloneTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            LaftelCloneTheme {
                MainScreen()
            }
        }
    }

    @Test
    fun bottomNavigationItems_areDisplayed() {
        // Home 탭 텍스트가 보여야 함
        composeTestRule.onNodeWithTag("HOME").assertIsDisplayed()
        composeTestRule.onNodeWithTag("TAG_SEARCH").assertIsDisplayed()
        composeTestRule.onNodeWithTag("STORAGE").assertIsDisplayed()
        composeTestRule.onNodeWithTag("MY").assertIsDisplayed()
    }

    @Test
    fun tappingOnBottomNavigationItem_navigatesToCorrectScreen() {
        // 초기 화면은 "홈"이어야 함
        composeTestRule.onNodeWithTag("HOME").assertIsDisplayed()

        // "보관함" 탭 클릭
        composeTestRule.onNodeWithTag("STORAGE").performClick()

        // 이 예시에서는 실제 보관함 화면의 특정 텍스트나 컴포넌트를 확인하면 좋습니다
        // 예: composeTestRule.onNodeWithText("내 찜 목록").assertIsDisplayed()
    }
}