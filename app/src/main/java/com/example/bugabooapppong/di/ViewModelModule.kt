package com.example.bugabooapppong.di

import com.example.bugabooapppong.ui.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { GalleryViewModel() }
    viewModel { HomeViewModel(get()) }
//    viewModel { SlideshowViewModel() }
}

