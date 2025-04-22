package com.jo.laftelclone.feature.login

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.jo.laftelclone.core.designsystem.component.PreloadGif
import com.skydoves.landscapist.glide.GlideImage

@Composable
internal fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        GlideImage(
            imageModel = PreloadGif.resource,
            contentScale = ContentScale.Crop
        )
    }
}