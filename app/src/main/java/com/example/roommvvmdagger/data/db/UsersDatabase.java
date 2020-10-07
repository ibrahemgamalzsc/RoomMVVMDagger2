package com.example.roommvvmdagger.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roommvvmdagger.data.dao.UserDao;
import com.example.roommvvmdagger.data.entities.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
