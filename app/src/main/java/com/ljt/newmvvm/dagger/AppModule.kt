package com.ljt.newmvvm.dagger

import android.content.Context
import com.ljt.newmvvm.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class AppModule{

    private var application: MainApplication

    constructor(mainApplication: MainApplication){
        this.application = mainApplication
    }

    @Provides
    fun provideAppContext(): Context{
        return application.applicationContext
    }

     @Provides
    fun provideMainApplication(): MainApplication{
        return application
    }

}