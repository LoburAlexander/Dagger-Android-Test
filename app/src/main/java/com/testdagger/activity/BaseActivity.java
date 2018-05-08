package com.testdagger.activity;

import android.databinding.ViewDataBinding;

import by.mvvmwrapper.activity.BaseDaggerAppCompatActivity;
import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */

public abstract class BaseActivity<TViewModel extends BaseViewModel, TDataBinding extends ViewDataBinding>
        extends BaseDaggerAppCompatActivity<TViewModel, TDataBinding> {
}
