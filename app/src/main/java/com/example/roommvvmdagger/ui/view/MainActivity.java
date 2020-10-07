package com.example.roommvvmdagger.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roommvvmdagger.BaseApplication;
import com.example.roommvvmdagger.R;
import com.example.roommvvmdagger.data.entities.User;
import com.example.roommvvmdagger.databinding.ActivityMainBinding;
import com.example.roommvvmdagger.ui.adapter.ViewUsersAdapter;
import com.example.roommvvmdagger.ui.viewmodel.GetAllUsersViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ActivityMainBinding activityMainBinding;

    private GetAllUsersViewModel getAllUsersViewModel;

    private ViewUsersAdapter viewUsersAdapter;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);

        getAllUsersViewModel = new ViewModelProvider(this, viewModelFactory).get(GetAllUsersViewModel.class);

        viewUsersAdapter=new ViewUsersAdapter();

        activityMainBinding.showUserRv.setAdapter(viewUsersAdapter);

        getAllUsersViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                    viewUsersAdapter.submitList(users);
            }
        });
    }

    public void addNewUser(View view) {
        Intent intent = new Intent(MainActivity.this, AddNewActivity.class);
        startActivity(intent);
    }
}