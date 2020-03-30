package com.example.multi_module_dagger_mvrx.daggerutils

import com.example.multi_module_dagger_mvrx.base.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass

///**
// * A [MapKey] for populating a map of ViewModels and their factories.
// */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ViewModelKey(val value: KClass<out BaseViewModel<*>>)