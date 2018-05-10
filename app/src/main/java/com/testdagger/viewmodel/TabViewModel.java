package com.testdagger.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.testdagger.databinding.FragmentTabBinding;
import com.testdagger.viewdata.TabViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabViewModel extends BaseViewModel<TabViewData> {

    public TabViewModel(@NonNull TabViewData viewData) {
        super(viewData);
    }


    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        FragmentTabBinding binding = (FragmentTabBinding) viewDataBinding;
        binding.setData(mViewData);
    }
}
