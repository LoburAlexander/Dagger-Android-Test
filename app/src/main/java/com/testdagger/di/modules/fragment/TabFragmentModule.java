package com.testdagger.di.modules.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.testdagger.di.qualifiers.ViewModelCreator;
import com.testdagger.fragment.TabFragment;
import com.testdagger.viewdata.TabViewData;
import com.testdagger.viewmodel.TabViewModel;
import com.testdagger.viewmodel.interfaces.ITextObservable;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
@Module
public class TabFragmentModule {
    private final Class<TabViewModel> VIEW_MODEL_CLASS = TabViewModel.class;

    @Provides
    @ViewModelCreator
    @FragmentScope
    TabViewModel createViewModel(@NonNull TabViewData viewData, @NonNull ITextObservable textObservable) {
        Timber.d("createViewModel");
        return new TabViewModel(viewData, textObservable);
    }

    @Provides
    @FragmentScope
    TabViewModel provideViewModel(@NonNull TabFragment fragment,
                                  @NonNull @ViewModelCreator Provider<TabViewModel> viewModelProvider) {
        Timber.d("provideViewModel");
        ViewModelProvider.Factory factory = new ProviderViewModelProviderFactory<>(VIEW_MODEL_CLASS, viewModelProvider);
        return ViewModelProviders.of(fragment, factory).get(VIEW_MODEL_CLASS);
    }
}
