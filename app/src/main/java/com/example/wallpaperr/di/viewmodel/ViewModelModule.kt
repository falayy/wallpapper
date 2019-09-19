package com.example.wallpaperr.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ExampleAppViewModelFactory): ViewModelProvider.Factory

   /* @Binds
    @IntoMap
    @ViewModelKey(BreedListViewModel::class)
    abstract fun bindContactSourcesViewModel(viewModel: BreedListViewModel): ViewModel
*/
    // TODO Add other ViewModels.
}
