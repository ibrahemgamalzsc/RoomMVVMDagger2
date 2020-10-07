package com.example.roommvvmdagger.data.entities;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() &&
                getUsername().equals(user.getUsername()) &&
                getEmail().equals(user.getEmail()) &&
                getPassword().equals(user.getPassword());
    }


    public static DiffUtil.ItemCallback<User> callback = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.getUserId() == newItem.getUserId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.equals(newItem);
        }
    };
}
