package com.testdagger.activity;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.testdagger.di.qualifiers.ComponentRetainedInstance;

import javax.inject.Inject;

import by.mvvmwrapper.activity.BaseAppCompatActivity;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.Lazy;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/11/18.
 */
public abstract class BaseActivityTest <M extends BaseViewModel, B extends ViewDataBinding> extends BaseAppCompatActivity<M, B>
        implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    @ComponentRetainedInstance
    Lazy<M> mViewModelProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("inject");
        AndroidInjection.inject(this);
        Timber.d("onCreate");
        super.onCreate(savedInstanceState);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    @NonNull
    protected M initViewModel() {
        Timber.d("provide view model");
        return mViewModelProvider.get();
    }
}
