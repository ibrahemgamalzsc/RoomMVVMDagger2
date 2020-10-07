package com.example.roommvvmdagger;

import android.app.Application;

import com.example.roommvvmdagger.di.component.AppComponent;
import com.example.roommvvmdagger.di.component.DaggerAppComponent;
import com.example.roommvvmdagger.di.modules.ContextModule;
import com.example.roommvvmdagger.di.modules.UserDatabaseModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().contextModule(new ContextModule(this)).userDatabaseModule(new UserDatabaseModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
