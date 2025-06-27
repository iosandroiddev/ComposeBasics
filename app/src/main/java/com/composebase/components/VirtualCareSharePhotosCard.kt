package com.composebase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.composebase.ui.theme.CameraIcon
import com.composebase.ui.theme.VCWhite
import com.composebase.ui.theme.appFonts

@Composable
fun VirtualCareSharePhotosCard(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = VCWhite,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(16 / 10f)
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                ),
            contentScale = ContentScale.Crop,
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            error = {

            }
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    top = 5.dp,
                    bottom = 5.dp,
                    end = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            BasicText(
                text = "Share photos anytime with doctor if you have questions.",
                style = TextStyle(
                    fontSize = 17.sp,
                    color = Color.Black.copy(alpha = 0.93f),
                    fontWeight = FontWeight.Medium,
                    fontFamily = appFonts,
                ),
                modifier = Modifier.weight(1f)
            )

            Spacer(
                modifier = Modifier.width(10.dp)
            )

            FloatingActionButton(
                icon = CameraIcon,
                onClick = {

                }
            )
        }
    }
}