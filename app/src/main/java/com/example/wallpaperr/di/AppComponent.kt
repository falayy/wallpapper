package com.example.wallpaperr.di

import android.app.Application
import com.example.wallpaperr.di.viewmodel.ViewModelModule
import com.example.wallpaperr.mainscreen.FullImageUrlFragment
import com.example.wallpaperr.mainscreen.PictureGridFragment
import com.example.wallpaperr.workmanager.RefreshDataWork
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PixaBayServiceModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(target: PictureGridFragment)
    fun inject(target: FullImageUrlFragment)
    fun inject(target: RefreshDataWork)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(app: Application): Builder
    }
}
