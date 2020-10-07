package com.example.roommvvmdagger.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.roommvvmdagger.di.annotations.ViewModelKey;
import com.example.roommvvmdagger.ui.viewmodel.AddNewUserViewModel;
import com.example.roommvvmdagger.ui.viewmodel.GetAllUsersViewModel;
import com.example.roommvvmdagger.ui.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GetAllUsersViewModel.class)
    abstract ViewModel bindGetAllUsersViewModel(GetAllUsersViewModel getAllUsersViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AddNewUserViewModel.class)
    abstract ViewModel bindAddNewUserViewModel(AddNewUserViewModel addNewUserViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory viewModelFactory);


}
