package com.testdagger.fragment;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.mvvmwrapper.fragments.BaseDaggerFragmentSupport;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.android.support.AndroidSupportInjection;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public abstract class BaseFragment<TViewModel extends BaseViewModel, TDataBinding extends ViewDataBinding>
        extends BaseDaggerFragmentSupport<TViewModel, TDataBinding> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(false);
    }

    @Override
    public void onAttach(Context context) {
//        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
