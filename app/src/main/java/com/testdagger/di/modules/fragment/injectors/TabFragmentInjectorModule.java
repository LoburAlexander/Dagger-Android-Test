package com.testdagger.di.modules.fragment.injectors;

import com.testdagger.di.modules.fragment.TabFragmentModule;
import com.testdagger.fragment.TabFragment;

import by.mvvmwrapper.dagger.scope.FragmentScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
@Module
public interface TabFragmentInjectorModule {

    @FragmentScope
    @ContributesAndroidInjector(
            modules = {
                    TabFragmentModule.class
            })
    TabFragment tabFragmentInjector();

}
