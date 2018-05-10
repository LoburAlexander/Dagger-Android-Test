package com.testdagger.di.modules.activity;

import android.support.annotation.NonNull;

import com.testdagger.viewdata.MainViewData;
import com.testdagger.viewmodel.MainViewModel;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */

@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    static MainViewModel provideViewModel(@NonNull MainViewData viewData) {
        return new MainViewModel(viewData);
    }

}
