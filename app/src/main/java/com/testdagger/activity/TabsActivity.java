package com.testdagger.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.testdagger.R;
import com.testdagger.databinding.ActivityTabsBinding;
import com.testdagger.fragment.TabFragment;
import com.testdagger.viewmodel.TabsViewModel;

import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabsActivity extends BaseActivity<TabsViewModel, ActivityTabsBinding> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("Activity hash: %d, view model hash: %d", hashCode(), mViewModel.hashCode());

        mViewModel.setViewCallbacks(mViewCallbacks);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();

        mViewModel.init();
    }

    @Override
    protected Class<TabsViewModel> getViewModelClass() {
        return TabsViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_tabs;
    }


    private void openTab() {
        FragmentManager manager = getSupportFragmentManager();
        if(manager != null) {
            TabFragment fragment = new TabFragment();

            manager.beginTransaction()
                    .replace(R.id.vFlContainer, fragment)
                    .commitNow();
        }
    }


    private TabsViewModel.ViewCallbacks mViewCallbacks = new TabsViewModel.ViewCallbacks() {
        @Override
        public void replaceFragment() {
            openTab();
        }
    };
}
