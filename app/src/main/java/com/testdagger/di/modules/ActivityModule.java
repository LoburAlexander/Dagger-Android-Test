package com.testdagger.di.modules;

import com.testdagger.activity.MainActivity;
import com.testdagger.activity.TabsActivity;
import com.testdagger.di.modules.activity.MainActivityModule;
import com.testdagger.di.modules.activity.TabsActivityModule;
import com.testdagger.di.modules.fragment.injectors.TabFragmentInjectorModule;

import by.mvvmwrapper.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */
@Module
public interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = {
                    MainActivityModule.class
            })
    MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(
            modules = {
                    TabsActivityModule.class,
                    TabFragmentInjectorModule.class
            })
    TabsActivity tabsActivityInjector();

}
