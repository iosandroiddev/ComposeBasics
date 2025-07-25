package com.composebase.ui.components

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.composebase.R
import com.composebase.components.Demo_ExposedDropdownMenuBox
import com.composebase.ui.theme.ComposeBaseTheme
import com.composebase.ui.theme.VCBlack93
import com.composebase.vcHomeSectionColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBaseTheme {
                Surface {
//                    CollapsingToolbarParallaxEffect(
//                        Modifier
//                            .fillMaxSize()
//                            .background(MaterialTheme.colorScheme.surface)
//                    )
                    Demo_ExposedDropdownMenuBox()
                }
            }
        }
    }
}

private val headerHeight = 250.dp
private val toolbarHeight = 56.dp

private val paddingMedium = 16.dp

private val titlePaddingStart = 16.dp
private val titlePaddingEnd = 72.dp

private const val titleFontScaleStart = 1f
private const val titleFontScaleEnd = 0.66f

@Composable
fun CollapsingToolbarParallaxEffect(modifier: Modifier = Modifier) {
    val scroll: ScrollState = rememberScrollState(0)

    val headerHeightPx = with(LocalDensity.current) { headerHeight.toPx() }
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.toPx() }

    Box(modifier = modifier) {
        Header(
            scroll = scroll,
            headerHeightPx = headerHeightPx,
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)
        )
        Body(
            scroll = scroll,
            modifier = Modifier.fillMaxSize()
        )
        Toolbar(
            scroll = scroll,
            headerHeightPx = headerHeightPx,
            toolbarHeightPx = toolbarHeightPx
        )
        Title(scroll = scroll)
    }
}

@Composable
private fun Header(
    scroll: ScrollState,
    headerHeightPx: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .graphicsLayer {
                translationY = -scroll.value.toFloat() / 2f // Parallax effect
                alpha = (-1f / headerHeightPx) * scroll.value + 1
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_studio),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, VCBlack93),
                        startY = 3 * headerHeightPx / 4 // Gradient applied to wrap the title only
                    )
                )
        )
    }
}

@Composable
private fun Body(scroll: ScrollState, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.verticalScroll(scroll)
    ) {
        Spacer(Modifier.height(headerHeight))
        repeat(5) {
            Text(
                text = "sdklfjdsfjsdlkfdslakf asdlfksdjflsdfn asdlfkjsdlfjsadlfjsndlsfjdlsf jlsdjfladsjf sdklfjdsfjsdlkfdslakf asdlfksdjflsdfn asdlfkjsdlfjsadlfjsndlsfjdlsf jlsdjfladsjf sdklfjdsfjsdlkfdslakf asdlfksdjflsdfn asdlfkjsdlfjsadlfjsndlsfjdlsf jlsdjfladsjf sdklfjdsfjsdlkfdslakf asdlfksdjflsdfn asdlfkjsdlfjsadlfjsndlsfjdlsf jlsdjfladsjf sdklfjdsfjsdlkfdslakf asdlfksdjflsdfn asdlfkjsdlfjsadlfjsndlsfjdlsf jlsdjfladsjf v v sdklfjdsfjsdlkfdslakf asdlfksdjflsdfn asdlfkjsdlfjsadlfjsndlsfjdlsf jlsdjfladsjf",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    scroll: ScrollState,
    headerHeightPx: Float,
    toolbarHeightPx: Float,
    modifier: Modifier = Modifier
) {
    val toolbarBottom by remember {
        mutableStateOf(headerHeightPx - toolbarHeightPx)
    }

    val showToolbar by remember {
        derivedStateOf {
            scroll.value >= toolbarBottom
        }
    }

    AnimatedVisibility(
        modifier = modifier,
        visible = showToolbar,
        enter = fadeIn(animationSpec = tween(300)),
        exit = fadeOut(animationSpec = tween(300))
    ) {
        TopAppBar(
            modifier = Modifier.background(
                brush = Brush.horizontalGradient(
                    vcHomeSectionColors
                )
            ),
            navigationIcon = {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(16.dp)
                        .size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            title = {},
//            colo = Color.Transparent,
//            elevation = 0.dp
        )
    }
}

@Composable
private fun Title(
    scroll: ScrollState,
    modifier: Modifier = Modifier
) {
    var titleHeightPx by remember { mutableStateOf(0f) }
    var titleWidthPx by remember { mutableStateOf(0f) }

    Text(
        text = "New York",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = modifier
            .graphicsLayer {
                val collapseRange: Float = (headerHeight.toPx() - toolbarHeight.toPx())
                val collapseFraction: Float = (scroll.value / collapseRange).coerceIn(0f, 1f)

                val scaleXY = lerp(
                    titleFontScaleStart.dp,
                    titleFontScaleEnd.dp,
                    collapseFraction
                )

                val titleExtraStartPadding = titleWidthPx.toDp() * (1 - scaleXY.value) / 2f

                val titleYFirstInterpolatedPoint = lerp(
                    headerHeight - titleHeightPx.toDp() - paddingMedium,
                    headerHeight / 2,
                    collapseFraction
                )

                val titleXFirstInterpolatedPoint = lerp(
                    titlePaddingStart,
                    (titlePaddingEnd - titleExtraStartPadding) * 5 / 4,
                    collapseFraction
                )

                val titleYSecondInterpolatedPoint = lerp(
                    headerHeight / 2,
                    toolbarHeight / 2 - titleHeightPx.toDp() / 2,
                    collapseFraction
                )

                val titleXSecondInterpolatedPoint = lerp(
                    (titlePaddingEnd - titleExtraStartPadding) * 5 / 4,
                    titlePaddingEnd - titleExtraStartPadding,
                    collapseFraction
                )

                val titleY = lerp(
                    titleYFirstInterpolatedPoint,
                    titleYSecondInterpolatedPoint,
                    collapseFraction
                )

                val titleX = lerp(
                    titleXFirstInterpolatedPoint,
                    titleXSecondInterpolatedPoint,
                    collapseFraction
                )

                translationY = titleY.toPx()
                translationX = titleX.toPx()
                scaleX = scaleXY.value
                scaleY = scaleXY.value
            }
            .onGloballyPositioned {
                titleHeightPx = it.size.height.toFloat()
                titleWidthPx = it.size.width.toFloat()
            }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    ComposeBaseTheme  {
        CollapsingToolbarParallaxEffect(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.surface
                )
        )
    }
}