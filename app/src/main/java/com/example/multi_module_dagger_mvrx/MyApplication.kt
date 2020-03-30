package com.example.multi_module_dagger_mvrx

import android.app.Application
import com.example.multi_module_dagger_mvrx.core.AppComponent
import com.example.multi_module_dagger_mvrx.core.DaggerAppComponent
import com.example.multi_module_dagger_mvrx.vmfactories.DaggerViewModelFactoriesComponent

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(
                DaggerViewModelFactoriesComponent.create().viewModelFactories()
            )
            .let { appComponent ->
                AppComponent.storeInstance(appComponent)
            }
    }
}