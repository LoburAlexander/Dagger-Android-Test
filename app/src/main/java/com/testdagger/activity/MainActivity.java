package com.testdagger.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.testdagger.R;
import com.testdagger.databinding.ActivityMainBinding;
import com.testdagger.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    protected MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

}
