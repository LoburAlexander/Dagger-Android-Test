package com.testdagger.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.testdagger.R;
import com.testdagger.activity.TabsActivity;
import com.testdagger.databinding.FragmentTabBinding;
import com.testdagger.di.qualifiers.ComponentRetainedInstance;
import com.testdagger.viewmodel.TabViewModel;
import com.testdagger.viewmodel.TabsViewModel;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabFragment extends BaseFragmentTest<TabViewModel, FragmentTabBinding> {

    @Inject
    TabsActivity mActivity;

    @Inject
    @ComponentRetainedInstance
    TabsViewModel mainViewModel;


    public TabFragment() {
        Timber.d("INIT. Fragment hash: %d", hashCode());
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("CREATE. Activity hash: %d, Fragment hash: %d, view model hash: %d", mActivity.hashCode(), hashCode(), mViewModel.hashCode());
        Timber.d("CREATE. Activity viewmodel hash: %d", mainViewModel.hashCode());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.vTvText.setOnClickListener(view1 -> {
            startActivity(new Intent(getContext(), TabsActivity.class));
        });
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
    protected int getLayoutRes() {
        return R.layout.fragment_tab;
    }
}
