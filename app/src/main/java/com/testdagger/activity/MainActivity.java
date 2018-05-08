package com.testdagger.activity;

import android.os.Bundle;

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

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

}
