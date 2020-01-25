package com.skynoff.whosmyboo

import android.app.Application
import com.skynoff.whosmyboo.di.firebaseModule
import com.skynoff.whosmyboo.di.viewModelmodule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
         startKoin {
             androidContext(this@MyApplication)
             modules(listOf(
                 firebaseModule,
                 viewModelmodule
             ))
         }
    }
}