package com.composebase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.composebase.ui.theme.CameraIcon
import com.composebase.ui.theme.ComposeBaseTheme
import com.composebase.ui.theme.VCFloatingBg
import com.composebase.ui.theme.VCWhite
import com.composebase.vcHomeSectionColors

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
    contentDescription: String? = null,
    iconSize: Dp = 25.dp
) {
    Box(
        modifier = Modifier
            .size(75.dp)
            .clip(CircleShape)
            .background(VCFloatingBg)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = vcHomeSectionColors
                    )
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = VCWhite,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}


@Preview
@Composable
private fun FloatingActionButtonPreview() {
    ComposeBaseTheme  {
        FloatingActionButton(
            modifier = Modifier,
            iconSize = 32.dp,
            icon = CameraIcon,
            onClick = {},
        )
    }
}