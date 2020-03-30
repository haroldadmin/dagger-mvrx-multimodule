# Multi Module Dagger-MvRx Sample

This project demonstrates how to use Dagger and MvRx together in a multi module app.

It is an adaptation of the [hellodagger](https://github.com/airbnb/MvRx/tree/master/hellodagger) sample app from the MvRx repository.

Key things to note:
* All feature modules declare their own Dagger `@Module` class which binds their ViewModel factories into a Dagger Multibindinds map
* ViewModel Factories are collected in a `ViewModelFactoriesComponent`.
* The `ViewModelFactoriesComponent` lies inside the `vmfactories` module, which depends on all feature modules
* The `core` module contains the `AppComponent`, which takes in an instance of the map of `ViewModelFactory`, and makes it available
for everyone to use.
* `AppModule` exists solely for the purpose of providing an `@Provides` annotated method for these ViewModelFactories. Ideally, this should not be needed
because we provide Dagger with an instance of these ViewModel Factories inside the Component Builder with `@BindsInstance`, but Dagger does not understand how
to make provisions for such dependencies directly.
