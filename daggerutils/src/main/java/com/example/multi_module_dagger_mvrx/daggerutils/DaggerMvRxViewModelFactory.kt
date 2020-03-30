package com.example.multi_module_dagger_mvrx.daggerutils

import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.multi_module_dagger_mvrx.base.AssistedViewModelFactory
import com.example.multi_module_dagger_mvrx.base.BaseViewModel
import com.example.multi_module_dagger_mvrx.core.AppComponent

abstract class DaggerMvRxViewModelFactory<VM : BaseViewModel<S>, S : MvRxState>(
    private val viewModelClass: Class<out BaseViewModel<S>>
) : MvRxViewModelFactory<VM, S> {

    override fun create(viewModelContext: ViewModelContext, state: S): VM? {
        return createViewModel(state)
    }

    private fun <VM : BaseViewModel<S>, S : MvRxState> createViewModel(state: S): VM {
        val viewModelFactoryMap = AppComponent.getInstance().viewModelFactories()
        val viewModelFactory = viewModelFactoryMap[viewModelClass]
        @Suppress("UNCHECKED_CAST")
        val castedViewModelFactory = viewModelFactory as? AssistedViewModelFactory<VM, S>
        val viewModel = castedViewModelFactory?.create(state)
        return viewModel as VM
    }
}