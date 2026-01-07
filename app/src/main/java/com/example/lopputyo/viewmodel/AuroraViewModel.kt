package com.example.lopputyo.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lopputyo.model.AuroraApi
import com.example.lopputyo.model.LatestValues
import kotlinx.coroutines.launch

sealed interface UiState {
    data class Success(val latestValues: LatestValues): UiState
    object Error: UiState
    object Loading: UiState
}

class AuroraViewModel: ViewModel() {
    var uiState: UiState by mutableStateOf<UiState>(UiState.Loading)
    val latest = mutableListOf<LatestValues>()
    var location by mutableStateOf("")

    init {
        getLatestValues()
    }

    private fun getLatestValues() {
        viewModelScope.launch {
            var auroraApi: AuroraApi? = null
            try {
                auroraApi = AuroraApi!!.getInstance()
                uiState = UiState.Success(auroraApi.getLatest())
                latest.clear()
                latest.add(auroraApi.getLatest())
            } catch (e: Exception) {
                Log.d("AURORA VIEWMODEL", e.message.toString())
                uiState = UiState.Error
            }
        }
    }
}