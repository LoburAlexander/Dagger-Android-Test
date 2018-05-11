package com.testdagger.di.modules.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.testdagger.activity.TabsActivity;
import com.testdagger.di.qualifiers.ViewModelCreator;
import com.testdagger.viewdata.TabsViewData;
import com.testdagger.viewmodel.TabsViewModel;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import dagger.Module;
import dagger.Provides;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
@Module
public class TabsActivityModule {
    private final Class<TabsViewModel> VIEW_MODEL_CLASS = TabsViewModel.class;

    @Provides
    @ViewModelCreator
    @ActivityScope
    TabsViewModel createViewModel(@NonNull TabsViewData viewData) {
        return new TabsViewModel(viewData);
    }

    @Provides
    @ActivityScope
    TabsViewModel provideViewModel(@NonNull TabsActivity activity,
                                   @NonNull @ViewModelCreator Provider<TabsViewModel> viewModelProvider) {
        ViewModelProvider.Factory factory = new ProviderViewModelProviderFactory<>(VIEW_MODEL_CLASS, viewModelProvider);
        return ViewModelProviders.of(activity, factory).get(VIEW_MODEL_CLASS);
    }

}
