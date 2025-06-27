package com.composebase.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.composebase.R

val AppLogo: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_home_logo)

val CameraIcon: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_vc_camera)

val GalleryIcon: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_vc_photos)

val RightArrowIcon: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_right)

val InformationIcon: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_information)

val DropDownIcon: ImageVector
    @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_drop_down)