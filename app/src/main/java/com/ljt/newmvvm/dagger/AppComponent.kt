package com.ljt.newmvvm.dagger

import android.content.Context
import com.ljt.newmvvm.MainApplication
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun context(): Context

    fun mainApplication(): MainApplication

    fun inject(mainApplication: MainApplication)

}