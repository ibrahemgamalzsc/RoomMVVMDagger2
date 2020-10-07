package com.example.roommvvmdagger.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.roommvvmdagger.data.entities.User;
import com.example.roommvvmdagger.data.repo.UserDatabaseRepo;

import java.util.List;

import javax.inject.Inject;

public class GetAllUsersViewModel extends ViewModel {
    private UserDatabaseRepo userDatabaseRepo;

    @Inject
    public GetAllUsersViewModel(UserDatabaseRepo userDatabaseRepo) {
        this.userDatabaseRepo = userDatabaseRepo;
    }

    public LiveData<List<User>> getAllUsers() {
        return userDatabaseRepo.getAllUsers();
    }
}
