package com.example.multi_module_dagger_mvrx.feature1

import com.airbnb.mvrx.MvRxState
import com.example.multi_module_dagger_mvrx.base.AssistedViewModelFactory
import com.example.multi_module_dagger_mvrx.base.BaseViewModel
import com.example.multi_module_dagger_mvrx.daggerutils.DaggerMvRxViewModelFactory
import com.example.multi_module_dagger_mvrx.daggerutils.ViewModelKey
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject

class FeatureOneGreeter @Inject constructor() {
    fun greet(name: String): String {
        return "hello $name from feature 1!"
    }
}

data class FeatureOneState(
    val greeting: String = "Loading..."
): MvRxState

class FeatureOneViewModel @AssistedInject constructor(
    @Assisted state: FeatureOneState,
    private val greeter: FeatureOneGreeter
): BaseViewModel<FeatureOneState>(state) {

    fun greet(name: String) = setState {
        copy(greeting = greeter.greet(name))
    }

    @AssistedInject.Factory
    interface Factory :
        AssistedViewModelFactory<FeatureOneViewModel, FeatureOneState> {
        override fun create(state: FeatureOneState): FeatureOneViewModel
    }

    companion object : DaggerMvRxViewModelFactory<FeatureOneViewModel, FeatureOneState>(
        FeatureOneViewModel::class.java
    )
}

@AssistedModule
@Module(includes = [AssistedInject_FeatureOneModule::class])
interface FeatureOneModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeatureOneViewModel::class)
    fun featureOneViewModelFactory(factory: FeatureOneViewModel.Factory): AssistedViewModelFactory<*, *>

}