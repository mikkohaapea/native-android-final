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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lopputyo.R
import com.example.lopputyo.ui.components.LocationsDropdown
import com.example.lopputyo.ui.components.MainDataDisplay
import com.example.lopputyo.ui.components.MainTopBar
import com.example.lopputyo.ui.components.MyHeading
import com.example.lopputyo.viewmodel.AuroraViewModel
import com.example.lopputyo.viewmodel.UiState

@Composable
fun MainScreen(
    navController: NavController,
    auroraViewModel: AuroraViewModel = viewModel()
) {
    Scaffold(
        topBar = { MainTopBar(title = stringResource(R.string.main_top_bar), navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            when (auroraViewModel.uiState) {
                is UiState.Loading -> { LoadingScreen() }
                is UiState.Error -> { ErrorScreen() }
                is UiState.Success -> {
                    MyHeading(title = stringResource(R.string.main_header))
                    LocationsDropdown { auroraViewModel.location = it }
                    MainDataDisplay(data = auroraViewModel.latest, location = auroraViewModel.location)
                }
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Text(stringResource(R.string.loading))
}

@Composable
fun ErrorScreen() {
    Text(stringResource(R.string.error))
}