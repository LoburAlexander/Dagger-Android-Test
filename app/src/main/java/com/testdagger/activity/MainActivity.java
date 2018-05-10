package com.testdagger.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.testdagger.R;
import com.testdagger.databinding.ActivityMainBinding;
import com.testdagger.viewmodel.MainViewModel;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Inject
    Resources mResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Timber.d("Activity hash: %d, view model hash: %d", hashCode(), mViewModel.hashCode());
        Timber.d("Resources hash: %d", mResources.hashCode());

        mBinding.vTvMessage.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, TabsActivity.class));
        });
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
