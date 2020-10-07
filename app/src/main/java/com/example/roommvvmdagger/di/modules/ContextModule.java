package com.example.roommvvmdagger.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.roommvvmdagger.BaseApplication;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public  class ContextModule {
    private final BaseApplication application;
    public ContextModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    BaseApplication provideRoomDemoApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}
