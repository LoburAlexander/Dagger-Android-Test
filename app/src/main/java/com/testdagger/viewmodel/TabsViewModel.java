package com.testdagger.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.testdagger.databinding.ActivityTabsBinding;
import com.testdagger.viewdata.TabsViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabsViewModel extends BaseViewModel<TabsViewData> {
    private boolean contentAvailable = false;

    @Nullable
    private ViewCallbacks mViewCallbacks;


    public TabsViewModel(@NonNull TabsViewData viewData) {
        super(viewData);
    }


    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ActivityTabsBinding binding = (ActivityTabsBinding) viewDataBinding;
        binding.setData(mViewData);
    }


    public void setViewCallbacks(@Nullable ViewCallbacks viewCallbacks) {
        this.mViewCallbacks = viewCallbacks;
    }


    public void init() {
        if(mViewCallbacks != null) {
            if(!contentAvailable) {
                contentAvailable = true;
                mViewCallbacks.replaceFragment();
            }
        }
    }


    public interface ViewCallbacks {
        void replaceFragment();
    }
}
