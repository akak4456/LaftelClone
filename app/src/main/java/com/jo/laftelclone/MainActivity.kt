package com.jo.laftelclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jo.laftelclone.core.designsystem.theme.LaftelCloneTheme
import com.jo.laftelclone.ui.LaftelCloneApp
import com.jo.laftelclone.ui.rememberLaftelCloneAppState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberLaftelCloneAppState(

            )
            LaftelCloneTheme {
                LaftelCloneApp(appState)
            }
        }
    }
}