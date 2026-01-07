package com.example.lopputyo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lopputyo.R
import com.example.lopputyo.ui.components.MyHeading
import com.example.lopputyo.ui.components.ScreenTopBar

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar(stringResource(R.string.info_top_bar), navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(paddingValues = innerPadding).padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MyHeading(stringResource(R.string.info_header))
            Text(
                text = stringResource(R.string.info_text)
            )
            Text(
                text = stringResource(R.string.info_license)
            )
        }
    }
}