@file:OptIn(ExperimentalMaterial3Api::class)

package com.composebase

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val lazyListState = rememberLazyListState()
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                TopBar(lazyListState = lazyListState)
                MainContent(lazyListState = lazyListState)
            }
        }
    )
}

@Composable
fun TopBar(lazyListState: LazyListState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId("collapsing_box")
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF015990), Color(0xFF209AD6)
                    )
                ), shape = RoundedCornerShape(
                    bottomEnd = 100.dp, bottomStart = 100.dp
                )
            )
            .animateContentSize(animationSpec = tween(durationMillis = 500))
            .height(height = if (lazyListState.isScrolled) MIN_TOP_BAR_HEIGHT else MAX_TOP_BAR_HEIGHT),
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
                    text = "Invisalign \n"
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


//    TopAppBar(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = MaterialTheme.colorScheme.primary)
//            .animateContentSize(animationSpec = tween(durationMillis = 300))
//            .height(height = if (lazyListState.isScrolled) MIN_TOP_BAR_HEIGHT else MAX_TOP_BAR_HEIGHT),
//        contentPadding = PaddingValues(start = 16.dp),
//    ) {
//        Text(
//            text = "Title",
//            style = TextStyle(
//                fontSize = MaterialTheme.typography.h6.fontSize,
//                color = MaterialTheme.colors.surface
//            )
//        )
//    }
}

@Composable
fun MainContent(lazyListState: LazyListState) {
    val numbers = remember { List(size = 25) { it } }
    val padding by animateDpAsState(
        targetValue = if (lazyListState.isScrolled) 0.dp else PADDING_TOP_BAR_HEIGHT,
        animationSpec = tween(durationMillis = 500)
    )
    LazyColumn(
        modifier = Modifier
            .padding(top = padding)
            .padding(horizontal = 20.dp),
        state = lazyListState
    ) {
        items(
            items = numbers,
            key = { it }
        ) {
            NumberHolder(number = it)
            Spacer(
                modifier = Modifier
                    .height(12.dp)
                    .background(color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun NumberHolder(number: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = number.toString(),
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

val MIN_TOP_BAR_HEIGHT = 96.dp
val MAX_TOP_BAR_HEIGHT = 280.dp
val PADDING_TOP_BAR_HEIGHT = 180.dp

val VC_MIN_TOP_BAR_HEIGHT = 96.dp
val VC_MAX_TOP_BAR_HEIGHT = 238.dp
val VC_PADDING_TOP_BAR_HEIGHT = 182.dp

val vcHomeSectionColors = listOf(Color(0xFF015990), Color(0xFF209AD6))

val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0