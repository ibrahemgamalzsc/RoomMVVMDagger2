package com.example.roommvvmdagger.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.roommvvmdagger.BaseApplication;
import com.example.roommvvmdagger.R;
import com.example.roommvvmdagger.databinding.ActivityAddnewBinding;
import com.example.roommvvmdagger.ui.viewmodel.AddNewUserViewModel;

import javax.inject.Inject;

public class AddNewActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory factory;

    private AddNewUserViewModel addNewUserViewModel;

    private ActivityAddnewBinding activityAddnewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityAddnewBinding= DataBindingUtil.setContentView(this,R.layout.activity_addnew);

        ((BaseApplication) getApplication()).getAppComponent().inject(this);

        addNewUserViewModel=new ViewModelProvider(this,factory).get(AddNewUserViewModel.class);

        activityAddnewBinding.setAddNewUserViewModel(addNewUserViewModel);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}