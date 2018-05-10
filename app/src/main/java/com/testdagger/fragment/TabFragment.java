package com.testdagger.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.testdagger.R;
import com.testdagger.databinding.FragmentTabBinding;
import com.testdagger.viewmodel.TabViewModel;

import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabFragment extends BaseFragment<TabViewModel, FragmentTabBinding> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("CREATE. Fragment hash: %d, view model hash: %d", hashCode(), mViewModel.hashCode());
    }


    @Override
    protected Class<TabViewModel> getViewModelClass() {
        return TabViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab;
    }
}
