package com.example.multi_module_dagger_mvrx.core

import com.example.multi_module_dagger_mvrx.base.FactoriesMap
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {

    fun viewModelFactories(): FactoriesMap

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance viewModelFactories: FactoriesMap
        ): AppComponent
    }

    companion object {
        private var instance: AppComponent? = null

        fun storeInstance(instance: AppComponent) {
            this.instance = instance
        }

        fun getInstance(): AppComponent {
            require(instance != null) {
                "AppComponent requested without being initialized first. Call initAppComponent() before" +
                        "requesting an instance."
            }
            return instance!!
        }
    }
}

@Module
object AppModule {

    @Provides
    fun viewModelFactories(viewModelFactories: FactoriesMap): FactoriesMap {
        return viewModelFactories
    }

}
