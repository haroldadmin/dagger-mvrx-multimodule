package com.example.multi_module_dagger_mvrx.base

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.BuildConfig
import com.airbnb.mvrx.MvRxState

abstract class BaseViewModel<S: MvRxState>(
    initialState: S
) : BaseMvRxViewModel<S>(initialState, BuildConfig.DEBUG)
