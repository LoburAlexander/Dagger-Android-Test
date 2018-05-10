package com.testdagger.viewmodel;

import android.support.annotation.NonNull;

import by.mvvmwrapper.viewdata.ViewData;
import by.mvvmwrapper.viewmodel.SimpleViewModelImpl;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */
public abstract class BaseViewModel <TViewData extends ViewData> extends SimpleViewModelImpl<TViewData> {
    public BaseViewModel() {
        super();
    }

    public BaseViewModel(@NonNull TViewData viewData) {
        super(viewData);
    }
}
