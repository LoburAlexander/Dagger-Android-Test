package com.testdagger.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.testdagger.databinding.ActivityMainBinding;
import com.testdagger.viewdata.MainViewData;

import javax.inject.Inject;

import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */
public class MainViewModel extends BaseViewModel<MainViewData> {
    @Inject
    public MainViewModel(@NonNull MainViewData viewData) {
        super(viewData);
    }


    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ActivityMainBinding binding = (ActivityMainBinding) viewDataBinding;
        binding.setData(mViewData);
    }


    @Override
    public void onStart() {
        super.onStart();
        mViewData.setMessage("Message from view model");
    }
}
