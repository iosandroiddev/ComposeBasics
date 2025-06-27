package com.composebase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.composebase.ui.theme.ComposeBaseTheme
import kotlin.random.Random

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit,
) {

    Box(
        modifier = modifier
            .background(color = Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )

}


@Preview
@Composable
fun ColorBoxPreview() {
    ComposeBaseTheme {
        ColorBox(modifier = Modifier, updateColor = {})
    }
}