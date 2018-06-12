package com.testdagger.fragment;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.testdagger.di.qualifiers.ComponentRetainedInstance;

import javax.inject.Inject;

import by.mvvmwrapper.fragments.BaseFragmentSupport;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.Lazy;
import dagger.android.support.AndroidSupportInjection;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public abstract class BaseFragmentTest <M extends BaseViewModel, B extends ViewDataBinding> extends BaseFragmentSupport<M, B> {
    @Inject
    @ComponentRetainedInstance
    Lazy<M> mViewModelProvider;

    public BaseFragmentTest() {}

    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @NonNull
    protected M initViewModel() {
        return mViewModelProvider.get();
    }
}