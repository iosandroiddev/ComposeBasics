package com.composebase.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebase.R
import com.composebase.ui.theme.ComposeBaseTheme

@Composable
fun HeaderParallax(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .layoutId("collapsing_box")
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF015990), Color(0xFF209AD6)
                    )
                ), shape = RoundedCornerShape(
                    bottomEnd = 50.dp, bottomStart = 50.dp
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Invisalign \n" + "Virtual Care",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.invisalign_logo_symbol),
                    contentDescription = "Golden star 1",
                    tint = Color.White
                )

            }
            Spacer(modifier = Modifier.height(17.dp))
            Text(
                text = "To do's",
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            )

        }
    }
}


@Preview
@Composable
private fun HeaderParallaxPreview() {
    ComposeBaseTheme {
        HeaderParallax()
    }

}
