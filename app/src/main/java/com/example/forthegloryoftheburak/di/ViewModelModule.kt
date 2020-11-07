package com.example.forthegloryoftheburak.di

import com.example.forthegloryoftheburak.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}