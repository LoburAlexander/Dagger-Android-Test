package com.testdagger.di.modules.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.testdagger.activity.TabsActivity;
import com.testdagger.di.qualifiers.ViewModelCreator;
import com.testdagger.viewdata.TabsViewData;
import com.testdagger.viewmodel.TabsViewModel;
import com.testdagger.viewmodel.interfaces.ITextObservable;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
@Module
public abstract class TabsActivityModule {
    private static final Class<TabsViewModel> VIEW_MODEL_CLASS = TabsViewModel.class;

    @Provides
    @ViewModelCreator
    @ActivityScope
    static TabsViewModel createViewModel(@NonNull TabsViewData viewData) {
        return new TabsViewModel(viewData);
    }

    @Provides
    @ActivityScope
    static TabsViewModel provideViewModel(@NonNull TabsActivity activity,
                                   @NonNull @ViewModelCreator Provider<TabsViewModel> viewModelProvider) {
        ViewModelProvider.Factory factory = new ProviderViewModelProviderFactory<>(VIEW_MODEL_CLASS, viewModelProvider);
        return ViewModelProviders.of(activity, factory).get(VIEW_MODEL_CLASS);
    }

    @Binds
    @ActivityScope
    abstract ITextObservable bindTextObservable(@NonNull TabsViewModel viewModel);
}
