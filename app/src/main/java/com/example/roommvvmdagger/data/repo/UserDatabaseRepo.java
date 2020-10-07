package com.example.roommvvmdagger.data.repo;

import androidx.lifecycle.LiveData;

import com.example.roommvvmdagger.data.dao.UserDao;
import com.example.roommvvmdagger.data.entities.User;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class UserDatabaseRepo {
    private final UserDao userDao;

    @Inject
    public UserDatabaseRepo(UserDao userDao) {
        this.userDao = userDao;
    }

    public LiveData<List<User>> getAllUsers() {
        return userDao.getAllUsers();
    }

    public LiveData<User> getSpecificUsers(int userId) {
        return userDao.getSpecificUser(userId);
    }

    public void insertUser(final User user) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }

    public void deleteUser(User user) {
        userDao.insertUser(user);
    }

}
