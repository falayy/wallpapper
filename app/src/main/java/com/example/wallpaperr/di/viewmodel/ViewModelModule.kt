package com.example.wallpaperr.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallpaperr.images.ImageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ImagesAppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ImageViewModel::class)
    abstract fun bindContactSourcesViewModel(viewModel: ImageViewModel): ViewModel

    // TODO Add other ViewModels.
}
