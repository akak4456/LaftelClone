package com.jo.laftelclone.feature.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.skydoves.landscapist.glide.GlideImage

@Composable
internal fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        GlideImage(
            imageModel = R.drawable.bg_login,
            contentScale = ContentScale.Crop,
        )
    }
}