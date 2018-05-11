package com.testdagger.fragment;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import by.mvvmwrapper.fragments.BaseFragmentSupport;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.android.support.AndroidSupportInjection;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public abstract class BaseFragmentTest <M extends BaseViewModel, B extends ViewDataBinding> extends BaseFragmentSupport<M, B> {
    @Inject
    M mBaseViewModel;

    public BaseFragmentTest() {
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @NonNull
    protected M initViewModel() {
        return mBaseViewModel;
    }
}