package com.testdagger.di.modules.fragment;

import android.support.annotation.NonNull;

import com.testdagger.di.qualifiers.ComponentRetainedInstance;
import com.testdagger.di.utils.ViewModelDiUtils;
import com.testdagger.fragment.TabFragment;
import com.testdagger.viewdata.TabViewData;
import com.testdagger.viewmodel.TabViewModel;
import com.testdagger.viewmodel.interfaces.ITextObservable;

import javax.inject.Provider;

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
    @ComponentRetainedInstance
    TabViewModel provideViewModel(@NonNull TabFragment fragment,
                                  @NonNull Provider<TabViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(fragment, TabViewModel.class, viewModelProvider);
    }

}
