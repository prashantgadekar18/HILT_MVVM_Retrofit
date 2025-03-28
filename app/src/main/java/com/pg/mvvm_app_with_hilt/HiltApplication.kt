package com.pg.mvvm_app_with_hilt

import android.app.Application
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}