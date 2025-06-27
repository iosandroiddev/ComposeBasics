package com.composebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.composebase.components.Demo_ExposedDropdownMenuBox
import com.composebase.ui.theme.ComposeBaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MainActivity : ComponentActivity() {

    private val fontFamily = FontFamily(
        Font(R.font.lexend_regular, FontWeight.Normal),
        Font(R.font.lexend_light, FontWeight.Light),
        Font(R.font.lexend_bold, FontWeight.Bold),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setNavgraph()
        }
    }
}

@Composable
private fun setNavgraph() {
    ComposeBaseTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                Demo_ExposedDropdownMenuBox()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBaseTheme {


    }
}