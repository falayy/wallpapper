package com.example.wallpaperr.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ExampleAppViewModelFactory): ViewModelProvider.Factory

   @Binds
    @IntoMap
    @ViewModelKey(ImageViewModel
    ::class)
    abstract fun bindContactSourcesViewModel(viewModel: ImageViewModel): ViewModel

    // TODO Add other ViewModels.
}
