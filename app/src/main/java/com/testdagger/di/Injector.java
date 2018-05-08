package com.testdagger.di;

import com.testdagger.application.App;
import com.testdagger.di.components.ApplicationComponent;
import com.testdagger.di.components.DaggerApplicationComponent;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */

public final class Injector {
    private Injector() {}

    private static ApplicationComponent sApplicationComponent;

    public static void init(App app) {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .application(app)
                .build();
        sApplicationComponent.inject(app);
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
