package com.jo.feature.box

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun BoxScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Box 헬로우 $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun BoxScreenPreview() {
    BoxScreen("Android")
}