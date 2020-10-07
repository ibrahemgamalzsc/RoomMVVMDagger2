package com.example.roommvvmdagger.di.component;

import com.example.roommvvmdagger.di.modules.ContextModule;
import com.example.roommvvmdagger.di.modules.UserDatabaseModule;
import com.example.roommvvmdagger.ui.view.AddNewActivity;
import com.example.roommvvmdagger.ui.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UserDatabaseModule.class, ContextModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(AddNewActivity addNewActivity);
}
