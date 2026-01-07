package com.example.lopputyo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.toSize
import com.example.lopputyo.R

@Composable
fun LocationsDropdown(onClick: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val items = listOf(
        "Kevo", "Kilpisjärvi", "Ivalo", "Muonio", "Pello",
        "Ranua", "Oulujärvi", "Mekrijärvi", "Hankasalmi",
        "Nurmijärvi", "Tartu"
    )
    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    Column {
        OutlinedTextField(
            readOnly = true,
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier.fillMaxWidth().onGloballyPositioned { coordinates ->
                textFieldSize = coordinates.size.toSize()
            },
            label = {Text(text = stringResource(R.string.select_location))},
            trailingIcon = {
                Icon(icon, stringResource(R.string.select_location_icon_description),
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onClick(item)
                        selectedText = item
                        expanded = false
                    }
                )
            }
        }
    }
}