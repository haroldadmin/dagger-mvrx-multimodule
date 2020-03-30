package com.example.multi_module_dagger_mvrx.base

import com.airbnb.mvrx.MvRxState

interface AssistedViewModelFactory<VM : BaseViewModel<S>, S : MvRxState> {
    fun create(state: S): VM
}

typealias FactoriesMap = Map<Class<out BaseViewModel<*>>, AssistedViewModelFactory<*, *>>