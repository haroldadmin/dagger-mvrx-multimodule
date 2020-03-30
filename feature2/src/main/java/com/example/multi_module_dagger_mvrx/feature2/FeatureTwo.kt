package com.example.multi_module_dagger_mvrx.feature2

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

class FeatureTwoGreeter @Inject constructor() {
    fun greet(name: String): String {
        return "hello $name from feature 1!"
    }
}

data class FeatureTwoState(
    val greeting: String = "Loading..."
): MvRxState

class FeatureTwoViewModel @AssistedInject constructor(
    @Assisted state: FeatureTwoState,
    private val greeter: FeatureTwoGreeter
): BaseViewModel<FeatureTwoState>(state) {

    fun greet(name: String) = setState {
        copy(greeting = greeter.greet(name))
    }

    @AssistedInject.Factory
    interface Factory :
        AssistedViewModelFactory<FeatureTwoViewModel, FeatureTwoState> {
        override fun create(state: FeatureTwoState): FeatureTwoViewModel
    }

    companion object : DaggerMvRxViewModelFactory<FeatureTwoViewModel, FeatureTwoState>(
        FeatureTwoViewModel::class.java
    )
}

@Module(includes = [AssistedInject_FeatureTwoModule::class])
@AssistedModule
interface FeatureTwoModule {

    @Binds
    @IntoMap
    @ViewModelKey(FeatureTwoViewModel::class)
    fun featureTwoViewModelFactory(factory: FeatureTwoViewModel.Factory): AssistedViewModelFactory<*, *>

}