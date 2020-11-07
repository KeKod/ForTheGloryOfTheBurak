package com.example.forthegloryoftheburak

import android.app.Application
import com.example.forthegloryoftheburak.di.networkModule
import com.example.forthegloryoftheburak.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AwesomeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@AwesomeApp)
            modules(networkModule)
            modules(viewModelModule)
        }
    }
}