package com.example.wallpaperr.di

import android.app.Application
import com.example.wallpaperr.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PixaBayServiceModule::class, ViewModelModule::class])
interface AppComponent {

    //fun inject(target: BreedListFragment)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(app: Application): Builder
    }
}
