package com.testdagger.activity;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import by.mvvmwrapper.activity.BaseAppCompatActivity;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/11/18.
 */
public abstract class BaseActivityTest <M extends BaseViewModel, B extends ViewDataBinding> extends BaseAppCompatActivity<M, B>
        implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    M mBaseViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState, persistentState);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    @NonNull
    protected M initViewModel() {
        return mBaseViewModel;
    }
}
