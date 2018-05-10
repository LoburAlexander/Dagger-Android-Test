package com.testdagger.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.testdagger.R;
import com.testdagger.activity.TabsActivity;
import com.testdagger.databinding.FragmentTabBinding;
import com.testdagger.viewmodel.TabViewModel;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabFragment extends BaseFragment<TabViewModel, FragmentTabBinding> {

    @Inject
    TabsActivity mActivity;


    public TabFragment() {
        Timber.d("INIT. Fragment hash: %d", hashCode());
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("CREATE. Activity hash: %d, Fragment hash: %d, view model hash: %d", mActivity.hashCode(), hashCode(), mViewModel.hashCode());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.d("DESTROY. Activity hash: %d, Fragment hash: %d", mActivity.hashCode(), hashCode());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Timber.d("ATTACH. Activity hash: %d, Fragment hash: %d", getActivity().hashCode(), hashCode());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Timber.d("DETACH. Activity hash: %d, Fragment hash: %d", mActivity.hashCode(), hashCode());
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
