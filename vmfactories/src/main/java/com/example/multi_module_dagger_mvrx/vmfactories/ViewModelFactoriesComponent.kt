package com.example.multi_module_dagger_mvrx.vmfactories

import com.example.multi_module_dagger_mvrx.base.FactoriesMap
import com.example.multi_module_dagger_mvrx.feature1.FeatureOneModule
import com.example.multi_module_dagger_mvrx.feature2.FeatureTwoModule
import dagger.Component

@Component(modules = [
    FeatureOneModule::class,
    FeatureTwoModule::class
])
interface ViewModelFactoriesComponent {

    fun viewModelFactories(): FactoriesMap

}