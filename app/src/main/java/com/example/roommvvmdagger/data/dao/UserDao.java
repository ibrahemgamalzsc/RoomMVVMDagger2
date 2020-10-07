package com.example.roommvvmdagger.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roommvvmdagger.data.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users_table")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM users_table WHERE userId =:userId")
    LiveData<User> getSpecificUser(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUser(User user);

    @Delete
    void deleteUser(User user);
}
