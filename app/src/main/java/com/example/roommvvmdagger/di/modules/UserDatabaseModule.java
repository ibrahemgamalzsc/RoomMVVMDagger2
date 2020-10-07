package com.example.roommvvmdagger.di.modules;

import android.app.Application;

import androidx.room.Room;

import com.example.roommvvmdagger.data.dao.UserDao;
import com.example.roommvvmdagger.data.db.UsersDatabase;
import com.example.roommvvmdagger.data.repo.UserDatabaseRepo;
import com.example.roommvvmdagger.ui.viewmodel.GetAllUsersViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class UserDatabaseModule {
    private final UsersDatabase usersDatabase;

    public UserDatabaseModule(Application application) {
        this.usersDatabase = Room.databaseBuilder(application,UsersDatabase.class,"Users.db")
                .fallbackToDestructiveMigration()
                .build();
    }


    @Singleton
    @Provides
    UserDatabaseRepo provideUserDatabaseRepo(UserDao userDao){
        return new UserDatabaseRepo(userDao);
    }

    @Singleton
    @Provides
    UserDao getUserDao(UsersDatabase usersDatabase){
        return usersDatabase.userDao();
    }

    @Singleton
    @Provides
    UsersDatabase usersDatabase(Application application){
        return usersDatabase;
    }
}
