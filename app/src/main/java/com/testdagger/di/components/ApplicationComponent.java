package com.testdagger.di.components;

import android.app.Application;

import com.testdagger.application.App;
import com.testdagger.di.modules.ActivityModule;
import com.testdagger.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */

@Singleton
@Component( modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,

        ActivityModule.class
})

public interface ApplicationComponent {
    void inject(App app);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
