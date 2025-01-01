package com.jo.feature.tagsearch

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun TagSearchScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "TagSearch 헬로우 $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TagSearchScreenPreview() {
    TagSearchScreen("Android")
}