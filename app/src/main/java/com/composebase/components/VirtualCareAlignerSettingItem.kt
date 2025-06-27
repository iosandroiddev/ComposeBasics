package com.composebase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebase.ui.theme.ComposeBaseTheme
import com.composebase.ui.theme.GalleryIcon
import com.composebase.ui.theme.VCBlack63
import com.composebase.ui.theme.VCBlack93
import com.composebase.ui.theme.VCBoxIcon
import com.composebase.ui.theme.VCWhite
import com.composebase.ui.theme.appFonts

@Composable
fun VirtualCareAlignerSettingItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    boxBackgroundColor: Color,
    icon: ImageVector,
    contentDescription: String? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(
                color = VCWhite,
                shape = RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(94.dp)
                .background(
                    color = boxBackgroundColor,
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        bottomStart = 16.dp
                    )
                )
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = VCBoxIcon,
                modifier = Modifier.wrapContentSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.Center
        ) {

            BasicText(
                text = "Aligner#18",
                style = TextStyle(
                    color = VCBlack93,
                    fontSize = 17.sp,
                    fontFamily = appFonts,
                    fontWeight = FontWeight.Normal
                ),
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            BasicText(
                text = "Take progress photos today",
                style = TextStyle(
                    color = VCBlack63,
                    fontSize = 14.sp,
                    fontFamily = appFonts,
                    fontWeight = FontWeight.Normal
                ),
            )
        }
    }

}

@Preview
@Composable
private fun VirtualCareAlignerSettingItemPreview() {
    ComposeBaseTheme {
        VirtualCareAlignerSettingItem(
            onClick = {},
            boxBackgroundColor = Color.Green,
            icon = GalleryIcon
        )
    }
}