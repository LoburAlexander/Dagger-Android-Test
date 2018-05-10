package com.testdagger.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.testdagger.databinding.ActivityTabsBinding;
import com.testdagger.viewdata.TabsViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabsViewModel extends BaseViewModel<TabsViewData> {
    public TabsViewModel(@NonNull TabsViewData viewData) {
        super(viewData);
    }


    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ActivityTabsBinding binding = (ActivityTabsBinding) viewDataBinding;
        binding.setData(mViewData);
    }

}
