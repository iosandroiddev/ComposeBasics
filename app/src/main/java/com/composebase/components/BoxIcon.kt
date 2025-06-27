package com.composebase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.composebase.ui.theme.ComposeBaseTheme
import com.composebase.ui.theme.InformationIcon
import com.composebase.ui.theme.VCBoxIcon
import com.composebase.ui.theme.VCBoxIconBg

@Composable
fun BoxIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String? = null,
    iconSize: Dp = 20.dp,
) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(VCBoxIconBg)
            .padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = VCBoxIcon,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Preview
@Composable
private fun BoxIconPreview() {
    ComposeBaseTheme  {
        BoxIcon(
            icon = InformationIcon,
        )
    }
}