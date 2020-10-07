package com.example.roommvvmdagger.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roommvvmdagger.data.entities.User;
import com.example.roommvvmdagger.databinding.UserItemHolderBinding;

public class ViewUsersAdapter extends ListAdapter<User, ViewUsersAdapter.UserViewHolder> {
    public ViewUsersAdapter() {
        super(User.callback);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        UserItemHolderBinding userItemHolderBinding = UserItemHolderBinding.inflate(layoutInflater, parent, false);
        return new UserViewHolder(userItemHolderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user=getItem(position);
        holder.userItemHolderBinding.setUser(user);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        UserItemHolderBinding userItemHolderBinding;
        public UserViewHolder(@NonNull UserItemHolderBinding userItemHolderBinding) {
            super(userItemHolderBinding.getRoot());
            this.userItemHolderBinding=userItemHolderBinding;
        }
    }
}
