package com.testdagger.fragment;

import android.databinding.ViewDataBinding;

import by.mvvmwrapper.fragments.BaseDaggerFragmentSupport;
import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public abstract class BaseFragment<TViewModel extends BaseViewModel, TDataBinding extends ViewDataBinding>
        extends BaseDaggerFragmentSupport<TViewModel, TDataBinding> {
}
