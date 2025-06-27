package com.composebase.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.composebase.R
import com.composebase.VC_MAX_TOP_BAR_HEIGHT
import com.composebase.VC_MIN_TOP_BAR_HEIGHT
import com.composebase.VC_PADDING_TOP_BAR_HEIGHT
import com.composebase.isScrolled
import com.composebase.ui.theme.AppLogo
import com.composebase.ui.theme.GalleryIcon
import com.composebase.ui.theme.VCAlignerBox
import com.composebase.ui.theme.VCGrey
import com.composebase.vcHomeSectionColors

@Composable
fun VirtualCareHomeScreen(
) {
    val lazyScrollState = rememberLazyListState()
    Scaffold(
        modifier = Modifier
            .background(color = VCGrey),
        content = { paddingValues ->
            VirtualCareHomeScreenContent(
                lazyScrollState = lazyScrollState,
                paddingValues = paddingValues,
            )
        }
    )
}

@OptIn(ExperimentalMotionApi::class, ExperimentalFoundationApi::class)
@Composable
private fun VirtualCareHomeScreenContent(
    lazyScrollState: LazyListState,
    paddingValues: PaddingValues,
) {

    val padding by animateDpAsState(
        targetValue = if (lazyScrollState.isScrolled) 0.dp else VC_PADDING_TOP_BAR_HEIGHT,
        animationSpec = tween(durationMillis = 500)
    )

    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.virtual_care_motion_scene).readBytes()
            .decodeToString()
    }

    val progress by animateFloatAsState(
        targetValue = if (lazyScrollState.isScrolled) 1f else 0f,
        animationSpec = tween(500)
    )
    val motionHeight by animateDpAsState(
        targetValue = if (lazyScrollState.isScrolled) VC_MIN_TOP_BAR_HEIGHT else VC_MAX_TOP_BAR_HEIGHT,
        animationSpec = tween(500)
    )

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(VCGrey)
            .padding(paddingValues = paddingValues)
            .padding(bottom = 20.dp)

    ) {

        val boxProperties = motionProperties(id = "box")
        val roundedShape = RoundedCornerShape(
            bottomStart = boxProperties.value.int("roundValue").dp,
            bottomEnd = boxProperties.value.int("roundValue").dp
        )

        Box(
            modifier = Modifier
                .layoutId("box")
                .clip(roundedShape)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = vcHomeSectionColors,
                    )
                )
                .height(motionHeight)
        )

        Image(
            imageVector = AppLogo,
            contentDescription = null,
            modifier = Modifier.layoutId("logo")
        )

        BasicText(
            modifier = Modifier
                .layoutId("title")
                .wrapContentWidth(unbounded = true)
                .wrapContentHeight(),
            text = "Invisalign\n" + "Virtual Care",
            style = TextStyle(
                fontSize = if (lazyScrollState.isScrolled) 20.sp else 26.sp,
                fontWeight = if (lazyScrollState.isScrolled) FontWeight.Normal else FontWeight.Bold ,
                color = Color.White,
            ),
        )

        LazyColumn(
            modifier = Modifier
                .layoutId("data_content")
                .fillMaxSize()
                .padding(top = padding)
                .padding(horizontal = 20.dp)
                .padding(bottom = 20.dp),
            state = lazyScrollState
        ) {
            item {
                VirtualCareSharePhotosCard(
                    imageUrl = "https://www.smileviewdental.com/assets/images/slideshow/slide1.jpg"
                )
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .fillMaxWidth()
                        .background(color = VCGrey),
                )
            }

            item {
                VirtualCareAlignerSettingItem(
                    onClick = {

                    },
                    icon = GalleryIcon,
                    boxBackgroundColor = VCAlignerBox
                )
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .fillMaxWidth()
                        .background(color = VCGrey),
                )
            }

            item {
                VirtualCareTreatmentPhotosAboutSection()
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .fillMaxWidth()
                        .background(color = VCGrey),
                )
            }

            item {
                VirtualCareTreatmentPhotosAboutSection()
            }

            item {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .fillMaxWidth()
                        .background(color = VCGrey),
                )
            }

            item {
                VirtualCareTreatmentPhotosAboutSection()
            }


            item {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .fillMaxWidth()
                        .background(color = VCGrey),
                )
            }

            item {
                VirtualCareTreatmentPhotosAboutSection()
            }
        }
    }
}


@Preview
@Composable
private fun VirtualCareHomeScreenPreview() {
    VirtualCareHomeScreen(

    )
}