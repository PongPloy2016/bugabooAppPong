package com.example.bugabooapppong.ui.viewmodel

import com.example.bugabooapppong.data.model.MainResponse

sealed class HomeViewState {
    data object Loading: HomeViewState()
    data class Success(val mainResponse: MainResponse): HomeViewState()
    data class Error(val message: String): HomeViewState()
}