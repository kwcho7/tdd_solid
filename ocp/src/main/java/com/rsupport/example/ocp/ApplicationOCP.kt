package com.rsupport.example.ocp

import android.app.Application
import androidx.annotation.Keep
import com.rsupport.example.ocp.di.financialModule
import org.koin.core.context.startKoin

@Keep
class ApplicationOCP: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                financialModule
            )
        }
    }
}