package com.testdagger.di.modules.activity;

import android.support.annotation.NonNull;

import com.testdagger.viewdata.TabsViewData;
import com.testdagger.viewmodel.TabsViewModel;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
@Module
public class TabsActivityModule {

    @Provides
    @ActivityScope
    static TabsViewModel provideViewModel(@NonNull TabsViewData viewData) {
        return new TabsViewModel(viewData);
    }

}
