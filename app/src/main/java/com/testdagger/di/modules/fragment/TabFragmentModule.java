package com.testdagger.di.modules.fragment;

import android.support.annotation.NonNull;

import com.testdagger.viewdata.TabViewData;
import com.testdagger.viewmodel.TabViewModel;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
@Module
public class TabFragmentModule {

    @Provides
    @FragmentScope
    static TabViewModel provideViewModel(@NonNull TabViewData viewData) {
        return new TabViewModel(viewData);
    }

}
