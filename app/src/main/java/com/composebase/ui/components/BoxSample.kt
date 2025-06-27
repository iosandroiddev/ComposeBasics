package com.composebase.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composebase.components.VirtualCareAlignerSettingItem
import com.composebase.components.VirtualCareSharePhotosCard
import com.composebase.components.VirtualCareTreatmentPhotosAboutSection
import com.composebase.ui.theme.ComposeBaseTheme
import com.composebase.ui.theme.GalleryIcon
import com.composebase.ui.theme.VCAlignerBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BoxSample() {

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())


    val listState = rememberLazyListState()


    Scaffold(
        topBar = {
            HeaderParallax()
        }
    )
    { padding ->
        LazyColumn(
            Modifier.padding(
                top = padding.calculateTopPadding(),
                start = 20.dp, end = 20.dp
            ),
            state = listState
//                contentAlignment = Alignment.TopCenter
        ) {

            item {
                VirtualCareSharePhotosCard(
                    imageUrl = "https://www.smileviewdental.com/assets/images/slideshow/slide1.jpg"
                )
            }

//                val childHeight = this.maxHeight
//
//                val scaleY = parentHeight.value / childHeight.value
            item {
                VirtualCareAlignerSettingItem(
                    onClick = {

                    },
                    icon = GalleryIcon,
                    boxBackgroundColor = VCAlignerBox
                )
            }

            item {
                VirtualCareTreatmentPhotosAboutSection()

            }

            item {
                VirtualCareTreatmentPhotosAboutSection()

            }

            item {
                VirtualCareTreatmentPhotosAboutSection()
            }

            item {
                VirtualCareTreatmentPhotosAboutSection()
                VirtualCareTreatmentPhotosAboutSection()
                VirtualCareTreatmentPhotosAboutSection()
                VirtualCareTreatmentPhotosAboutSection()
            }

        }
    }
}

@Preview
@Composable
private fun BoxSamplePreview() {
    ComposeBaseTheme {
        BoxSample()
    }
}