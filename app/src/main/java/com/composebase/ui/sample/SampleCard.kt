package com.composebase.ui.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebase.R
import com.composebase.components.ImageCard
import com.composebase.ui.theme.ComposeBaseTheme

@Composable
fun JetPackComposeExample(
    fontFamily: FontFamily
) {
    Column {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = 50.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("J")
                }
                append("etpack ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = 50.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("C")
                }
                append("ompose")
            },
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Thin,
                textDecoration = TextDecoration.Underline,
            )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)
        ) {
            ImageCard(
                painter = painterResource(id = R.drawable.android_studio),
                contentDescription = "Image",
                title = "This is Dummy Card",
                fontFamily = fontFamily
            )
        }
    }
}

@Preview
@Composable
fun JetPackComposeExamplePreview() {
    ComposeBaseTheme {
        JetPackComposeExample(
            fontFamily = FontFamily(
                Font(R.font.lexend_regular, FontWeight.Normal),
                Font(R.font.lexend_light, FontWeight.Light),
                Font(R.font.lexend_bold, FontWeight.Bold),
            )
        )
    }
}