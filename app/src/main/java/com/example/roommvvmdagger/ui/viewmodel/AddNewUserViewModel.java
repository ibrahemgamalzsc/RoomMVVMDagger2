package com.example.roommvvmdagger.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roommvvmdagger.data.entities.User;
import com.example.roommvvmdagger.data.repo.UserDatabaseRepo;

import javax.inject.Inject;

public class AddNewUserViewModel extends ViewModel {
    public MutableLiveData<String> username;
    public MutableLiveData<String> email;
    public MutableLiveData<String> password;
    private UserDatabaseRepo userDatabaseRepo;

    @Inject
    public AddNewUserViewModel(UserDatabaseRepo userDatabaseRepo) {
        this.userDatabaseRepo = userDatabaseRepo;
        username = new MutableLiveData<>();
        email = new MutableLiveData<>();
        password = new MutableLiveData<>();
    }

    public void insertUser(User user) {
        userDatabaseRepo.insertUser(user);
    }

    public void onAddClick() {
        User user = new User(
                username.getValue(),
                email.getValue(),
                password.getValue()
        );
        insertUser(user);
    }
}
