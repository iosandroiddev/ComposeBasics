package com.composebase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebase.ui.theme.ComposeBaseTheme
import com.composebase.ui.theme.GalleryIcon
import com.composebase.ui.theme.InformationIcon
import com.composebase.ui.theme.RightArrowIcon
import com.composebase.ui.theme.VCBlack93
import com.composebase.ui.theme.VCBoxIcon
import com.composebase.ui.theme.VCGrey
import com.composebase.ui.theme.VCWhite
import com.composebase.ui.theme.appFonts

@Composable
fun VirtualCareTreatmentPhotosAboutSection(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = VCWhite,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(start = 20.dp, end = 20.dp)
    ) {

        VirtualCareAboutSectionItem(
            title = "Virtual treatment photos",
            onClick = { },
            leftIcon = GalleryIcon,
            rightIcon = RightArrowIcon
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(VCGrey)
        )

        VirtualCareAboutSectionItem(
            title = "About",
            onClick = { },
            leftIcon = InformationIcon,
            rightIcon = RightArrowIcon
        )

    }
}


@Composable
private fun VirtualCareAboutSectionItem(
    modifier: Modifier = Modifier,
    title: String,
    leftIcon: ImageVector,
    rightIcon: ImageVector,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoxIcon(
            icon = leftIcon
        )

        BasicText(
            text = title,
            style = TextStyle(
                fontSize = 17.sp,
                color = VCBlack93,
                fontFamily = appFonts,
            ),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp)
        )
        Icon(
            imageVector = rightIcon,
            tint = VCBoxIcon,
            contentDescription = null
        )
    }

}

@Preview
@Composable
fun VirtualCareTreatmentPhotosAboutSectionPreview() {
    ComposeBaseTheme {
        VirtualCareTreatmentPhotosAboutSection()
    }
}