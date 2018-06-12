package com.testdagger.di.modules.activity;

import android.support.annotation.NonNull;

import com.testdagger.activity.TabsActivity;
import com.testdagger.di.qualifiers.ComponentRetainedInstance;
import com.testdagger.di.utils.ViewModelDiUtils;
import com.testdagger.viewmodel.TabsViewModel;
import com.testdagger.viewmodel.interfaces.ITextObservable;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
@Module
public abstract class TabsActivityModule {

    @Provides
    @ActivityScope
    @ComponentRetainedInstance
    static TabsViewModel provideViewModel(@NonNull TabsActivity activity,
                                          @NonNull Provider<TabsViewModel> viewModelProvider) {
        Timber.d("provideViewModel");
        return ViewModelDiUtils.provideViewModel(activity, TabsViewModel.class, viewModelProvider);
    }

    @Binds
    @ActivityScope
    abstract ITextObservable bindTextObservable(@NonNull @ComponentRetainedInstance TabsViewModel viewModel);

}
