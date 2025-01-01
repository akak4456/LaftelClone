package com.jo.feature.my

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun MyScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "My 헬로우 $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyScreen("Android")
}