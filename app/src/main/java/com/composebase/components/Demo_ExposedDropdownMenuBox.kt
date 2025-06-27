@file:OptIn(ExperimentalMaterial3Api::class)

package com.composebase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.composebase.MainViewModel
import com.composebase.ui.theme.ComposeBaseTheme
import com.composebase.ui.theme.DropDownIcon

@Composable
fun Demo_ExposedDropdownMenuBox() {

    val mainViewModel : MainViewModel = hiltViewModel()

    mainViewModel.getBooks()
    
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth(),
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = DropDownIcon,
                        contentDescription = null,
                        modifier = Modifier.rotate(if (expanded) 180f else 0f)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color(0xfff4f4f4),
                    unfocusedBorderColor = Color(0xfff4f4f4),
                ),
                modifier = Modifier
                    .background(
                        color = Color(0xfff4f4f4),
                        shape = RoundedCornerShape(4.dp),
                    )
                    .menuAnchor()
                    .fillMaxWidth()
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(
                        color = Color(0xfff4f4f4)
                    )
                    .exposedDropdownSize()
            ) {
                coffeeDrinks.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = item, modifier = Modifier
                                    .background(
                                        color = Color(0xfff4f4f4)
                                    )
                                    .fillMaxWidth()
                            )
                        },
                        onClick = {
                            selectedText = item
                            expanded = false
                        },
                        modifier = Modifier
                            .background(
                                color = Color(0xfff4f4f4)
                            )
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Demo_ExposedDropdownMenuBoxPreview() {
    ComposeBaseTheme {
        Demo_ExposedDropdownMenuBox()
    }
}