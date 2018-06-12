package com.testdagger.di.modules.activity;

import android.support.annotation.NonNull;

import com.testdagger.activity.MainActivity;
import com.testdagger.di.qualifiers.ComponentRetainedInstance;
import com.testdagger.di.utils.ViewModelDiUtils;
import com.testdagger.viewdata.MainViewData;
import com.testdagger.viewmodel.MainViewModel;

import javax.inject.Provider;

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
    @ComponentRetainedInstance
    static MainViewModel provideViewModel(@NonNull MainActivity activity,
                                          @NonNull Provider<MainViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(activity, MainViewModel.class, viewModelProvider);
    }

}
